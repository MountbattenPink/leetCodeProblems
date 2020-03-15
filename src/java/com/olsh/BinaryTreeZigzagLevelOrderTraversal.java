/*
103. Binary Tree Zigzag Level Order Traversal
Medium

Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

package com.olsh;
import java.lang.List;
import java.lang.Integer;
import java.lang.ArrayList;
import com.olsh.entities;

class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        zigzagLevelOrder(root, res, 0);
        return res;
    }
    
    public void zigzagLevelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root!=null){
            if (res.size()<=level)
                res.add(new LinkedList<>());
            if (level%2==0)
                res.get(level).add(root.val);
                else res.get(level).add(0, root.val);
            zigzagLevelOrder(root.left, res, level+1);
            zigzagLevelOrder(root.right, res, level+1);
            
        }
    }
}
