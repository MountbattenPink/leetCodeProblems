/*
76. Minimum Window Substring
Hard

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

*/
package com.olsh;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s==null || t==null || t.isEmpty() ||s.isEmpty() || s.length() < t.length()) return "";
        int globalI=-1;
        int globalJ=-1;
        int globalMin = Integer.MAX_VALUE;
        Map<Character, Integer>lack = new HashMap<>();
        Map<Character, Integer>redundant = new HashMap<>();
        Set<Character>set = new HashSet<>();
        for (char c: t.toCharArray()){
            set.add(c);
            lack.merge(c, 1, (o,n)-> o+n);
        }
        
        for (int i=0, j=0;i<s.length() && j<=s.length();){
            while (!lack.isEmpty() && j<s.length()){
                char toAdd = s.charAt(j);
                if (set.contains(toAdd)){
                if (lack.containsKey(toAdd)){
                    if (lack.get(toAdd)==1) lack.remove(toAdd);
                    else lack.put(toAdd, lack.get(toAdd)-1);
                } else {
                    redundant.merge(toAdd, 1, (o,n)->o+n);
                    }
                }
                j++;
            }
            if (lack.isEmpty() && j-i<globalMin){
                globalI = i;
                globalJ = j;
                globalMin = j-i;
            }
            do {
                char toRemove = s.charAt(i);
                
                if (set.contains(toRemove)){
        
                if (redundant.containsKey(toRemove)){
                    if (redundant.get(toRemove)==1) redundant.remove(toRemove);
                    else redundant.put(toRemove, redundant.get(toRemove)-1);
                } else {
                    lack.merge(toRemove, 1, (o,n)->o+n);
                }}
                i++;
                if (lack.isEmpty() && j-i<globalMin){
                globalI = i;
                globalJ = j;
                globalMin = j-i;
            }
            } while ((i<s.length()) && (!set.contains(s.charAt(i)) || (i<j && j==s.length())));
        }
        
        return globalI==-1 || globalJ ==-1? "" : s.substring(globalI,globalJ);
    }
}
