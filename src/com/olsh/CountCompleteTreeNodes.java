/**
222. Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.
Note:
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, 
is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
Example:
Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
*/

package com.olsh;
import com.olsh.entities.TreeNode;
public class CountCompleteTreeNodes {
    class Search{
        int level;
        boolean searchFinished;
        int count;
    }
    public int countNodes(TreeNode root) {
        Search search = new Search();
        search.level = countLevel(root, 0);
        search.count = 0;
        search.searchFinished = false;
        countNodes(1,root, search);
        return (int)(Math.pow(2, search.level-1)-1) + search.count;
    }

    public int countLevel(TreeNode root, int i) {
        if (root==null)return 0;
        else return 1 + countLevel(root.left, i);
    }

    public void countNodes(int localLevel, TreeNode root, Search search){
        if (localLevel<search.level && !search.searchFinished) 
                {
                    countNodes(localLevel+1,root.left, search);
                    countNodes(localLevel+1,root.right, search);
                }
        else if (localLevel==search.level) {
            if (root==null)search.searchFinished=true;
            else search.count++;
        }
    }

}
