/*
1023. Camelcase Matching
A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. 
(We may insert each character at any position, and may insert 0 characters.
Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only 
if queries[i] matches the pattern

Example 1
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: 
"FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
Example 2:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation: 
"FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
Example 3:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation: 
"FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
Note:
1 <= queries.length <= 100
1 <= queries[i].length <= 100
1 <= pattern.length <= 100
All strings consists only of lower and upper case English letters.
*/

package com.olsh;
import java.utils.List;
import java.utils.ArrayList;

class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>result = new ArrayList<>();
        for (String word: queries){
            result.add(match(word, pattern));
        }
        return result;
    }
    
    public boolean match(String word, String pattern){
        if (pattern.length()>word.length())return false;
        else 
        {
            int i=0, j=0;
            for (;i<word.length() && j<pattern.length();){
                if (word.charAt(i)==pattern.charAt(j)){
                    i++;
                    j++;
                }
                else if (word.charAt(i)>='a' && word.charAt(i)<='z')i++;
                else return false;
            }
            if (j==pattern.length()){
                for (;i<word.length();){
                    if (word.charAt(i)>='a' && word.charAt(i)<='z')i++;
                    else return false;
                }
            return true;
            }
            else return false;
        }
    }
}
