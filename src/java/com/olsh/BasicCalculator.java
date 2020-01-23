package com.olsh;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * № 224 Basic Calculator
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculator {

    public int calculate(String s) {
        int globalSumm = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder numberBuilder = new StringBuilder();
        for (Character c: s.toCharArray()){
            if (c == ' ') {
                continue;
            }
            else if (c>=48 && c<=57){
                numberBuilder.append(c);
            }
            else {
                if (!numberBuilder.toString().equals("")){
                    if (stack.size()!=0){
                        int k=1;
                        for (Integer i: stack){
                            k*=i;
                        }
                        globalSumm += k * sign * Integer.valueOf(numberBuilder.toString());
                        numberBuilder.setLength(0);
                    }
                    else {
                        globalSumm += sign * Integer.valueOf(numberBuilder.toString());
                        numberBuilder.setLength(0);
                    }
                }
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                } else if (c == '(') {
                    stack.push(sign);
                    sign = 1;
                } else if (c == ')') {
                    stack.removeFirst();
                    sign = 1;
                }
            }
        }
        if (!numberBuilder.toString().equals("")){
            globalSumm += sign * Integer.valueOf(numberBuilder.toString());}
        return globalSumm;
   }
}
