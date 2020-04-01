/*
1287. Element Appearing More Than 25% In Sorted Array
Easy
Given an integer array sorted in non-decreasing order, there is exactly 
one integer in the array that occurs more than 25% of the time.
Return that integer.
Example 1:
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
Constraints:
    1 <= arr.length <= 10^4
    0 <= arr[i] <= 10^5
*/

package com.olsh;

class ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        for (int i=0;i<=arr.length/4*3;i++){
            if (arr[i]==arr[i+arr.length/4])return arr[i]; }
        return 0;
    }
}
