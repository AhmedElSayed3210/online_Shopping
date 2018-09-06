/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ahmed ElSayed
 */
public class user {

    private int id;
    private String fname;
    private String lname;
    private String phone;
    private String city;
    private String email;
    private int admin = 0;

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String encur_pass(String pass) {
        int x;
        String newpass = "";
        for (int i = 0; i < pass.length(); i++) {
            x = (int) pass.charAt(i);
            newpass += x;
        }

        return newpass;
    }

    public static void main(String[] args) {
        System.out.println(encur_pass("123"));
    }
}
