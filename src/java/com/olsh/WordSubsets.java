package com.olsh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
#916. Word Subsets

We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 

Return a list of all universal words in A.  You can return the words in any order.

Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
 

Note:

1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].
*/

class WordSubsets {
 public List< String > wordSubsets(String[] A, String[] B) {
  Map< String, Integer > bMap = mergeB(B);
  int Alength = A.length;
  List < String > res = new ArrayList< String >();
  for (int i = 0; i < Alength; i++) {
   String word = A[i];
   boolean wordSuits = true;
   for (String letter: bMap.keySet()) {
    for (int j = 1; j <= bMap.get(letter) && wordSuits; j++) {
     if (word.indexOf(letter) == -1) wordSuits = false;
     word = word.replaceFirst(letter, "");
    }
   }
   if (wordSuits) res.add(A[i]);
  }
  return res;
 }

 public Map < String, Integer > mergeB(String[] B) {
  Map < String, Integer > res = new HashMap< >();
  for (String bStr: B) {
   for (Character c: bStr.toCharArray()) {
    String cStr = String.valueOf(c);
    if (res.get(cStr) == null) res.put(cStr, 1);
    res.put(cStr, Math.max(res.get(cStr), bStr.length() - bStr.replaceAll(cStr, "").length()));
   }
  }
  return res;
 }
}
