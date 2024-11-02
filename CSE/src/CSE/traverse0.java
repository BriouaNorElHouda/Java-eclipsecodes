package CSE;

import java.util.concurrent.Semaphore;

public class traverse0 extends Thread{

	  Semaphore feu0;
	  Semaphore mutex;
	 
	  public traverse0(Semaphore feu0,Semaphore mutex) {
		  this.feu0= feu0;
		  this.mutex= mutex;
		 
	  }
	  
	  
public void run() {
	
	
	mutex.acquireUninterruptibly();
	feu0.acquireUninterruptibly();
	System.out.println(Thread.currentThread().getName()+"traverser carrefour0");
	feu0.release();
	mutex.release();
}}
