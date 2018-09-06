/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import Database.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ahmed ElSayed
 */
public class admindb {

    // select cart data
    public static ResultSet getcart(int receved) {
        ResultSet set = null;
        try {
            String sql = "select cart.id ,cart.product,cart.Quntity,cart.price,cart.date,user.Fname,user.Lname"
                    + ",user.email,user.homephone,user.city,user.country,user.state  "
                    + "from cart  INNER JOIN user ON cart.user_id=user.id where cart.receved='" + receved + "' order by cart.date ASC";

            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }
    // select contact data
    public static ResultSet contact() {
        ResultSet set = null;
        try {
            String sql = "select *  from contact order by date desc";

            PreparedStatement ps = DB.conn().prepareStatement(sql);

            set = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;

    }
     // Order Don
     public boolean updat_order(int receved,int id){
         boolean x=false;
        try {
            PreparedStatement stmt=null;
            String query = "update cart set receved=?  where id='" + id + "' ";
            stmt = DB.conn().prepareStatement(query);
            stmt.setInt(1, receved);
           
             x=stmt.execute();
            
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
     return x;
     }

}
