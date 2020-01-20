/*
202. Happy Number
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer>set = new HashSet<>();
        do {
            set.add(n);
            String str = String.valueOf(n);
            n=0;
            for (char c: str.toCharArray())n+=Math.pow(c-48,2);
        }
        while (!set.contains(n) && n!=1);
            return n==1;
    }
}
