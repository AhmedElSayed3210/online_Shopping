/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import Database.user_query;
import Model.user;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmed ElSayed
 */
public class register extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String fname=(String)request.getParameter("fname"); 
        String lname=(String)request.getParameter("lname"); 
        String email=(String)request.getParameter("email").trim(); 
        String pass=(String)request.getParameter("pass"); 
        String nid=(String)request.getParameter("nid"); 
        String day=(String)request.getParameter("day"); 
        String month=(String)request.getParameter("month"); 
        String year=(String)request.getParameter("year"); 
        String address1=(String)request.getParameter("address1"); 
        String address2=(String)request.getParameter("address2"); 
        String city=(String)request.getParameter("city"); 
        String state=(String)request.getParameter("state"); 
        String zip=(String)request.getParameter("zip"); 
        String country=(String)request.getParameter("country"); 
        String addinfo=(String)request.getParameter("addinfo"); 
        String hphone=(String)request.getParameter("hphone"); 
        String mphone=(String)request.getParameter("mphone"); 
        String date=day+"/"+month+"/"+year;
        String msg="";
       
         boolean flag=false;
        try {
            user u = new user();
            pass=pass.trim();
            pass=u.encur_pass(pass);
           user_query db=new user_query();
         flag=db.adduser(fname, lname, email, pass, nid, date, address1, address2, city, state, zip, country, addinfo, hphone, mphone);
          
        } catch (Exception e) {
        }
       
        if (flag) {
            
          RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
        
        }
        else{
            msg="0";
        request.setAttribute("msg", msg);
          RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
        
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
