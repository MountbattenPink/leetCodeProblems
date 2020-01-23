/**
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
Example 1:
Input: "Hello"
Output: "hello"
Example 2:
Input: "here"
Output: "here"
Example 3:
Input: "LOVELY"
Output: "lovely"
*/
package com.olsh;
class ToLowerCase {
    public String toLowerCase(String str) {
     StringBuilder builder = new StringBuilder();
     for (Character c: str.toCharArray()){
         if (c>=65 && c<=90){
             builder.append((char)(c+32));
         }
         else builder.append(c);
     }
        return builder.toString();
    }
}
