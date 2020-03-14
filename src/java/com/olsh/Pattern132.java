/*
456. 132 Pattern
Medium
Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, 
ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers 
as input and checks whether there is a 132 pattern in the list.
Note: n will be less than 15,000.
Example 1:
Input: [1, 2, 3, 4]
Output: False
Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]
Output: True
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]
Output: True
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
*/

package com.olsh;
import java.lang.Integer;
jmport java.lang.Math;
class Pattern132 {
    public boolean find132pattern(int[] nums) {
        if (nums.length<3) return false;
        int min = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int i=1;i<nums.length-1;i++){
            min = Math.min(min, nums[i-1]);
            if (min<nums[i]){
                if (middle>nums[i]){
                for (int j=i+1;j<nums.length;j++){
                    if (nums[j]>min && nums[j]<nums[i]) return true;
                }
            }
                else if (middle>min && middle<nums[i])return true;
            }
        }
        return false;
    }
}
