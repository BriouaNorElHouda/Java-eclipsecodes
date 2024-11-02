package CSE;

public class testmax {
	public static void main(String[] args) {
	    int[] arr = {0, 0, 0, 0, 0};

	    int max = calculateMax(arr);

	    System.out.println("Max value: " + max);
	}

	private static int calculateMax(int[] arr) {
		 int max = Integer.MIN_VALUE;

		    // Find the max value in the array
		    for (int i = 0; i < arr.length; i++) {
		        if (arr[i] > max) {
		            max = arr[i];
		        }
		    }

		    // If the max is zero, add one to each element and try again
		    if (max == 0) {
		        for (int i = 0; i < arr.length; i++) {
		            arr[i]++;
		        }

		        max = calculateMax(arr);
		    }

		    return max;
		}

	
}
