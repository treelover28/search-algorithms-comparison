package lai.NegativeNumberSearchAlgos;
/*
 * Khai Lai
 * COMP 2673 
 * Assignment 2- Algorithm Analysis
 * Professor Mohammed Albow 
 * T.A Dalton Crutchfield and T.A Lombe Chileshe
 */

public class Search {

	public static boolean searchSequential(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) // n+1
		{
			for (int j = 0; j < arr.length; j++) // n(n+1)
			{
				if(arr[i] == (arr[j] * -1))
				{
					if (i != j) // it doesn't count the negative of itself as a match
					{
						return true; 
					}
					// worst case scenario: on false cases
					// we would have to fully traverse both loops
					// T = (n+1)C1 + n(n+1)C2 
					// T = O(n^2)
				}	
			}
		}
		return false;
	}
	
	public static boolean searchBinary(int[] arr) // O(n)
	{		
		for (int x: arr) // n+1
		{
			int first = 0;
			int last = arr.length;
			int checkValue = (x * -1);
			while (first < last) // log_2(n) for the single while loop, since it repeats for each x
				// in total, the while-loop repeats for n*log_2(n) for the worst case scenario
				
				// Explanation for log_2(n)
				// n+ n/2 + n/4 + n/8 + ... + 1
				// n+ n/2 + n/2^2 + n/2^3 + ... + n/2^k + 1
				// 1 = n/2^k
				// 2^k = n
				// k log2 = log n
				// k = log_2(n)
				
				// thus the while loop iterates for n(log_2(n))
				// T = (n+1)C1 + (log_2(n))nC2 
				// T = O(nlog_2(n)) 
			{	
				int middle = (first + last)/ 2;
//				System.out.println("arr[middle] = " + arr[middle] + " compared with y = " + checkValue);
				if (arr[middle] == checkValue & (checkValue != 0 | arr[middle] != 0)) 
					// this algorithm tends to mess up when zero is involved
					// because it counts -0 ( which is just 0) as a negative of 0 
					// so any array like 0,1,2,3,4 which return true because
					// it counts 0 as a negative of itself.
				{
					return true;
				}
				else if (checkValue < arr[middle]) 	
				{
					last = middle;
				}
				else
				{
					first = middle+1;
				}
			}
		}
		return false;
	}
	
	public static boolean searchIndex(int[] arr)
	{
		int i = 0;
		int j = arr.length - 1;
		int sum =( arr[i] + arr[j]);
		while (sum != 0) 
			// worst case: keep iterating from both ends inward until i==j, roughly 0.5n so O(n)
		{
			if (sum < 0)
			{
				i++;
			}
			else if (sum > 0)
			{
				j--;
			}
			sum =( arr[i] + arr[j]); // calculate new sum for next loop iteration
			// if sum == 0 here, would not enter next loop iteration 
			// return true instead
			if (i == j)
			{
				return false;
			}
		}
		return true;
	
	}
}
