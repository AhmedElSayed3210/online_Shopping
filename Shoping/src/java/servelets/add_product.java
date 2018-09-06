/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import Database.query;
import Model.user;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ahmed ElSayed
 */
public class add_product extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String imgname = "dd";
     String msg = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
         MultipartRequest mp = new MultipartRequest(request, getServletContext().getRealPath("/images/"), 200 * 2048 * 2048, new FileRenamePolicy() {

            @Override
            public File rename(File file) {
                System.out.println(file.getName());
                imgname = file.getName();
                return file;
            }
        });
        String name = mp.getParameter("name");
        String price = mp.getParameter("price");
        String Quantity = mp.getParameter("Quantity");
        String model  = mp.getParameter("model");
        String part = mp.getParameter("part");
        String size = mp.getParameter("size");
        String color = mp.getParameter("color");
        String features = mp.getParameter("features");
        int id=0;
        HttpSession ses=request.getSession(false);
        user u=new user();
        u=(user) ses.getAttribute("userinfo");
            if (u==null) {
              response.sendRedirect("index.jsp");
            }else{
         id=(int)u.getId();
        
        System.out.println(id+"  000000000000000000000000000");
        query db=new query();
        boolean flag = db.add_product(name, Double.parseDouble(price),Integer.parseInt(Quantity), model, part, size, features,color, imgname,id);
       
        
         if (flag == true) {
             msg="1";
             imgname="";
        } else {
             msg="0";
             
             request.setAttribute("name", name);
             request.setAttribute("price", price);
             request.setAttribute("Quantity", Quantity);
             request.setAttribute("model", model);
             request.setAttribute("part", part);
             request.setAttribute("size", size);
             request.setAttribute("features", features);
             request.setAttribute("image", imgname);
             request.setAttribute("color", color);
        }
            }
         request.setAttribute("msg", msg);
          RequestDispatcher rd = request.getRequestDispatcher("add_product.jsp");
        rd.forward(request, response);
        
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
