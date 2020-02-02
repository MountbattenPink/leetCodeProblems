/*
199. Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */

package com.olsh;

import com.olsh.entities.TreeNode;
import java.util.ArrayList;
import java.util.List;

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        getRightPart(root, list, 0);
        return list;
    }

    public void getRightPart(TreeNode root, List<Integer> list, int currentLevel) {
        if (root!=null){
            if (list.size()<=currentLevel)
                list.add(root.val);
            getRightPart(root.right, list, currentLevel+1);
            getRightPart(root.left, list, currentLevel+1);
        }
    }

}
