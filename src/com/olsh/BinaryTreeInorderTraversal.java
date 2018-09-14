/**
#94. Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

package com.olsh;
import com.olsh.entities.TreeNode;

class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root==null) return res;
        TreeNode t = root;
        stack.push(t);
        boolean goToLeft = true;
        while(!stack.isEmpty()){
            t = stack.peek();
            while (goToLeft && t.left!=null){ // add all left subtrees until reach leaves
                stack.push(t.left);
                t=t.left;
            }
            res.add(stack.pop().val); // stack's top element - delete and move to result list
            goToLeft = false;
            if (!goToLeft && t.right!=null){ // add one right subtrees
                stack.push(t.right);
                t=t.right;
                goToLeft = true;
            }
            
        }   
    return res;
    }  
}
