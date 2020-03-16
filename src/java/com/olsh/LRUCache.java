package com.olsh;/*
146. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 / capacity / );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/
package com.olsh;
import java.lang.Integer;
import java.lang.Map;
import java.lang.HashMap;

class LRUCache {
    Map<Integer, Node>map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))return -1;
        else {
            pushUp(key);
            return map.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)){
            if (map.size()==capacity){
                Node n = tail.prev;
                map.remove(n.key);
                tail.prev = n.prev;
                tail.prev.next = tail;
            }
            Node n = new Node(key, value);
            map.put(key, n);
            n.next = head.next;
            n.prev = head;
            head.next = n;
            n.next.prev = n;
        }
        else {
            map.get(key).val = value;
            pushUp(key);
        }
    }
    
    public void pushUp(int key){
         Node n = map.get(key);
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = head.next;
            n.prev = head;
            head.next.prev = n;
            head.next = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node{
    Node prev;
    Node next;
    int key;
    int val;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    public Node(){
        super();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
