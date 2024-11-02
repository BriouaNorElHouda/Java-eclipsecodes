package model;

import java.util.HashSet;
import java.util.Set;

import model.Order;


public class DeliveryGuy {
    public enum Status {
        ACTIVE,
        INACTIVE
    }

	
	private int numD;
    private String firstname;
    private String lastname;
    private String email;
    private String psswrd;
    private String phoneNumber;
    private Status status;
    private Set<Order> GOrders;
  
    
    public DeliveryGuy(int numD,String firstname, String lastname, String email, String psswrd, String phoneNumber,Status status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.psswrd = psswrd;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.numD = numD;
        this.GOrders = new HashSet<>();
      
    }

    // confirmer livraison
    public void confirmDelivery(Order o) {
        System.out.println("Delivery confirmed for order: " + o.getOrderNumber());
    }


    public Set<Order> getMyOrders() {
        return GOrders;
    }

    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

	public int getnumD() {
		// TODO Auto-generated method stub
		return numD;
	}

	public void addOrder(model.Order o1) {
		// TODO Auto-generated method stub
		
	}

	public String getFirstname() {
		// TODO Auto-generated method stub
		return firstname;
	}

	public String getLastname() {
		// TODO Auto-generated method stub
		return lastname;
	}


	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}


	public String getPassword() {
		// TODO Auto-generated method stub
		return psswrd;
	}


	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return phoneNumber;
	}

	

}

