/**
#921. Minimum Add to Make Parentheses Valid
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses
( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

Example 1:
Input: "())"
Output: 1
Example 2:
Input: "((("
Output: 3
Example 3:
Input: "()"
Output: 0
Example 4:
Input: "()))(("
Output: 4
*/

package com.olsh;

import java.util.Deque;
import java.util.LinkedList;

class MinimumAddToMakeParenthesesValid {
 public int minAddToMakeValid(String S) {
  Deque<Character> stack = new LinkedList<>();
  for (Character c: S.toCharArray()) {
   if (stack.isEmpty() || c.equals(stack.getLast()) || stack.getLast().equals(')')) {
    stack.add(c);
   } else {
    stack.removeLast();
   }
  }
  return stack.size();
 }
}
