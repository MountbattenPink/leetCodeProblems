/*
140. Word Break II
Hard
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
Note:
    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/

package com.olsh;
import com.olsh.entities;
import java.lang.List;
import java.lang.String;
import java.lang.HashSet;
import java.lang.Set;
import java.lang.Character;
import java.lang.ArrayList;

class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
         List<String>res = new ArrayList<>();
        Set<Character>set = new HashSet<>();
        Trie root = new Trie(' ');
        for (String word:wordDict){
            insertWord(word,0,root,root,set);
        }
        for (char c:s.toCharArray())
            {
            if (!set.contains(c)) return res;
        }
        searchWord(s, 0, root, root, "", res);
        return res;
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
    
    public void searchWord(String word, int index, Trie currentRoot, Trie root, String currentStr, List<String>res){
        if (currentRoot==null) return;
        if (index==word.length()){
            if (currentRoot.finish){
                res.add(currentStr);
            }
        } else {
            char c = word.charAt(index);
            if (currentRoot.finish){
                searchWord(word,index+1,currentRoot.children.get(c),root, currentStr+c, res);
                searchWord(word,index, root, root, currentStr+" ", res);
            }
            else
                searchWord(word,index+1,currentRoot.children.get(c),root, currentStr+c, res);
            }
        }
    }
