package com.olsh;

import java.util.HashMap;
import java.util.Map;

/**
#205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while 
preserving the order of characters. No two characters may map to the same character but a character may map to itself.
Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.

*/

class IsomorphicStrings {
 public boolean isIsomorphic(String s, String t) {
  if (s.length() != t.length()) return false;
  Map<Character, Character> mapping = new HashMap<>();
  Map <Character, Character> reverseMapping = new HashMap <> ();
  for (int i = 0; i < s.length(); i++) {
   char schar = s.charAt(i);
   char tchar = t.charAt(i);
   if (!mapping.containsKey(schar) && !reverseMapping.containsKey(tchar)) {
    mapping.put(schar, tchar);
    reverseMapping.put(tchar, schar);
   } else {
    if (mapping.get(schar) == null || reverseMapping.get(tchar) == null 
    || mapping.get(schar) != tchar || reverseMapping.get(tchar) != schar) return false;
   }
  }
  return true;
 }

}
