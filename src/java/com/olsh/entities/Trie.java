package com.olsh.entities;

import java.util.HashMap;
import java.util.Map;

class Trie {
    char c;
    Map<Character, com.olsh.entities.Trie> children;
    boolean finish;

    public Trie(char c) {
        this.c = c;
        this.children = new HashMap<>();
        this.finish = false;
    }
}