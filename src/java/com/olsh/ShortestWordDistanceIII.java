package com.olsh;

import java.util.HashSet;
import java.util.Set;

//245. Shortest Word Distance III
class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Set<Integer> word1Indices = new HashSet<>();
        Set<Integer>word2Indices = new HashSet<>();
        for (int i=0;i<words.length;i++){
            if (words[i].equals(word1))word1Indices.add(i);
            if (words[i].equals(word2))word2Indices.add(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i:word1Indices){
            for (int j:word2Indices){
                if (i!=j) min = Math.min(min, Math.abs(i-j));
            }
        }
        return min;
    }
}
