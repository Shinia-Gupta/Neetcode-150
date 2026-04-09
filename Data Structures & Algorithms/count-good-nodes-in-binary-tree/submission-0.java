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
    public int goodNodes(TreeNode root) {
        //can use minimum node val encountered so far
        //count number of good nodes in left subtree and right subtree individually + the root node
        int leftGoodNodes=goodNodesHelper(root.left,root.val);
        int rightGoodNodes=goodNodesHelper(root.right,root.val);
        return leftGoodNodes+rightGoodNodes+1;
    }

    private int goodNodesHelper(TreeNode currentNode,int maxEncounteredSoFar){
        if(currentNode==null) return 0;

        if(maxEncounteredSoFar<=currentNode.val){
            maxEncounteredSoFar=Math.max(maxEncounteredSoFar,currentNode.val);
return 1+goodNodesHelper(currentNode.left,maxEncounteredSoFar)+goodNodesHelper(currentNode.right,maxEncounteredSoFar);
        }else{
            return goodNodesHelper(currentNode.left,maxEncounteredSoFar)+goodNodesHelper(currentNode.right,maxEncounteredSoFar);
 
        }

    }
}
