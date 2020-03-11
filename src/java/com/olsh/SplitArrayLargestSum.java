/*
410. Split Array Largest Sum
Hard
Given an array which consists of non-negative integers and an integer m, you can split 
the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
Note:
If n is the length of array, assume the following constraints are satisfied:
    1 ≤ n ≤ 1000
    1 ≤ m ≤ min(50, n)
Examples:
Input:
nums = [7,2,5,10,8]
m = 2
Output:
18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
*/
package com.olsh;
import java.util.Long;

class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long[][] memo = new long [m+1][nums.length+1];
        long[]sums = new long[nums.length+1];
        for (int i=0;i<nums.length;i++){
            sums[i+1]=nums[i]+sums[i];
        }
        
        for (int i=0;i<memo.length;i++){
            for (int j=0;j<memo[0].length;j++){
                memo[i][j]=Long.MAX_VALUE;
            }
        }
        memo[0][0]=0;
        
        for (int i=1;i<memo.length;i++){
            for (int j=1;j<memo[0].length;j++){
                for (int k=0;k<=j;k++){
                    memo[i][j]=Math.min(memo[i][j], Math.max(memo[i-1][k], sums[j]-sums[k]));
                }
            }
        }
        return (int)memo[m][nums.length];
    }
}
