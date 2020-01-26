package com.olsh;

import com.olsh.entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
236. Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Note:
All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 */

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        ancestor(root, p, pList);
        ancestor(root, q, qList);
        TreeNode res = root;
        for (int i = 0; i < Math.min(pList.size(), qList.size()); i++) {
            if (pList.get(pList.size() - 1 - i).val == qList.get(qList.size() - 1 - i).val)
                res = pList.get(pList.size() - 1 - i);
            else break;
        }
        return res;
    }


    public boolean ancestor(TreeNode root, TreeNode x, List<TreeNode> xList) {
        if (root != null && (root == x || ancestor(root.left, x, xList) || ancestor(root.right, x, xList))) {
            xList.add(root);
            return true;
        }
        return false;
    }

}