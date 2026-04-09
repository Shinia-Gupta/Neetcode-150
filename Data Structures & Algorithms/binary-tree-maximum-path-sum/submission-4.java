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
    public int maxPathSum(TreeNode root) {
        // if i apply dfs, on a particular set of nodes, can i return the max possible sum with those set of nodes by considering 2 cases-
        // -- either considering the current node into max possible sum 
        // -- or not considering the current node in the max possible sum.
        //then returning the max of 2 possibilities to the parent node?

        //but if there is a case where max sum for current set of nodes is the sum of all nodes, then how will the path come?
        
        //or the other way round- can i traverse to the depth, return the child node to the parent, 
        //get it added to the parent or not added to the parent and then return the max of 2 results?
        
        //or check if the sum is increasing by adding the node returned...
        //if it is...consider the node in the result otherwise dont consider it?

//we can consider...path from left side,or right side, or both...
//but if the tree is like - 
// -15 10 20 null null 15 5 5 4 null null null null
//then for the tree 15 5 4, how are we going to take its max possible sum?

//global max sum variable to be updated when calculating the maxpossible sum for a set of nodes
//return the max of sum of left tree and right tree for a node to the parent
//when it gets returned, update the global max sum...
int[] globalMaxSum=new int[]{Integer.MIN_VALUE};
maxSumHelper(root,globalMaxSum);
return globalMaxSum[0];
    }

    private int maxSumHelper(TreeNode root,int[] globalMaxSum){
//post order
if(root==null) return 0;
int leftMaxSum=Math.max(0,maxSumHelper(root.left,globalMaxSum));
int rightMaxSum=Math.max(0,maxSumHelper(root.right,globalMaxSum));
globalMaxSum[0]=Math.max(globalMaxSum[0],leftMaxSum+rightMaxSum+root.val);
return root.val+Math.max(leftMaxSum,rightMaxSum);
    }
}
