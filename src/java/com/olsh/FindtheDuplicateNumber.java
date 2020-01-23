package com.olsh;

/**
#287. Find the Duplicate Number
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums==null || nums.length<2) return -1;
        int n = nums.length-1;
        return find(1, n, nums);
        }
    
    public int find(int leftBorder, int rightBorder, int[]nums){
        int leftcount=0;
        int rightcount=0;
        if (leftBorder==rightBorder) return leftBorder;
        if (rightBorder == leftBorder+1) {
            for (int i=0;i<nums.length;i++){
                if (nums[i]==leftBorder)leftcount++;
                if (nums[i]==rightBorder)rightcount++;
            }
            return leftcount>rightcount ? leftBorder: rightBorder;
        }
       
        int middle = leftBorder + (rightBorder-leftBorder)/2;
        for (int i=0;i<nums.length;i++){
            if (leftBorder<=nums[i] && nums[i]<=middle){
                leftcount++;
            }
            else if (middle<nums[i] && nums[i]<=rightBorder){
                rightcount++;
            }
        }
        
        if (leftcount > middle-leftBorder+1){
            return find(leftBorder, middle, nums);
        }
        else if (rightcount > rightBorder-middle){
            return find(middle, rightBorder, nums);
        }
        else return -1;
    }
}
