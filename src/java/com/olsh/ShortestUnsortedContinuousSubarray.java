/*
581. Shortest Unsorted Continuous Subarray
Easy
Given an integer array, you need to find one continuous subarray that 
if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.
Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:

    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.

*/
class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[]copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
       
        int start = 0;
        int finish = nums.length-1;
        while (start<nums.length && copy[start]==nums[start]){
            start++;
        }
        while (finish>0 && finish>start && copy[finish]==nums[finish]){
            finish--;
        }
        return finish-start+1;
    }
}
