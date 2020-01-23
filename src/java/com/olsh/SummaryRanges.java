/**
#228. Summary Ranges
Given a sorted integer array without duplicates, return the summary of its ranges.
Example 1:
Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

package com.olsh;

import java.util.ArrayList;
import java.util.List;

class SummaryRanges {
 public List<String> summaryRanges(int[] nums) {
  int length = 1;
  List <String> res = new ArrayList< String >();
  for (int i = 1; i <= nums.length; i++) {
   if (i == nums.length || nums[i] != nums[i - 1] + 1) {
    if (length == 1) {
     res.add(String.valueOf(nums[i - length]));
    } else {
     res.add(nums[i - length] + "->" + nums[i - 1]);
    }
    length = 1;
   } else {
    length++;
   }
  }
  return res;
 }
}
