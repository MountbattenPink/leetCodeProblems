/*
211. Add and Search Word - Data structure design
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

package com.olsh;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWordDataStructureDesign {
    Trie root;
    /** Initialize your data structure here. */
    public AddAndSearchWordDataStructureDesign() {
        root = new Trie(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie currentRoot = root;
        for (char c: word.toCharArray()){
            if (currentRoot.children.get(c)==null){
                currentRoot.children.put(c, new Trie(c));
            }
            currentRoot = currentRoot.children.get(c);
        }
        currentRoot.finish=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    public boolean search(char[] array, int index, Trie root){
        if (index==array.length)return root.finish;
        else if (array[index]=='.'){
            boolean disjunction = false;
            for (char key: root.children.keySet()){
                disjunction |= search(array, index+1, root.children.get(key));
            }
            return disjunction;
        }
        else if (root.children.get(array[index])!=null)return search(array, index+1, root.children.get(array[index]));
        return false;
    }
}

class Trie{
    Map<Character, Trie> children;
    boolean finish;
    char val;
    public Trie(char c){
        this.val=c;
        children = new HashMap<>();
        finish = false;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * AddAndSearchWordDataStructureDesign obj = new AddAndSearchWordDataStructureDesign();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */