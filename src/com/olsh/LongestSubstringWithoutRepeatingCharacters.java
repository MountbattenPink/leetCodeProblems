/**
#3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

package com.olsh;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        Set<Character>uniqueSet=new HashSet<>();
        Deque<Character> unique= new LinkedList<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
                if (uniqueSet.contains(c)){
                    res=Math.max(res, unique.size());
                while (uniqueSet.contains(c)){
                        uniqueSet.remove(unique.getFirst());
                        unique.removeFirst();
                    }
                    uniqueSet.add(c);
                    unique.addLast(c);
                }
            else {
                    uniqueSet.add(c);
                    unique.addLast(c);
                System.out.println(unique);
            }
            if (i==s.length()-1)  res=Math.max(res, unique.size());
        }
        return res;
    }
}
