package lai.NegativeNumberSearchAlgos;
import java.util.Arrays;

/*
 * Khai Lai
 * COMP 2673 
 * Assignment 2- Algorithm Analysis
 * Professor Mohammed Albow 
 * T.A Dalton Crutchfield and T.A Lombe Chileshe
 */

public class Driver 
{
	public static void main(String[] args) 
	{
		int numRange = 5000; // generate number 1 to 5000
		System.out.println("Size\t\tTime");
		for (int size = 25000; size < 500000; size *= 2) // test on input sizes 25k, 50k, 100k, 200k, 400k
		{
			int[] arr = new int[size];
			int count = 20000; // repeat the experiment at each input size for 20,000 times
			long sumTime = 0;
			for( int c = 0; c < count; c++)
			{
				// test the search algorithm on a different, randomly-created array each count
				for (int i= 0; i < arr.length; i++)
				{
					double ran = Math.random();

					if (ran <= 0) // 0% chance of getting a negative number
						// Professor told me to test on mainly false cases to get an idea 
						// of how the algorithm runs in the worst scenario, so my ran is 0 currently
						// to test on ALL FALSE CASES
						// if there are many true cases, the algorithm could exit out early,
						// running time would be very unpredictable (shown in Excel)
						
						// change this number higher to 0.2, 0.5 to see how the 
						// algorithm's running time becomes unpredictable.
						// as more and more true cases are mixed in.
					{
						arr[i] = (((int) (Math.random() * numRange)) + 1) * -1;
					}
					else
					{
						arr[i] =(((int) (Math.random() * numRange)) + 1);
					}
				}
				Arrays.sort(arr); // sort array
				
				long start = System.currentTimeMillis();
				Search.searchBinary(arr);				
				// Uncomment to try other searches

//				Search.searchIndex(arr);
//				Search.searchSequential(arr);
				long end = System.currentTimeMillis();
				
				sumTime += (end - start); // totals up all running time across all counts 
			}
			System.out.println(size+"\t\t"+ (float) (sumTime)/count); // sum/count gives the average running time for each input size
		}
//		int[] arr = new int[10];
//		for (int i = 0; i < 10; i++)
//		{
//			arr[i] = i ;
//		}
//		System.out.println(Search.searchBinary(arr));
	}
	
	public static String printArr(int[] arr) // used for diagnostic purposes
	{
		StringBuilder sb = new StringBuilder("List: ");
		for (int i = 0; i < arr.length; i++ )
		{
			sb.append(arr[i] + " ");
		}
		return sb.toString();
	}

}
