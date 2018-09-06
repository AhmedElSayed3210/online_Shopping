/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed ElSayed
 */
public class user_query {
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    
    
    // add new user
     public  static boolean adduser(String fname,String lname,String email,String pass,String nationalid,String date,String address1,String address2,String city,
     String stat,String zip,String country,String adinfo,String hphone,String mophone){
         boolean flag=false;
        try {
            PreparedStatement ps=DB.conn().prepareStatement("insert into user (Fname,Lname,Email,Nationalid,password,birthDate,Address1,Address2,"
                    + "City,State,ZipCode,Country,AdditionalInfo,homephone,MobilePhone) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
       ps.setString(1, fname);
       ps.setString(2, lname);
       ps.setString(3, email);
       ps.setString(4, nationalid);
       ps.setString(5, pass);
       ps.setString(6, date);
       ps.setString(7, address1);
       ps.setString(8, address2);
       ps.setString(9, city);
       ps.setString(10, stat);
       ps.setString(11, zip);
       ps.setString(12, country);
       ps.setString(13, adinfo);
       ps.setString(14, hphone);
       ps.setString(15, mophone);
    int x= ps.executeUpdate();  
            if (x>0) {
              flag=true;  
            }
        } catch (SQLException ex) {
            System.out.println("*************************          "+ex);
        }
        return flag;
}
   
    
     // login function
      public static ResultSet usersearch(String username,String pass){
    ResultSet set=null;
        try {
            PreparedStatement ps=DB.conn().prepareStatement("select * from user where email=? and password=?");
            ps.setString(1, username);
            ps.setString(2, pass);
            
            set= ps.executeQuery();
         
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
      return set;
    }
     // email check
      public static ResultSet emailsearch(String username){
          ResultSet rs=null;
        try {
            PreparedStatement ps=DB.conn().prepareStatement("select * from user where email=? ");
            ps.setString(1, username);
           rs= ps.executeQuery();
          
        } catch (SQLException ex) {
            System.out.println(ex);
        }
      return rs;
    }
      
      /// delete account
 public  boolean deleteaccount(int id){
        boolean flag=false;
        try {
            if (deleteproducts(id)) {
                String sql="delete  from user where id =?";
            PreparedStatement ps=DB.conn().prepareStatement(sql);
            ps.setInt(1, id);
          int  x=ps.executeUpdate();
            if (x>=0) {
                flag=true;
            }
            }else{
            flag=false;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return flag;
    
    }
 
 /// delete all user product
 public static boolean deleteproducts(int id ){
        boolean flag=false;
        try {
            String sql="delete  from product_info where  user_id=?";
            PreparedStatement ps=DB.conn().prepareStatement(sql);
            ps.setInt(1,id);
          int  x=ps.executeUpdate();
            if (x>=0) {
                flag=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return flag;
    
    }
 
// update password
 public boolean updatpass(String pass,int id){
         boolean x=false;
        try {
            PreparedStatement stmt=null;
            String query = "update user set password=?  where id='" + id + "' ";
            stmt = DB.conn().prepareStatement(query);
            stmt.setString(1, pass);
             x=stmt.execute();
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
     return x;
     }
      
      // test
        public static void main(String[] args) {
    }
}
