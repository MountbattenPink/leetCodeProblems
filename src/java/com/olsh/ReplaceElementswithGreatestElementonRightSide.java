package com.olsh;/*
1299. Replace Elements with Greatest Element on Right Side
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

 

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
 

Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
*/

class ReplaceElementswithGreatestElementonRightSide {
    public int[] replaceElements(int[] arr) {
      int max = arr[arr.length-1];
        int prev = arr[arr.length-1];
        for (int i=arr.length-1;i>0;i--){
            int t = arr[i-1];
            max=Math.max(prev, max);
            arr[i-1]=max;
            prev=t;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}
