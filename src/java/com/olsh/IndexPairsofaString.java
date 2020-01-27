/*
1065. Index Pairs of a String
Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring text[i]...text[j]
is in the list of words.

Example 1
Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
Output: [[3,7],[9,13],[10,17]]
Example 2
Input: text = "ababa", words = ["aba","ab"]
Output: [[0,1],[0,2],[2,3],[2,4]]
Explanation: 
Notice that matches can overlap, see "aba" is found in [0,2] and [2,4]
Note
All strings contains only lowercase English letters.
It's guaranteed that all strings in words are different.
1 <= text.length <= 100
1 <= words.length <= 20
1 <= words[i].length <= 50
Return the pairs [i,j] in sorted order (i.e. sort them by their first coordinate 
in case of ties sort them by their second coordinate).
*/
package com.olsh;
import java.lang.Set;
import java.lang.HashSet;
import java.lang.List;
import java.lang.ArrayList;
import java.lang.Comparator;

class IndexPairsofaString {
    Trie root;
    public int[][] indexPairs(String text, String[] words) {
        root = new Trie(' ');
        for (String word: words)insert(root, word);
        Set<List<Integer>>set = new TreeSet<>(new Comparator<List<Integer>>(){
            public int compare(List<Integer>x,List<Integer>y){
                if (x.get(0)==y.get(0))return x.get(1)-y.get(1);
                else return x.get(0)-y.get(0);
            }
        });
        for (int i=0;i<text.length();i++)
            search(root, text, i, i,set);
        int[][]result = new int[set.size()][2];
        int i=0;
        for (List<Integer>item:set){
            result[i][0]=item.get(0);
            result[i][1]=item.get(1);
            i++;
        }
        return result;
    }
    
    
    public void insert(Trie root, String word){
        Trie node = root;
        for (char c: word.toCharArray()){
            if (node.children.get(c)==null)node.children.put(c, new Trie(c));
            node = node.children.get(c);
        }
        node.finish = true;
    }

    public void search(Trie root, String text, int beginning, int end, Set<List<Integer>>set){
        if (end<text.length()){
        char c = text.charAt(end);
        if (root.children.get(c)!= null){
            root = root.children.get(c);
            if (root.finish){
                List<Integer>list = new ArrayList<>();
                list.add(beginning);
                list.add(end);
                set.add(list);
            }
            end++;
           
            search(root, text,beginning,end,set);
        }
        }
        }
}

class Trie{
    char c;
    Map<Character, Trie>children;
    boolean finish;
    public Trie(char c){
        this.c=c;
        this.children = new HashMap<>();
        this.finish=false;
    }
}
