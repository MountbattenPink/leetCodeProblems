package com.olsh;

/**
#300. Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?


*/
class
LongestIncreasingSubsequence {
 
public int lengthOfLIS(int[] nums){
            	int[] lengths = new int[nums.length];
            	for (int i=0;i<nums.length;i++){
                    lengths [i]=1;
            		for (int j=0;j<i;j++){
            			if (nums[i]>nums[j]){
                            			if (lengths[i]<=lengths[j]){
                                            			lengths[i] = lengths[j]+1;
                                                  }
                                  }
                  }
                }
              int result= 0;
              for (int i=0;i<lengths.length;i++){
                  if (lengths[i]>result){
		              result=lengths[i];
                  } 
              }
    return result;
  }
}
