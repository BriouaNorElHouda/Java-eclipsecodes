package model;

import model.DeliveryGuy;
import model.Item;
import model.DeliveryGuy.Status;

public class Agent {
	    private int numAg;
	    private String ipAddress;
	    private String firstname;
	    private String lastname;
	    private String email;
	    private String psswrd;
	    private String phoneNumber;
	  
	    

	    public Agent(int numAg,String ipAddress, String firstname,String lastname,String email, String psswrd, String phoneNumber) {
	    	 this.numAg = numAg;
	    	this.ipAddress = ipAddress;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.email = email;
	        this.psswrd = psswrd;
	        this.phoneNumber = phoneNumber;
	        
	    }

	    
	    public DeliveryGuy createDeliveryGuy(int numD,String firstname, String lastname, String email, String psswrd, String phoneNumber, model.DeliveryGuy.Status status) {
	     
	    	DeliveryGuy newDeliveryGuy = new DeliveryGuy( numD,firstname, lastname, email, psswrd, phoneNumber,status);
	        return newDeliveryGuy; 
	    }
	    

	    public Item createItem(String name, String description, Double price) {
	        Item newItem = new Item(name, description, price);
	        return newItem;
	    }

	    public String getIpAddress() {
	        return ipAddress;
	    }

	    public void setIpAddress(String ipAddress) {
	        this.ipAddress = ipAddress;
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


		public String getPsswrd() {
			// TODO Auto-generated method stub
			return psswrd;
		}


		public String getPhoneNumber() {
			// TODO Auto-generated method stub
			return phoneNumber;
		}
	}


