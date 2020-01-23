package com.olsh;/*
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if ((nums[i]==target/2)&&(indices.containsKey(nums[i]))) return new int[]{indices.get(nums[i]),i};
            else if (indices.containsKey(target - nums[i])) return new int[]{indices.get(target - nums[i]),i};
            else {
                indices.put(nums[i], i);
            }
            }
            throw new RuntimeException();
        }

}
