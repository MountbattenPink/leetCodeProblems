/**
#461. Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
*/

package com.olsh;

class HammingDistance {
    public int hammingDistance(int x, int y) {
	    int res = 0;
        StringBuilder stringX = new StringBuilder(Integer.toBinaryString(x));
        StringBuilder stringY = new StringBuilder(Integer.toBinaryString(y));
        while (stringX.length()<stringY.length()){
	        stringX.insert(0,'0');
        }
	    while (stringY.length()<stringX.length()){
	        stringY.insert(0,'0');
        }
        for (int i=0;i<stringX.length();i++){
	        if (stringX.charAt(i)!=stringY.charAt(i)) res++;
        }
        return res;
    }
}
