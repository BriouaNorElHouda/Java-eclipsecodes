package CSE;
import java.util.concurrent.Semaphore;

public class mayne {
	
		
		static int np=0;
		static int N=5;
		
		 static  Semaphore Parking = new Semaphore(N);
		 static Semaphore Barriere = new Semaphore(1,true);
		 static  Semaphore Passerelle = new Semaphore(1,true);
		 static Semaphore mutex = new Semaphore(1,true);
		
		
		
		public static void main(String[] args) {
		for(int i=1;i<100;i++) {
			new entrant(Barriere, Parking, Passerelle, mutex).start();
			new sortant(Parking, Passerelle, mutex).start();
		}
		}
	}
	

