/**
#349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:
Each element in the result must be unique.
The result can be in any order.
*/

package com.olsh;

import java.util.HashSet;
import java.util.Set;

class IntersectionofTwoArrays {
     public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length)return normalizedIntersection(nums2,nums1);
        else return normalizedIntersection(nums1,nums2);
        }

    public int[] normalizedIntersection(int[] min, int[]max){
        Set<Integer> intersection = new HashSet<>();
        Set<Integer>set = new HashSet<>();
        for (int elem:min)set.add(elem);
        for (int e:max){
            if (set.contains(e)){
                intersection.add(e);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
