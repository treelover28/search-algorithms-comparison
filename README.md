# search-algorithms-comparison
Compare 3 simple search algorithms and their running time growths in Big-O notations

## Problem Statement
Suppose you have a sorted array of integers and would like to determine if there exists an element x, such that x and -x are both in the array.  For example:

* For the array <-4, -2, 1, 3, 5, 7, 9>, the algorithm returns false, because there is no element whose negative is in the array
* For the array <-4, -2, 1, 2, 3, 5, 7, 9> then the algorithm returns true, since 2 and -2 are both in the array

I coded 3 different searching algorithms to see if x's negative is in the array and tested the algorithms' worst-case running times in Big-O notations relative to n, the lenght of the array:
* A naive sequential search| O(n^2).
* A binary search | O(nlog_2(n))
* A index-based search | O(n)

**More details in code**

Timing of algorithm was done for different input sizes:
* 25,000
* 50,000
* 100,000
* 200,000
* 400,000
