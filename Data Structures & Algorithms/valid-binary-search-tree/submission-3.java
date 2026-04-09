/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }

    private boolean isValidBST(TreeNode root,Integer minReq,Integer maxReq){
if(root==null) return true;

//right subtree check
if(minReq!=null && root.val<=minReq){
    return false;
}

//left subtree check
if(maxReq!=null && root.val>=maxReq){
    return false;
}

return isValidBST(root.left,minReq,root.val) && isValidBST(root.right,root.val,maxReq);
    }
}
