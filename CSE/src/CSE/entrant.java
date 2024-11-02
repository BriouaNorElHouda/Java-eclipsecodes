package CSE;
import java.util.concurrent.Semaphore;
public class entrant extends Thread {

	
	Semaphore Parking;
	Semaphore Barriere;
	Semaphore Passerelle;
	Semaphore mutex;
	
	public entrant(Semaphore Parking,Semaphore Barriere,Semaphore Passerelle,Semaphore mutex) {
		  this.Parking= Parking;
		  this.Barriere= Barriere;
		  this.Passerelle= Passerelle;
		  this.mutex= mutex;
		
		
	  }
	
	public void run() {
		Parking.acquireUninterruptibly();
		Barriere.acquireUninterruptibly();
		Passerelle.acquireUninterruptibly();
		System.out.println("Vehicule"+Thread.currentThread().getId()+ "entrant");
		Passerelle.release();
		Barriere.release();
		System.out.println("Vehicule"+ Thread.currentThread().getId()+"est entrain de se garer");
}
}