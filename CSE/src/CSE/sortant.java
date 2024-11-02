package CSE;

import java.util.concurrent.Semaphore;

public class sortant extends Thread {
   int Np=0;
	Semaphore Parking;
	Semaphore Barriere;
	Semaphore Passerelle;
	Semaphore mutex;
	
	public sortant(Semaphore Parking,Semaphore Passerelle,Semaphore mutex) {
		  this.Parking= Parking;
		  this.Passerelle= Passerelle;
		  this.mutex= mutex;
		
	  }
	
	public void run() {
		Parking.release();
		mutex.acquireUninterruptibly();
		Np++;
		if(Np==1) {
			Passerelle.acquireUninterruptibly();
		}
		mutex.release();
		System.out.println("Vehicule"+Thread.currentThread().getId()+ "sortante");
		mutex.acquireUninterruptibly();
		Np--;
		if(Np==0) {
			Passerelle.release();
			mutex.release();
		}
		
}
}