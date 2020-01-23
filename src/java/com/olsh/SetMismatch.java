package com.olsh;/*
645. Set Mismatch
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
*/

class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        long n = nums.length;
        long sumCorrect = n*(1+n)/2;
        long actualSum = 0;
        for (int num: nums)actualSum+=num;
        long c = actualSum-sumCorrect;
        //y=x+c
        //y - duplicate
        //x - lack
        long sumSquaresCorrect = n*(n+1)*(2*n+1)/6;
        long actualSquaresSum = 0;
        for (int num:nums)actualSquaresSum+=(long)(Math.pow(num, 2));
        //y^2 = x^2+2cx+c^2
        //x^2=x^2
        //actualSquaresSum-sumSquaresCorrect=2cx+c^2
        int res[]=new int[2];
        res[1] = (int)((actualSquaresSum-sumSquaresCorrect - (long)(Math.pow(c,2)))/(2*c));
        res[0] = (int)(res[1]+c);
        return res;
    }
}
