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
        //array to store the result- why?
        //---kya same array reference use hoti h instead of sharing separate references on each call stack
int res[]=new int[1];
dfs(root,res);
return res[0];
    }

    private int dfs(TreeNode root,int[] res){
        if(root==null) return 0;

        int leftHeight=dfs(root.left,res);
        int rightHeight=dfs(root.right,res);

        res[0]=Math.max(res[0],leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}
