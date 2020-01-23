package com.olsh; /**
#906. Super Palindromes
Let's say a positive integer is a superpalindrome if it is a palindrome, and it is also the square of a palindrome.

Now, given two positive integers L and R (represented as strings), return the number of superpalindromes in the inclusive range [L, R].

Example 1:

Input: L = "4", R = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 

Note:

1 <= len(L) <= 18
1 <= len(R) <= 18
L and R are strings representing integers in the range [1, 10^18).
int(L) <= int(R)
*/

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

class SuperPalindromes {
      public int superpalindromesInRange(String L, String R) {
        Set<BigInteger> superPalindromes = new HashSet<>();
        long left = Long.valueOf(L);
        long right = Long.valueOf(R);
        StringBuilder min = new StringBuilder();
        min.append(1);
        int minLength = String.valueOf((long)Math.sqrt(left)).length();
        for (int k=1;k < minLength/2;k++){
            min.append("0");
        }
        BigInteger palindrome1=BigInteger.ZERO;
        BigInteger palindrome2=BigInteger.ZERO;
        BigInteger bigLeft = new BigInteger(String.valueOf(left));
        BigInteger bigRight = new BigInteger(String.valueOf(right));
        for (long i=Long.valueOf(min.toString()); bigRight.compareTo(palindrome1)>=0 || bigRight.compareTo(palindrome2)>=0 ;i++){
            palindrome1 = makePalindrome(i, true);
            palindrome1=palindrome1.pow(2);
            palindrome2 = makePalindrome(i, false);
            palindrome2=palindrome2.pow(2);
            if (isPalindrome(palindrome1) && bigRight.compareTo(palindrome1)>=0 && palindrome1.compareTo(bigLeft)>=0){

                superPalindromes.add(palindrome1);
            }
            if (isPalindrome(palindrome2) && bigRight.compareTo(palindrome2)>=0 && palindrome2.compareTo(bigLeft)>=0){

                superPalindromes.add(palindrome2);
            }
        }
        return superPalindromes.size();
    }


    public BigInteger makePalindrome(long number, boolean evenDigits){
        String str = String.valueOf(number);
        if (evenDigits){

            return new BigInteger(str + new StringBuilder(str.substring(0,str.length())).reverse().toString());
        }
        else {
            return new BigInteger(str + new StringBuilder(str.substring(0,str.length()-1)).reverse().toString());

        }
    }

    public boolean isPalindrome(BigInteger n) {
        String s=String.valueOf(n);
        for (int i=0;i<=s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i))return false;
        }
        return true;
    }

}
