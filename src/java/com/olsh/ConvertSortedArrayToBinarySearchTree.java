/*
108. Convert Sorted Array to Binary Search Tree
Easy

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
package com.olsh;
import com.olsh.entities.TreeNode;

class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBinaryTree(nums, 0, nums.length-1);
    }
    
    public TreeNode createBinaryTree(int[] nums, int start, int finish){
        TreeNode root = null;
        if (start<=finish){
            int index = start+(finish-start)/2;
            root = new TreeNode(nums[index]);
            root.left = createBinaryTree(nums, start, index-1);
            root.right = createBinaryTree(nums, index+1, finish);
        }
        return root;
    }
}
