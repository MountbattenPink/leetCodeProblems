/*
239. Sliding Window Maximum
Hard

Given an array nums, there is a sliding window of size k which is moving
from the very left of the array to the very right. You can only see the k 
numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
Follow up:
Could you solve it in linear time?
*/
package com.olsh;
class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0)return new int[0];
        int [] res = new int[nums.length-k+1];
        int maxInd = 0;
        for(int i=0;i<k;i++)if (nums[i]>nums[maxInd])maxInd=i;
        res[0]=nums[maxInd];
        for (int i=k-1;i<nums.length;i++){
            if (maxInd>i-k+1){
                if (nums[maxInd]<nums[i])maxInd=i;
            }
            else {
                maxInd=i;
                for(int j=i-k+1;j<=i;j++)if (nums[j]>nums[maxInd])maxInd=j;
            }
            res[i-k+1]=nums[maxInd];
        }
        return res;
    }
}
