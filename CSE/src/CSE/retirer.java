package CSE;

public class retirer extends Thread{
	
	CompteBancaire CompteBancaire;
	int montat;
	public void run() {
		
		
		try {
			CompteBancaire.retrait(montat);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
