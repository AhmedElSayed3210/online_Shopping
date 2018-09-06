/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import Database.query;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmed ElSayed
 */
public class cart extends HttpServlet {

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
        String id = (String) request.getParameter("id");
        String name = (String) request.getParameter("name");
        String price = (String) request.getParameter("price");
        String quantity = (String) request.getParameter("quantity");
        String image = (String) request.getParameter("nmage");
        String model = (String) request.getParameter("model");
        String itmes = (String) request.getParameter("itmes");
        Model.cart c = new Model.cart();
        c.setProduct_info_id(Integer.parseInt(id));
        c.setName(name);
        c.setQuantity(Integer.parseInt(quantity));
        c.setPrice(Integer.parseInt(price));
        c.setNimage(image);
        c.setModel(model);
        c.setTotal_quantity(itmes);
        c.setId(Integer.parseInt(id));
         query db=new query();
        boolean flag=db.updat(Integer.parseInt(id), (Integer.parseInt(itmes)-Integer.parseInt(quantity)));
          c.add(c);   
       
       
        request.setAttribute("id", id);
        request.getRequestDispatcher("product_details.jsp").forward(request, response);
//response.sendRedirect("product_details.jsp");

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
