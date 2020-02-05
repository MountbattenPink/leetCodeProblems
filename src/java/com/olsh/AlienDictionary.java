/*
269. Alien Dictionary

There is a new alien language which uses the latin alphabet. 
However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
*/

package com.olsh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjacencyList = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w2 = words[i];
            for (int j = 0; j < w2.length(); j++)
                if (adjacencyList.get(w2.charAt(j)) == null)
                    adjacencyList.put(w2.charAt(j), new HashSet<>());
            if (i > 0) {
                String w1 = words[i - 1];
                for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adjacencyList.get(c1).add(c2);
                        break;
                    }
                }
            }
        }
        StringBuilder stack = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        boolean hasCycles = false;
        for (char c : adjacencyList.keySet()) {
            hasCycles |= topologicalSort(adjacencyList, stack, visited, c, "");
            if (hasCycles) return "";
        }
        return stack.reverse().toString();
    }

    public boolean topologicalSort(Map<Character, Set<Character>> adjacencyList, StringBuilder stack, Set<Character> visited, char c, String currentStack) {
        if (currentStack.indexOf(c) >= 0) return true;

        boolean cyclesDetected = false;
        if (!visited.contains(c)) {
            visited.add(c);
            if (adjacencyList.get(c) != null) {
                for (char child : adjacencyList.get(c)) {
                    cyclesDetected |= topologicalSort(adjacencyList, stack, visited, child, currentStack + c);
                    if (cyclesDetected) return true;
                }
                stack.append(c);
            }
        }
        return cyclesDetected;
    }
}
