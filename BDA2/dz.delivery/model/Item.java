package model;

import java.util.HashSet;
import java.util.Set;

import model.OrderLine;

import java.sql.*;

public class Item {
	private int Numberr;
    private String name;
    private String description;
    private Double price;
    private Set<OrderLine> rOrderLine;
    
	public Item(int Numberr, String name, String description, Double price) {
		rOrderLine =new HashSet<OrderLine>();
		this.rOrderLine = new HashSet<>();}
	
	public void addOrderLineI(OrderLine orderline) {
		if(!getOrderLine().contains(orderline))
			getOrderLine().add(orderline);
			
	}
	public void removeOrderLineI(OrderLine orderline) {
		if( !getOrderLine().contains(orderline)) getOrderLine().remove(orderline);
	}
	
	public Set<OrderLine> getOrderLine(){ return rOrderLine;}
	public void setOrderLinem(Set<OrderLine> orderline) {this.rOrderLine = orderline;}
	
    public Item(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
      
    }

    public void updateItemInfo(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

	public int getNumber() {
		// TODO Auto-generated method stub
		return Numberr;
	}
}

