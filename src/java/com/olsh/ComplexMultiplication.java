package com.olsh;

/**
 * Given two strings representing two complex numbers.
 * <p>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p>
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * <p>
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */

public class ComplexMultiplication {
    public static String complexNumberMultiply(String a, String b) {
        String[] arr1 = a.substring(0, a.length() - 1).split("\\+");
        String[] arr2 = b.substring(0, b.length() - 1).split("\\+");
        int real = Integer.valueOf(arr1[0]) * Integer.valueOf(arr2[0]) - Integer.valueOf(arr1[1]) * Integer.valueOf(arr2[1]);
        int imaginary = Integer.valueOf(arr1[0]) * Integer.valueOf(arr2[1]) + Integer.valueOf(arr1[1]) * Integer.valueOf(arr2[0]);
        String sign = "";
        return real + "+" + sign + imaginary + "i";
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }

}
