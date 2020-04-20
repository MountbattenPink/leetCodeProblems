/*
Return the root node of a binary search tree that matches the given preorder traversal.
(Recall that a binary search tree is a binary tree where for every node, any descendant of node.
left has a value < node.val, and any descendant of node.right has a value > node.val.  
Also recall that a preorder traversal displays the value of the node first, then traverses node.left, 
then traverses node.right.)
Example 1:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
Note: 
1 <= preorder.length <= 100
The values of preorder are distinct.
*/

package com.olsh;
import com.olsh.entities.TreeNode;

class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length==0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        for (int item: preorder)insert(root, item);
        return root;
    }
    
    public void insert(TreeNode root, int item){
        if (root.val>item){
            if (root.left==null) root.left = new TreeNode(item);
            else insert(root.left, item);
        }
        else if (root.val<item){
            if (root.right==null) root.right = new TreeNode(item);
            else insert(root.right, item);
        }
    }
}
