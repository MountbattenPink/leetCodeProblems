/**
#98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
*/

package com.olsh;
import com.olsh.entities.TreeNode;

class ValidateBinarySearchTree {
       public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, true);
       }
    
     public boolean isValidBST(TreeNode root, Double max, Double min, boolean toLeft) {
         if (root==null) return true;
         if (!(root.val > min && root.val < max)) return false;
         return isValidBST(root.left, (double)root.val, min, true) && isValidBST(root.right, max, (double)root.val, false);
     }
}
