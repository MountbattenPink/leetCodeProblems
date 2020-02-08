/*
1315. Sum of Nodes with Even-Valued Grandparent
Given a binary tree, return the sum of values of nodes with even-valued grandparent.  
(A grandparent of a node is the parent of its parent, if it exists.)
If there are no nodes with an even-valued grandparent, return 0.
Example 1:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the 
blue nodes are the even-value grandparents.
*/

package com.olsh;
import com.olsh.entities.TreeNode;

class SumofNodeswithEvenValuedGrandparent {
    
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        sumEvenGrandparents(root, 0, 0);
        return sum;
    }
    
    public void sumEvenGrandparents(TreeNode root, int grandparent, int parent){
        if (root!=null){
            if (grandparent==2)sum+=root.val;
            sumEvenGrandparents(root.left, parent==1?parent+1:0, root.val%2==0?1:0);
            sumEvenGrandparents(root.right, parent==1?parent+1:0, root.val%2==0?1:0);            
        } 
    }
}
