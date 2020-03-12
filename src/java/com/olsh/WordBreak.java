/*
139. Word Break
Medium
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
Note:
    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/
package com.olsh;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Character;
import java.util.Map;
import java.util.HashMap;
import com.olsh.entities;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Character>set = new HashSet<>();
        Trie root = new Trie(' ');
        for (String word:wordDict){
            insertWord(word,0,root,root,set);
        }
        for (char c:s.toCharArray())
            {
            if (!set.contains(c)) return false;
        }
        return searchWord(s, 0, root, root);
    }
    
    public void insertWord(String word, int index, Trie currentRoot, Trie root, Set<Character>set){
        set.add(word.charAt(index));
        Trie trie;
        if (currentRoot.children.get(word.charAt(index))==null){
            trie = new Trie(word.charAt(index));
            currentRoot.children.put(word.charAt(index),trie);
        }
        else trie = currentRoot.children.get(word.charAt(index));
        trie.finish = trie.finish || (index==word.length()-1);
        if (index<word.length()-1) insertWord(word,index+1,trie,root,set);
    }
    
    public boolean searchWord(String word, int index, Trie currentRoot, Trie root){
        if (currentRoot==null)return false;
        if (index==word.length()){
            return currentRoot.finish;
        } else {
            char c = word.charAt(index);
            if (currentRoot.finish){
            return searchWord(word,index+1,currentRoot.children.get(c),root) || searchWord(word,index, root,root);
            }
            else
            return searchWord(word,index+1,currentRoot.children.get(c),root);
        }
     }
}
