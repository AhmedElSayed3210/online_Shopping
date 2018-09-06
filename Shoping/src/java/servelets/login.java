/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import Database.user_query;
import Model.user;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ahmed ElSayed
 */
public class login extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            String username = (String) request.getParameter("user");
            String pass = (String) request.getParameter("pass");
            if (!(username.contains("@")&&username.contains(".com"))) {
                 response.sendRedirect("login.jsp"); 
            }
            user u = new user();
            pass=pass.trim();
            pass=u.encur_pass(pass);
            user_query db = new user_query();
            ResultSet rs = db.usersearch(username, pass);
            HttpSession ses = request.getSession();
            ses.setMaxInactiveInterval(999999999);
            
            if (rs.next()) {
                u.setFname(rs.getString("fname"));
                u.setLname(rs.getString("lname"));
                u.setEmail(rs.getString("email"));
                u.setId(rs.getInt("id"));
                u.setCity(rs.getString("city"));
                u.setPhone(rs.getString("homePhone"));
                u.setAdmin(rs.getInt("admin"));
                ses.setAttribute("userinfo", u);
                if (rs.getInt("admin")!=0) {
                  response.sendRedirect("admin.jsp");  
                }else{
                response.sendRedirect("index.jsp");
            }}else{
            response.sendRedirect("login.jsp");
            }
        } catch (Exception ex) {
            System.out.println(ex);
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
