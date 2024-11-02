package model;

import java.util.ArrayList;
import java.util.Date;

import model.Address;
import model.Client;
import model.Order;

public class Client {
    private String profilePhotoPath;
    private String firstname;
    private String lastname;
    private String email;
    private String psswrd;
    private String phoneNumber;
    private int clientId;
    private ArrayList<Order> orders;

	 
    
    
    
    public Client( int clientId,String firstname, String lastname, String email, String psswrd, String phoneNumber,String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.psswrd = psswrd;
        this.phoneNumber = phoneNumber;
        this.clientId = clientId;
        this.orders = new ArrayList<>();
    }

   
    public Client createClient(int Number,String firstname, String lastname, String email, String psswrd, String phoneNumber,String profilePhotoPath) {
        Client newClient = new Client(Number,firstname, lastname, email, psswrd, phoneNumber, profilePhotoPath);
        return newClient; 
        
    }
    
    
    public Order createOrder(int numO, String review,Date createdAt,Date confirmedAt,Date deliveredAt, int evaluation,Address destination,Address source) {
        Order newOrder = new Order(numO, review, evaluation, createdAt, confirmedAt, deliveredAt, Order.Status.DRAFT, destination, source);
        orders.add(newOrder);
        return newOrder;
    }
    public void confirmOrder(Order o) {
        System.out.println("Order confirmed by client");
    }

    // Méthode avis sur une commande
    public void review(Order o, int rating, String comment) {
        System.out.println("Review added by client for order: " + o.getOrderNumber());
    }


    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }


	public ArrayList<Order> getOrder() {
		// TODO Auto-generated method stub
		return orders;
	}

	public void addOrder(model.Order order) {
		// TODO Auto-generated method stub
		
	}
	

	public int getId() {
	    return clientId;
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

