package CSE;

import java.util.Arrays;

public class automate {

	public static void main (String[]Args) {
	
		int tab[]= new int[50];
		int temp[]= new int [50];
				
				//{0,0,0,1,1,1,1,0};
		
		//initialisation
		for(int i =0;i<=49;i++) {
			temp[i]=0;
			temp[25]=1;
			
	}
		String str=Integer.toBinaryString(54);
		System.out.println("le tab est"+str);
		for(int i=2;i<=49;i++) {
			
					if(i==1){
						temp[i-1]=0;
								};
					
					if(temp[i-1]==0 && temp[i]==0 && temp[i+1]==0 ) {
						tab[i]=0;
					}
					if(temp[i-1]==0 && temp[i]==0 && temp[i+1]==1 ) {
						tab[i]=1;
						
					}
					if(temp[i-1]==0 && temp[i]==1 && temp[i+1]==0 ) {
						tab[i]=1;
					}
					if(temp[i-1]==0 && temp[i]==1 && temp[i+1]==1 ) {
						tab[i]=1;
					
					}
					if(temp[i-1]==1 && temp[i]==0 && temp[i+1]==0 ) {
						tab[i]=1;
					
					}
					if(temp[i-1]==1 && temp[i]==0 && temp[i+1]==1 ) {
						tab[i]=0;
					}
					if(temp[i-1]==1 && temp[i]==1 && temp[i+1]==0 ) {
						tab[i]=0;
					}
					if(temp[i-1]==1 && temp[i]==1 &&  temp[i+1]==1 ) {
						tab[i]=0;
					}
					//System.out.println("le tab est"+Arrays.toString(tab));
		}
	
		
		//System.out.println("le tab est"+Arrays.toString(tab));
		
	
	
}
}