package CSE;
import java.util.concurrent.Semaphore;
public class mayyne {


	public static void main(String[] args) {
		
		Semaphore feu1 = new Semaphore(0,true);
		Semaphore feu0 = new Semaphore(0,true);
		Semaphore mutex = new Semaphore(1,true);
		
		
		
		for(int i=0;i<10;i++) {
			new traverse0(feu0,mutex).start();
			new travers1(feu1,mutex).start();
		
		}
		

	
	}}

	
	

