package CSE;

public class mmain {

	public static void main(String[] args) throws InterruptedException {
		
		Thread CompteBancaire = new Thread(()->{
			
			CompteBancaire bnk = new CompteBancaire(10000);
			bnk.depot(2000);
			sleep(4000);
			
			try {
				bnk.retrait(1500);
	            } catch (InterruptedException e) {
	                throw new RuntimeException(e);
	            }
			
		});
		CompteBancaire.start();
	}

	private static void sleep(int i) {
		// TODO Auto-generated method stub
		
	}
}
