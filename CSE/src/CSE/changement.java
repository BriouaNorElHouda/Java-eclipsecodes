package CSE;

import java.util.concurrent.Semaphore;

public class changement extends Thread{
	
	
	  Semaphore feu0;
	  Semaphore feu1;
	  
	  
	      public changement(Semaphore feu1,Semaphore feu0) {
		  this.feu1= feu1;
		  this.feu0= feu0;
		  
	  
	  }
	      public void run() {
	    	  int tour =0;
	    	 
		 
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (tour==0) {
			tour=1;
			feu0.acquireUninterruptibly();
			feu1.release();
			System.out.println("Traversee1");
		}
		else {
			tour=0;
			feu1.acquireUninterruptibly();
			feu0.release();
			System.out.println("Traversee0");
			
		}}}