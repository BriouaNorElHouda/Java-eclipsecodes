package CSE;

public class deposer extends Thread{
	
	CompteBancaire CompteBancaire;
	int montat;
	
	public void run() {
		

			CompteBancaire.depot(montat);
		
	}
}
