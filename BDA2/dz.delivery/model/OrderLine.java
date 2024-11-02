package model;

import model.Item;
import model.Order;

public class OrderLine {
    private Integer quantity;
    private Integer numOL;
    private String photoFilePath;
    private Order order;
    private Item item;
    

    public OrderLine(int numOL, String photoFilePath,Integer quantity) {
        this.quantity = quantity;
        this.photoFilePath = photoFilePath;
        this.numOL = numOL;
     
    }

    public Integer getnumOL() {
        return numOL;
    }

    public void setnumOL(Integer numOL) {
        this.numOL =numOL;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPhotoFilePath() {
        return photoFilePath;
    }

    public void setPhotoFilePath(String photoFilePath) {
        this.photoFilePath = photoFilePath;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getPrice() {
        return item.getPrice();
    }

    public void addItem(Item i1) {
        this.item = i1;
    }
}

