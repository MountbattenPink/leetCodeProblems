/*
128. Longest Consecutive Sequence
Hard
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.
Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

package com.olsh;
import java.lang.Map;
import java.lang.HashMap;
import java.lang.Set;
import java.lang.Math;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
    Map<Integer,Node>nodes=new HashMap<>();
    Set<Integer>visited = new HashSet<>();
    for (int num:nums){
         if (!nodes.containsKey(num)){
            Node node = new Node(num);
            if (nodes.containsKey(num-1)){
                    nodes.get(num-1).next=node;
                    node.prev=nodes.get(num-1);
                    nodes.put(num, node);
            }
            if (nodes.containsKey(num+1)){
                    nodes.get(num+1).prev=node;
                    node.next=nodes.get(num+1);
                    nodes.put(num, node);
                }
            if (!nodes.containsKey(num-1) && !nodes.containsKey(num+1))
                nodes.put(num, node);
            }
        }
        int max = 0;
        int current = 0;
        for (Integer key: nodes.keySet()){
            if (!visited.contains(key)){
                current=1;
                Node n = nodes.get(key);
                while (n.next!=null){
                    current++;
                    visited.add(n.val);
                    n=n.next;
                }
                n = nodes.get(key);
                while (n.prev!=null){
                    current++;
                    visited.add(n.val);
                    n=n.prev;
                }
            max=Math.max(current,max);
        }}
        return max;
    }
}

class Node{
    int val;
    Node next;
    Node prev;
    public Node(int val){
        this.val=val;
    }
}
