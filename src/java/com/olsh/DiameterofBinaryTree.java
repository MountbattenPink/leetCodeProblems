class DiameterofBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return max;
    }
    
    public void getDiameter(TreeNode root){
        if (root!=null){
            if (root.left==null && root.right==null){
                root.val = 0;
                max = Math.max(max, root.val);
            }
            else if (root.right==null){
                getDiameter(root.left);
                root.val = root.left.val+1;
                max = Math.max(max, root.val);
            }
            else if (root.left==null){
                getDiameter(root.right);
                root.val = root.right.val+1;
                max = Math.max(max, root.val);
            }
            else {
                getDiameter(root.left);
                getDiameter(root.right);
                root.val = Math.max(root.left.val, root.right.val)+1;
                max = Math.max(max, root.left.val+root.right.val+2);
            }
        }
    }
}
