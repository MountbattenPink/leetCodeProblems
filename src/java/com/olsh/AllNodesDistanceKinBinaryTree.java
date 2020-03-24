/*
863. All Nodes Distance K in Binary Tree
Medium
We are given a binary tree (with root node root), a target node, and an integer value K.
Return a list of the values of all nodes that have a distance K from the target node.  
The answer can be returned in any order.
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
Output: [7,4,1]
Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.
Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
Note:
    The given tree is non-empty.
    Each node in the tree has unique values 0 <= node.val <= 500.
    The target node is a node in the tree.
    0 <= K <= 1000.
*/
package com.olsh;
import com.olsh.entities.TreeNode;
import java.lang.List;
import java.lang.ArrayList;
import java.lang.Map;
import java.lang.HashMap;
import java.lang.Set;
import java.lang.HashSet;
import java.lang.Map.Entry;
import java.lang.Integer;


class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, TreeNode>parentDistances = new HashMap<>();
        Set<TreeNode>visited = new HashSet<>();
        Map<TreeNode, Integer>memo = new HashMap<>();
        List<Integer>res = new ArrayList<>();
        getParentDistances(parentDistances, root, target.val, visited, K, memo);
        for (Map.Entry<Integer,TreeNode>entry: parentDistances.entrySet()){
            getKDistanceNodes(entry.getValue(), entry.getKey(), K, visited, res);
        }
        return res;
    }
    
    public int getParentDistances(Map<Integer, TreeNode>parentDistances, TreeNode root, int target, Set<TreeNode>visited, int k, Map<TreeNode, Integer>memo){
        if (root!=null){
            if (memo.containsKey(root))return memo.get(root);
            int dist = 0;
            if (root.val==target) {
                visited.add(root);
                dist = 0;
            }
            else dist = Math.min(getParentDistances(parentDistances,root.left,target,visited,k, memo),getParentDistances(parentDistances,root.right,target,visited,k,memo))+1;
            if (dist<=k)
            {
                parentDistances.put(dist, root);
                visited.add(root);
            }
            return dist;
        } else return 1001;
    }
    
    public void getKDistanceNodes(TreeNode root, int current, int k, Set<TreeNode>visited, List<Integer>res){
            if (current==k) res.add(root.val);
            else if (current<k){
                if (root.left!=null && !visited.contains(root.left))
                    getKDistanceNodes(root.left, current+1, k, visited, res);
                if (root.right!=null && !visited.contains(root.right))
                    getKDistanceNodes(root.right, current+1, k, visited, res);
            }
        }
    }
