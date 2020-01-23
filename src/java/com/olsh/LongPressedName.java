/**
#925. Long Pressed Name
Your friend is typing his name into a keyboard.  
Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
You examine the typed characters of the keyboard.  
Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:
Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:
Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
Note:
name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.

*/
package com.olsh;
class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
	int difference = 0;
        for(int i=0;i<typed.length();){
            if (difference<=i && i-difference<name.length() && typed.charAt(i)==name.charAt(i-difference)){
                i++;
            }else if (difference<i && i-difference-1<name.length() && typed.charAt(i)==name.charAt(i-difference-1)){
                difference++;
            } else return false;
        }
        if (typed.length()-difference==name.length()) return true;
        else return false;
    }
}
