/**
#67. Add Binary
Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
*/

package com.olsh;
class AddBinary1{
    public String addBinary(String a, String b) {
        if (a.length()>b.length()){
            StringBuilder builder = new StringBuilder();
            while (builder.length()<a.length()-b.length())builder.append('0');
            builder.append(b);
            b=builder.toString();
        }
        else if (a.length()<b.length()){
            StringBuilder builder = new StringBuilder();
            while (builder.length()<b.length()-a.length())builder.append('0');
            builder.append(a);
            a=builder.toString();
        }
        StringBuilder builder = new StringBuilder();
        char additionalbit = '0';
        for (int i=a.length()-1;i>=0;i--){
            if (a.charAt(i)=='0' && b.charAt(i)=='0') {
                builder.insert(0, additionalbit);
                additionalbit='0';
                                                      }
            else if (a.charAt(i)=='1' && b.charAt(i)=='1'){
                builder.insert(0, additionalbit);
                additionalbit='1';
            }
            else if ((a.charAt(i)=='1' && b.charAt(i)=='0') || (a.charAt(i)=='0' && b.charAt(i)=='1')){
             
                if (additionalbit=='1')builder.insert(0, '0');                
                else builder.insert(0, '1');
            }
        }
        if (additionalbit!='0')builder.insert(0, additionalbit);
        return builder.toString();
    }
}
