package CSE;

import java.util.concurrent.Semaphore;

public class travers1 extends Thread{

		  Semaphore feu1;
		  Semaphore mutex;
		  
		  public travers1(Semaphore feu1,Semaphore mutex) {
			  this.feu1= feu1;
			  this.mutex= mutex;
			  
		  }
		  
		  
		  
	public void run() {
		
		mutex.acquireUninterruptibly();
		feu1.acquireUninterruptibly();
		System.out.println(Thread.currentThread().getName()+"traverser carrefour1");
		feu1.release();
		mutex.release();
	}}


