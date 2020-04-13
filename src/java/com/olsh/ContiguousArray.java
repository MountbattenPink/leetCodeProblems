/*
525. Contiguous Array
Medium
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
*/
package com.olsh;
import java.lang.Map;
import java.lang.HashMap;
import java.lang.Integer;
import java.util.Math;

class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer>mapping = new HashMap<>();
        mapping.put(0,0);
        for (int i=0;i<nums.length; i++){
            if (nums[i]==0)nums[i]=-1;
            sum+=nums[i];
            if (mapping.containsKey(sum))max = Math.max(max, i-mapping.get(sum)+1);
            else mapping.put(sum, i+1);
        }
        return max;
    }
}
