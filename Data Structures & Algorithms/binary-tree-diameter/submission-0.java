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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);
        int currentDiameter=leftHeight+rightHeight;
        int subDiameter=Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(currentDiameter,subDiameter);
    }

    private int findHeight(TreeNode root){
        if(root==null) return 0;
        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }
}
