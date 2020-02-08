/*
1302. Deepest Leaves Sum

Given a binary tree, return the sum of values of its deepest leaves.
Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Constraints:
The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
*/

package com.olsh;
import com.olsh.entities.Treenode;
import java.util.List;
import java.util.ArrayList;
import java.util.Integer;

class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        calculateSum(root, list, 0);
        return list.get(list.size()-1);
    }
    
    public void calculateSum(TreeNode root, List<Integer>list, int currentDepth){
        if (root!=null){
            if (list.size()<=currentDepth)list.add(root.val);
            else list.set(currentDepth, list.get(currentDepth)+root.val);
            calculateSum(root.left, list, currentDepth+1);
            calculateSum(root.right, list, currentDepth+1);
        }
    }
}
