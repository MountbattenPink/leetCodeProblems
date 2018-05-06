package com.olsh;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        String res = "";
        boolean needAdd = false;
        if (a.length() > b.length()) {
            while (a.length() > b.length()) {
                b = "0" + b;
            }
        } else if (a.length() < b.length()) {
            {
                while (a.length() < b.length())
                    a = "0" + a;
            }
        }
        for (int i = a.length() - 1; i >= 0; i--) {


            if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                if (needAdd) {
                    needAdd = false;
                    res = '1' + res;
                } else res = '0' + res;
                ;
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (needAdd) {
                    res = '1' + res;
                } else {
                    needAdd = true;
                    res = '0' + res;
                }
            } else if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                if (needAdd) {
                    res = '0' + res;
                } else {
                    res = '1' + res;
                }
            } else throw new RuntimeException();
        }
        if (needAdd) {
            res = '1' + res;
        }
        return res;
    }
}
