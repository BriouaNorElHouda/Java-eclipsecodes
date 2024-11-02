package model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Address;
import model.Client;
import model.DeliveryGuy;
import model.OrderLine;

public class Order {
    public enum Status {
        CONFIRMED,
        DELIVERED, DRAFT
    }

    private int numO;
    Address destination;
    private Status status;
    private String review;
    private int evaluation;
    private Date createdAt;
    private Date confirmedAt;
    private Date deliveredAt;
    Address source;
    private List<OrderLine> orderLines;
    private Client client;
    private DeliveryGuy deliveryGuy;

    public Order(int numO,String review,int evaluation,Date createdAt,Date confirmedAt,Date deliveredAt ,Status status,Address destination,Address source ) {
        this.status = Status.DRAFT;
        this.createdAt = new Date(); 
        this.destination=destination;
        this.source=source;
        this.numO=numO;
        this.evaluation=evaluation;
        this.orderLines = new ArrayList<>();
        
    }
    
    private Set<OrderLine> rOrderLine;
	public Order() {rOrderLine =new HashSet<OrderLine>();}
	public void addOrderLineO(OrderLine orderline) {
		if(!getOrderLine().contains(orderline))
			getOrderLine().add(orderline);
			
	}
	public void removeOrderLine(OrderLine orderline) {
		if( !getOrderLine().contains(orderline)) getOrderLine().remove(orderline);
	}
	
	public Set<OrderLine> getOrderLine(){ return rOrderLine;}
	public void setOrderLinem(Set<OrderLine> orderline) {this.rOrderLine = orderline;}
    
	public List<OrderLine> getOrderLines() {
	    return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
	    this.orderLines = orderLines;
	}


    public void updateStatus(Status s) {
        this.status = s;
        if (s == Status.CONFIRMED) {
            this.confirmedAt = new Date();
        } else if (s == Status.DELIVERED) {
            this.deliveredAt = new Date();
        }
    }

  
    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
    }
    public Double getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderLine ol : orderLines) {
            totalPrice += ol.getPrice();
        }
        return totalPrice;
    }
  

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public Date getDeliveredAt() {
        return deliveredAt;
    }
    public Address getDestination() {
        return destination;
    }
    public Address getSource() {
        return source;
    }
    public void addAddressDes(Address a2Des) {
        this.destination = a2Des; 
    }

    public Address getCity() {
        if (destination != null) {
            return destination;
        } else {
            return null;
        }}
 
    public int getOrderNumber() {
        return numO;
    }

    public void addClient(Client c1) {
        this.client = c1;
        c1.addOrder(this); 
    }

    public Address getAddressDes() {
        return destination;
    }
	public Address getAddressSrc() {
		// TODO Auto-generated method stub
		return source;
	}
	  public void addDeliveryGuy(DeliveryGuy deliveryGuy) {
	        this.deliveryGuy = deliveryGuy;
	        deliveryGuy.addOrder(this); 
	    }
	 
	  public DeliveryGuy getDeliveryGuy() {
	        return deliveryGuy;
	    }

	    public Client getClient() {
	        return client;
	    }

	    public void setCreatedAt(Date createdAt) {
	        this.createdAt = createdAt;
	    }

	    public void setConfirmedAt(Date confirmedAt) {
	        this.confirmedAt = confirmedAt;
	    }

	    public void setDeliveredAt(Date deliveredAt) {
	        this.deliveredAt = deliveredAt;
	    }
		public void addAddressSrc(Address source2) {
			// TODO Auto-generated method stub
			
		}
}
