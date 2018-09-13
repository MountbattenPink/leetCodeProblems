/**
#559. Maximum Depth of N-ary Tree
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:

 {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},
 {"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},
 {"$id":"4","children":[],"val":4}],"val":1}

We should return its max depth, which is 3.

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
*/

class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if (root==null) return 0;
        int maxDepth = 1;
        return maxDepth(root, maxDepth, 1);
    }
    
    public int maxDepth(Node root, int maxDepth, int currentDepth) {
        if (root.children.isEmpty()) {
            maxDepth=Math.max(maxDepth, currentDepth);
        }
        else for (Node n:root.children){
            maxDepth=Math.max(maxDepth, maxDepth(n,maxDepth, currentDepth+1));
        }
        return maxDepth;
    }
    
}
