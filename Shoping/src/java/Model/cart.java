/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Ahmed ElSayed
 */
public class cart {

    static ArrayList<cart> idcart = new ArrayList<cart>();

    private String name;
    private String model;
    private String nimage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String total_quantity;
    private int id;

    public String getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(String total_quantity) {
        this.total_quantity = total_quantity;
    }

    public String getNimage() {
        return nimage;
    }

    public void setNimage(String nimage) {
        this.nimage = nimage;
    }
    private double price;

    private int quantity;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    private int product_info_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<cart> getIdcart() {
        return idcart;
    }

    public void setIdcart(ArrayList<cart> idcart) {
        this.idcart = idcart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_info_id() {
        return product_info_id;
    }

    public void setProduct_info_id(int product_info_id) {
        this.product_info_id = product_info_id;
    }

    public void add(cart c) {

        idcart.add(c);

    }

}
