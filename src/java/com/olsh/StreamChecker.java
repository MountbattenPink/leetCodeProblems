/*
1032. Stream of Characters
Hard
Implement the StreamChecker class as follows:
    StreamChecker(words): Constructor, init the data structure with the given words.
    query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.

Example:
StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist

Note:
    1 <= words.length <= 2000
    1 <= words[i].length <= 2000
    Words will only consist of lowercase English letters.
    Queries will only consist of lowercase English letters.
    The number of queries is at most 40000.
*/

package com.olsh;
import com.olsh.entities.Trie;
import java.lang.String;

class StreamChecker {
    
    Trie root = new Trie(' ', false);    
    StringBuilder str = new StringBuilder();
    
    public StreamChecker(String[] words) {
        for (String word: words){
            insert(root, word, word.length()-1);
        }
    }
    
    public boolean query(char letter) {
        str.append(letter);
        String s = str.toString();
        return search(root, s, s.length()-1);
    }
    
    
    public void insert(Trie currentRoot, String word, int index){
        if (index>=0 && !currentRoot.finish){
            char c = word.charAt(index);
            Trie trie = currentRoot.mapping.get(c);
            if (trie==null)currentRoot.mapping.put(c, new Trie(c, index==0));
            else currentRoot.mapping.get(c).finish = trie.finish || (index==0);
            insert(currentRoot.mapping.get(c), word, index-1);
        }
    }
    
    public boolean search(Trie currentRoot, String word, int index){
        if (currentRoot==null)return false;
        if (index<0)return currentRoot.finish;
        else {
            if (currentRoot.finish)return true;
            else return search(currentRoot.mapping.get(word.charAt(index)), word, index-1);
        }
    }
}
