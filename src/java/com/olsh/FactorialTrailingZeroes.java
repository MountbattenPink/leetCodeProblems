package com.olsh;

/**
#172. Factorial Trailing Zeroes
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.
*/

class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
	int res = 0;
	res = trailingZeroesRec(n, res);
    return res;
    }

    public int trailingZeroesRec(int n, int res){
	    if (n<5) return 0;
	    else {
            res+=n/5 + trailingZeroesRec(n/5,res);
            }
        return res;
    }

}
