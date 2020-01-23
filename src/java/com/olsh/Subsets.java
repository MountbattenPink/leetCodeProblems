/*
#78. Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/
package com.olsh;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>>res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int i:nums){
                List<List<Integer>> newList = new ArrayList<>();
                for (List<Integer>l : res){
                    List<Integer> list = new ArrayList<>();
                    for (Integer number:l){
                        list.add(new Integer(number));
                    }
                    newList.add(list);
                }
                for (List<Integer> l : newList){
                    l.add(i);
                }
                res.addAll(newList);
            }
            return res;
        }
}
