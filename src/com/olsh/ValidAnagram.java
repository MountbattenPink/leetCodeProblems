package com.olsh;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        for (Character c : s.toCharArray()) {
            res1 += c;
        }
        for (Character c1 : t.toCharArray()) {
            res1 -= c1;
        }
        for (Character c : s.toCharArray()) {
            res3 += c * c;
        }
        for (Character c1 : t.toCharArray()) {
            res3 -= c1 * c1;
        }
        for (Character c3 : (s + t).toCharArray()) {
            res2 ^= c3;
        }

        return res1 == 0 && res3 == 0 && res2 == 0;
    }
}
