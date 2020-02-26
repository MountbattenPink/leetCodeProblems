/*
451. Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.
Example 1:
Input:
"tree"
Output:
"eert
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:
Input:
"cccaaa"
Output:
"cccaaa"
Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:
Input:
"Aabb"
Output:
"bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

package com.olsh;

import java.util.TreeMap;
import java.util.AbstractMap;
import java.util.Character;
import java.util.Integer;
import java.util.List;
import java.util.String;
import java.util.StringBuilder;
import java.util.Map;

class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] letters = new int[128];
        for (char c: s.toCharArray()){
            letters[c]=letters[c]+1;
        }
        TreeMap<Integer,List<Character>>mapping = new TreeMap<>();
        for (int i=0;i<letters.length;i++){
            if (letters[i]!=0){
            if (mapping.get(letters[i])==null)mapping.put(letters[i], new ArrayList());
            mapping.get(letters[i]).add((char)(i));
            }
        }
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Integer, List<Character>>entry: mapping.entrySet())
            for (char c:entry.getValue())
                for (int i=1;i<=entry.getKey();i++)
                    str.insert(0,c);
        
        return str.toString();
    }
}
