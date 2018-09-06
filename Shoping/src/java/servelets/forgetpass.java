/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import Database.query;
import Database.user_query;
import admin.sendmail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ahmed ElSayed
 */
public class forgetpass extends HttpServlet {

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
            String emai=request.getParameter("email");
            System.out.println(emai);
            user_query db=new user_query();
            HttpSession ses=request.getSession(true);
            String[] to = { emai };
            ResultSet rs=db.emailsearch(emai.trim());
            Random rand = new Random();
            if (rs.next()) {
                sendmail m=new sendmail();
                int x= rand.nextInt(88) + 23;
                long pass=x*234;
                ses.setAttribute("resetcode", pass);
                String msg="your Reset Password code is " + pass;
                boolean fl= m.sendFromGMail(to, "Reset Password",msg );
                if (fl) {
                    System.out.println(rs.getInt("id")+"///////");
                    System.out.println(pass+"///////");
                    ses.setAttribute("id", rs.getInt("id"));
                    response.sendRedirect("resetpass.jsp");
                }else{
                    request.setAttribute("msg", "invalid email");
                   response.sendRedirect("forgetpass.jsp");
                }
            }else{
                request.setAttribute("msg", "invalid email");
                request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
            }   } catch (SQLException ex) {
            System.out.println(ex+"    here");
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
