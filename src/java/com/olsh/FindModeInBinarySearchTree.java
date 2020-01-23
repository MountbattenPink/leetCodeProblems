package com.olsh;
/**
 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 1
 \
 2
 /
 2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */

import com.olsh.entities.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindModeInBinarySearchTree {
     public int[] findMode(TreeNode root) {
           Map<Integer, Integer> modes = new HashMap<>();
           countMedians(root, modes);
           List<Integer> res = new ArrayList<>();
           int max = 0;
           for (Integer key: modes.keySet()){
               int val = modes.get(key);
               if (val>max){
                   res.clear();
                   res.add(key);
                   max=val;
               }
               else if (val==max){
                   res.add(key);
                   max=val;
               }
           }
           return res.stream().mapToInt(Integer::intValue).toArray();
        }

        public void countMedians(TreeNode root, Map<Integer, Integer> modes){
           if (root==null){
               return;
           }
           if (modes.containsKey(root.val)){
                modes.replace(root.val, modes.get(root.val)+1);
            }
            else {
               modes.put(root.val, 1);
           }
           countMedians(root.right, modes);
           countMedians(root.left, modes);
        }
}
