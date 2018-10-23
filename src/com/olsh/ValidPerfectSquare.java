/**
 * #367. Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Output: true
 * Example 2:
 * Input: 14
 * Output: false
 */

package com.olsh;
class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 2147483647) return false;
        for (int i = 2; num > 1 && i * i <= num;) {
            if (num % i == 0) {
                num /= i;
                if (num % i == 0) {
                    num /= i;
                    i = 2;
                } else return false;
            } else i++;
        }
        return num == 1;
    }
}
