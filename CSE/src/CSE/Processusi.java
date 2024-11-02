package CSE;

import java.util.Arrays;

import java.util.Random;

public class Processusi implements Runnable{

	
	
	@Override
	public void run() {
		boolean[] Choosing = new boolean[5];
		int[]Number = new int[]  {0, 0, 0, 0, 0}; 
		
		
		 
		
		 
		 for (int i = 0; i <5; i++) {  
			 Choosing[i] = true ;
	          
	     
	       		for (int J = 0; J<=5;J++){

	       		while(Choosing[J]) { } ;
	       		while (Number[J] != 0 && (Number[J]<Number[i]) || ((Number[J]==Number[i]&& J<i) )) { } ;
	       		}
	       		

}}}
