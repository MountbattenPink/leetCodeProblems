/**
#104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.
Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/

package com.olsh;
import com.olsh.entities.TreeNode;

class MaximumDepthofBinaryTree {
 public int maxDepth(TreeNode root) {
  return maxDepth(root, 0);
 }
 public int maxDepth(TreeNode root, int depth) {
  if (root == null) return depth;
  else return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
 }
}
