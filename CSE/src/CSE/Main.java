package CSE;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random rand = new Random();
        int max = 0;

        while (!Arrays.equals(arr, new int[]{0, 1, 0, 0, 0})) {
            int index = rand.nextInt(5);
            System.out.println(index);
            arr[index]++;
            System.out.println(index);
            max = Arrays.stream(arr).max().getAsInt();

            // If the max value is greater than the index + 1, reset the index value to zero
            if (max > arr[index]) {
            	max = arr[index] +1;
            	
            	
            }
            
            
        }

        System.out.println(Arrays.toString(arr)+max);
    }
}
