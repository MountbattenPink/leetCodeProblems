/*
127. Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

package com.olsh;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map.Entry;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Set<String>>adjacencyList = new HashMap<>();
        Map<String,Set<String>>points = new HashMap<>();
        wordList.add(beginWord);
        for (String word: wordList){
            adjacencyList.put(word, new HashSet<>());
            for (int i=0;i<word.length();i++){
                String option = word.substring(0,i)+"."+word.substring(i+1,word.length());
                adjacencyList.get(word).add(option);
                if (points.get(option)==null)points.put(option, new HashSet<>());
                points.get(option).add(word);
            }
        }
        Queue<Map.Entry<String,Integer>>queue = new LinkedList<>();
        Map<String,Integer>visited=new HashMap<>();
        queue.add(new AbstractMap.SimpleEntry<String, Integer>(beginWord,1));
        while (!queue.isEmpty()){
            Map.Entry<String,Integer>entry = queue.remove();
            String word = entry.getKey();
            int value = entry.getValue();
            if (visited.containsKey(word)){
                value = Math.min(visited.get(word), value);
                visited.put(word,value);
            }
            else {
                visited.put(word,value);
                Set<String> dotted = adjacencyList.get(word);
                if (dotted!=null){
                    for (String dot:dotted){
                        Set<String>children = points.get(dot);
                        if (children!=null)
                        {
                            for (String child: children)
                                if(!child.equals(word))
                                    queue.add(new AbstractMap.SimpleEntry<String, Integer>(child, value+1));
                        }
                    }
                }
            }
        }
        return visited.get(endWord)==null?0:visited.get(endWord);
    }
}
