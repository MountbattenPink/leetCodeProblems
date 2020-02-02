/*
720. Longest Word in Dictionary
Given a list of strings words representing an English Dictionary,
find the longest word in words that can be built one character at a time by other words in words.
If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary.
However, "apple" is lexicographically smaller than "apply".
Note:
All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
 */

package com.olsh;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LongestWordInDictionary {
    TrieLongestWord root = new TrieLongestWord(' ');

    public String longestWord(String[] words) {
        for (String word: words)root.addWord(word);
        Set<String>answers = new TreeSet<>();
        longestWord(answers,  root);
        String longest = "";
        for (String word: answers){
            if (word.length()>longest.length())longest = word;
        }
        return longest;
    }

    public void longestWord(Set<String> answers, TrieLongestWord root) {
        for (char c: root.children.keySet())
            if (root.children.get(c).finish){
                answers.add(root.children.get(c).wordFinished);
                longestWord(answers, root.children.get(c));}
    }}



class TrieLongestWord{
    Map<Character, TrieLongestWord> children;
    boolean finish;
    char val;
    String wordFinished;

    public TrieLongestWord(char c){
        this.val=c;
        children = new HashMap<>();
        finish = false;
        wordFinished=null;
    }

    public void addWord(String word) {
        TrieLongestWord currentRoot = this;
        for (char c: word.toCharArray()){
            if (currentRoot.children.get(c)==null){
                currentRoot.children.put(c, new TrieLongestWord(c));
            }
            currentRoot = currentRoot.children.get(c);
        }
        currentRoot.finish=true;
        currentRoot.wordFinished=word;
    }
}
