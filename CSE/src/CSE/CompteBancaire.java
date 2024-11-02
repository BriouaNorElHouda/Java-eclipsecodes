package CSE;

public class CompteBancaire {
	private double balance;
	
	public CompteBancaire(double balance) {
		
		this.balance=balance;
	}
	
	 
	public synchronized void retrait(int montat) throws InterruptedException {
		while(balance<montat) {
			this.wait();
			balance =balance-montat;
	}
	}
	
	public synchronized void depot(int montat) {
		
			balance =balance+montat;
			this.notifyAll();
	}
	

}
