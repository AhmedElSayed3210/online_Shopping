/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import Database.query;
import Model.user;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ahmed ElSayed
 */
public class finaly_cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        query db = new query();
        HttpSession ses = request.getSession(false);
        user u = new user();
        u = (user) ses.getAttribute("userinfo");
        if (u == null) {
            response.sendRedirect("login.jsp");
        } else {
            Model.cart c = new Model.cart();
            ArrayList<Model.cart> car = new ArrayList<>();
            car = c.getIdcart();
            boolean flag;
            for (int i = 0; i < car.size(); i++) {
                flag = db.add_to_cart(car.get(i).getName(), car.get(i).getPrice(), car.get(i).getQuantity(), u.getId(), car.get(i).getProduct_info_id(), 0);
                if (!flag) {
                    request.setAttribute("msg", "0");
                    response.sendRedirect("product_summary.jsp");
                }
            }
            car.removeAll(car);
            response.sendRedirect("user_order.jsp");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
