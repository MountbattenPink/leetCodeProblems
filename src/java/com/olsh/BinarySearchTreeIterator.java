/*
173. Binary Search Tree Iterator
Medium
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Example:
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
Note:
    next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    You may assume that next() call will always be valid, that is, there will be at least a next smallest number in
    the BST when next() is called.
*/
package com.olsh;
import com.olsh.entities.TreeNode;
import java.lang.Deque;
import java.lang.LinkedList;


class BSTIterator {
    Deque<TreeNode>stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        if (root!=null)stack.add(root);
    }
    
    /** @return the next smallest number */
    public int next() {
            while (stack.getLast().left!=null){
                TreeNode node = stack.removeLast();
                TreeNode left = node.left;
                node.left = null;
                if (node.right!=null){
                    stack.add(node.right);
                    node.right=null;
                }
                stack.add(node);
                if (left!=null)
                stack.add(left);
            }
            if (stack.getLast().right!=null){
                TreeNode node = stack.removeLast();
                stack.add(node.right);
                node.right=null;
                stack.add(node);
                }
            
        return stack.removeLast().val;
        }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
