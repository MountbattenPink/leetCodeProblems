/*
366. Find Leaves of Binary Tree
Given a binary tree, collect a tree's nodes as if you were doing this: 
Collect and remove all leaves, repeat until the tree is empty.
Example:
Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]
Explanation:
1. Removing the leaves [4,5,3] would result in this tree
          1
         / 
        2         
2. Now removing the leaf [2] would result in this tree:
          1          
3. Now removing the leaf [1] would result in the empty tree:
          []         
*/


package com.olsh;

import com.olsh.entities.TreeNode;
import java.lang.List;
import java.lang.ArrayList;
import java.util.Math;

class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>>nodes = new ArrayList<>();
        findLeaves(nodes, root);
        return nodes;
    }
    public int findLeaves(List<List<Integer>>list, TreeNode root){
        if (root==null)return -1;
        int level = 0;
        if (root.left==null && root.right==null){
            level=0;
        } else {
            level = Math.max(findLeaves(list, root.left),findLeaves(list, root.right))+1;
        }
        while (level+1>list.size()){
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        return level;
    }
    
}
