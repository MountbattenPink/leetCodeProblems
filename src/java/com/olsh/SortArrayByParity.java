package com.olsh;

/**
#905. Sort Array By Parity
Given an array A of non-negative integers, return an array consisting of all the even 
elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 
Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
*/

class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1; //two pointers from both sides
        while (i <= j) { //until pointers meet each other
				//just do nothing, continue, all is already ok
            if (A[i] % 2 == 0 && A[j] % 2 == 1) {
                i++;
                j--;
			//odd is to the left, even is to the right -> swap elements
            } else if (A[i] % 2 == 1 && A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
		//both are even : left number is ok, right should be swapped with some odd number -> 
		//need to find for it odd number to the left. thus, we can take next left number
            } else if (A[i] % 2 == 0 && A[j] % 2 == 0) {
                i++;
		//both are odd : right number is ok, left should be swapped with some even number -> 
		//need to find for it even number to the right. thus, we can take next right number
            } else if (A[i] % 2 == 1 && A[j] % 2 == 1) {
                j--;
            }
        }
        return A;
    }
}
