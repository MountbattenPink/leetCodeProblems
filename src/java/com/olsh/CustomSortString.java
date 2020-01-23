package com.olsh;

import java.util.LinkedHashMap;
import java.util.Map;

class CustomSortString {
     public String customSortString(String S, String T) {
        Map<Character, StringBuilder> dictionaryOrder = new LinkedHashMap<>();
        for (Character c: S.toCharArray()){
            dictionaryOrder.put(c, new StringBuilder());
        }
        for (Character t: T.toCharArray()){
            if (dictionaryOrder.containsKey(t)){
                dictionaryOrder.get(t).append(t);
            }
            else
                {
                dictionaryOrder.put(t,new StringBuilder());
                dictionaryOrder.get(t).append(t);
            }
        }
        System.out.println(dictionaryOrder);
        StringBuilder str = new StringBuilder();
        for (Character key: dictionaryOrder.keySet()){
            str.append(dictionaryOrder.get(key));
        }
        return str.toString();
    }
}
