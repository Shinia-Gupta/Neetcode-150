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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res=new ArrayList<>();
        // if(root!=null) res.add(root.val);
        // int depth=findDepth(TreeNode root);
        // int[] currentDepth=new int[1]{0};
//  res.add(root.val);
        helper(root,res,0);

//  if(currentDepth[0]<depth && root.left!=null) {
//     helper(root.left,res);
//     // res.add(root.left.val);
//     }
        return res;
    }

    private void helper(TreeNode root,List<Integer> res,int depth){
        if(root==null) return;
if(res.size()==depth){
    res.add(root.val);
}
    // currentDepth[0]++;
// if(currentDepth[0])
    // res.add(root.val);
    // if(root.right!=null)
    helper(root.right,res,depth+1);
    // else 
    helper(root.left,res,depth+1);

    }

//     private int findDepth(TreeNode root){
//     if(root==null) return 0;

//     int leftDepth=findDepth(root.left);
//     int rightDepth=findDepth(root.right);
//     return Math.max(leftDepth,rightDepth)+1;
// }
}
