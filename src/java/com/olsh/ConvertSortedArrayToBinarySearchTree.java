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
