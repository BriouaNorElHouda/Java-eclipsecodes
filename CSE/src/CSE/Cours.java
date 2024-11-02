package CSE;

public class Cours {
	public static void main(String[]Args) {
	//boolean[] Choosing;
	//Choosing = new boolean[20];
	
	
		boolean[] Choosing = new boolean[5];
		int[]Number = new int[5];
		
		for(int k=0;k<=5;k++) {
			
			Choosing[k] = false ; 
			Number[k] = 0 ;

	
	Processusi onep = new Processusi();

	Thread one = new Thread(onep);
	Thread two = new Thread(onep);
	Thread Three = new Thread(onep);
	Thread four = new Thread(onep);
	Thread Five = new Thread(onep);
	
	one.start();
	two.start();
	Three.start();
	four.start();
	Five.start();
	
	
	
	

}
	
	
	}}
