/**
#32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/

package com.olsh;

import java.util.LinkedList;

class LongestValidParentheses {
 public int longestValidParentheses(String s) {
  int max = 0;
  LinkedList< Integer > parentheses = new LinkedList < > ();
  for (int i = 0; i < s.length(); i++) {
   int c = s.charAt(i) == '(' ? -1 : 0; //( means -1;
   //) means 0
   if (parentheses.isEmpty()) {
    parentheses.add(c);
   } else if (parentheses.getLast() > 0 && c == 0) {
    int t = parentheses.getLast();
    parentheses.removeLast();
    if (!parentheses.isEmpty() && parentheses.getLast() == -1) {
     parentheses.removeLast();
     t += 2;
     parentheses.add(t);
    } else {
     parentheses.add(t);
     parentheses.add(c);
    }

   } else if (parentheses.getLast() == -1 && c == 0) {
    parentheses.removeLast();
    if (parentheses.isEmpty() || parentheses.getLast() <= 0) {
     parentheses.add(2);
    } else if (parentheses.getLast() > 0) {
     int t = parentheses.getLast();
     parentheses.removeLast();
     parentheses.add(t + 2);
    }
   } else {
    parentheses.add(c);
   }
   while (!parentheses.isEmpty() && parentheses.getLast() > 0) {
    int t = parentheses.getLast();
    parentheses.removeLast();
    if (!parentheses.isEmpty() && parentheses.getLast() > 0) {
     t += parentheses.getLast();
     parentheses.removeLast();
     parentheses.add(t);
    } else {
     parentheses.add(t);
     break;
    }

   }
  }
  for (Integer item: parentheses) {
   max = Math.max(max, item);
  }
  return max;
 }
}
