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
public class query {

    static PreparedStatement ps = null;
    static Statement st = null;
    static ResultSet rs = null;

   // add new proudect
    public static boolean add_product(String name, double price, int qountity, String model, String part, String size, String featuer,String color, String nimage,int usr_id) {
        boolean flag = false;
        try {
            String sql = "insert into product_info (name ,price, Quantity, model,releasedon,size,features,color,nimage,PRODUCTS_id,USER_id) values (?, ?,?,?,?,? ,?,?,?,?,?)";
            PreparedStatement ps = DB.conn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, qountity);
            ps.setString(4, model);

            ps.setString(5, new java.sql.Date(System.currentTimeMillis()).toString());

            ps.setString(6, size);
            ps.setString(7, featuer);
            ps.setString(8, color);
            ps.setString(9, nimage);

            if (part.equals("Electronics")) {
                ps.setInt(10, 1);
            } else if (part.equals("Clothes")) {
                ps.setInt(10, 2);
            } else if (part.equals("Sport")) {
                ps.setInt(10, 3);
            } else if (part.equals("Books")) {
                ps.setInt(10, 4);
            } else if (part.equals("Food")) {
                ps.setInt(10, 5);
            } else if (part.equals("Other")) {
                ps.setInt(10, 6);
            }else{
             ps.setInt(10, 6);
            }
      
            ps.setInt(11, usr_id);
            int x = ps.executeUpdate();

            if (x == 0) {
                flag = false;
            } else {
                flag = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    }

   // select products
    public static ResultSet select_product() {
        ResultSet set = null;
        try {
            String sql = "select * from product_info order by releasedon desc";
            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }
   // select products by department
    public static ResultSet selectbytype(int typ ) {
        ResultSet set = null;
        try {
            String sql = "select * from product_info where PRODUCTS_id='"+typ+ "' order by releasedon desc";
            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }
     // select products where product_id
    public static ResultSet selectbytypecondition(int typ,String order ) {
        ResultSet set = null;
        try {
            String sql = "select * from product_info where PRODUCTS_id='"+typ+ "' order by "+order+"";
            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }
   // select products where
    public static ResultSet selectbyid(int id) {
        ResultSet set = null;
        try {
            String sql = "select * from product_info where id='"+id+"'";
            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }
   // select products where user id
    public static ResultSet selectbyuserid(int id) {
        ResultSet set = null;
        try {
            String sql = "select * from product_info where User_id='"+id+"'";
            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }


/// count the products
public static int count(int id){
      ResultSet set=null;
        int c=0;
        try {
            String sql = "select * from product_info where PRODUCTS_id='"+id+"'";
            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
            while (set.next()) {                
               c++; 
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
return c;
}
/// count the user products
public static int user_products_count(int id){
      ResultSet set=null;
        int c=0;
        try {
            String sql = "select * from product_info where user_id='"+id+"'";
            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
            while (set.next()) {                
               c++; 
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
return c;
}

/// delete product
 public  boolean deleteproduct(String id ,int userid){
        boolean flag=false;
        try {
            String sql="delete  from product_info where id =? and user_id=?";
            PreparedStatement ps=DB.conn().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ps.setInt(2, userid);
          int  x=ps.executeUpdate();
            if (x>=0) {
                flag=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return flag;
    
    }

 
   //  new contact messege
    public static boolean contact(String name, String email, String subject, String problem) {
        boolean flag = false;
        try {
            String sql = "insert into contact (name ,email, subject, problem,date) values (?, ?,?,?,?)";
            PreparedStatement ps = DB.conn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, subject);
            ps.setString(4, problem);
            ps.setString(5, new java.sql.Date(System.currentTimeMillis()).toString());
            int x = ps.executeUpdate();
            if (x == 0) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    }
 
    
      // search
    public static ResultSet search(int typ,String order,String key ) {
        ResultSet set = null;
        try {
             String sql="";
            if (typ==0) {
                sql = "select * from product_info where  name like '" + key + "%' order by "+order+"";
            }else{
           sql = "select * from product_info where PRODUCTS_id='"+typ+ "' and name like '" + key + "%' order by "+order+"";
            }
           PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }
    
    // add new proudect
    public static boolean add_to_cart(String name, double price, int qountity,int usr_id,int product_info_id,int recev) {
        boolean flag = false;
        try {
            String sql = "insert into cart (product ,price, Quntity,date,USER_id,product_info_id,receved) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = DB.conn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, qountity);
            ps.setString(4, new java.sql.Date(System.currentTimeMillis()).toString());
            ps.setInt(5, usr_id);
            ps.setInt(6, product_info_id);
            ps.setInt(7, recev);
            int x = ps.executeUpdate();

            if (x == 0) {
                flag = false;
            } else {
                flag = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    }

    // select cart data
     public static ResultSet getcart(int receved,int id) {
        ResultSet set = null;
        try {
             String sql= "select * from cart where receved='"+receved+"' and User_id='"+id+"'";
           
           PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }
     // update product item
     public boolean updat(int id,int item){
         boolean x=false;
        try {
            PreparedStatement stmt=null;
            String query = "update product_info set Quantity=?  where id='" + id + "' ";
            stmt = DB.conn().prepareStatement(query);
            stmt.setInt(1, item);
           
             x=stmt.execute();
            
        } catch (Exception ex) {
            System.out.println(ex+"11111");
            return false;
        }
     return x;
     }
    
    public static void main(String[] args) {
     
  
}

}
