/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

*/
package com.olsh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class LetterCombinationsofaPhoneNumber {
     public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0)return new ArrayList<>();
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(2, "abc");
        numbers.put(3, "def");
        numbers.put(4, "ghi");
        numbers.put(5, "jkl");
        numbers.put(6, "mno");
        numbers.put(7, "pqrs");
        numbers.put(8, "tuv");
        numbers.put(9, "wxyz");
        List<StringBuilder> builders = new ArrayList<>();
        builders.add(new StringBuilder());
        for (int k=0;k<digits.length();k++){
            char c=digits.toCharArray()[k];
            int digit = c - 48;
            int length = numbers.get(digit).length();
            int currentSize = builders.size();
            String letters = numbers.get(digit);
            List<StringBuilder> copy = new ArrayList<>(builders);
                for (int i=1;i<length;i++) {
                    for (StringBuilder builder:copy){
                        builders.add(new StringBuilder(builder));
                    }
                }
                for (int i=0;i<builders.size();i++) {
                    builders.get(i).append(letters.charAt(i/(builders.size()/letters.length())));
                }
           }
        return builders.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }
}
