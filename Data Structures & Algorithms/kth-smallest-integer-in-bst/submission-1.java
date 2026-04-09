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
    public int kthSmallest(TreeNode root, int k) {
      //no matter what, we need to go to the left subtree only
      //maintain a count that will be global, basically will check if count=k, then that is the kth smallest node.
      //if count is less than k eeven after visiting the left subtree, go to right subtree of the bst and then start finding the node.
      //also we cannot send a nor,al integer count becuse count variable 
      //will be maintained as a copy in each recursion call and not as a single count throughout the recursion.

//my code was initially root->left->right i.e it was preorder traversal
//correct one is left->root->right. I need inorder traversal i.e left->root->right
int[] count=new int[]{0,0};
 kthHelper(root,k,count);
 return count[1];
    }

    private void kthHelper(TreeNode root,int k,int[] count){
        if(root==null) return;

         kthHelper(root.left,k,count);
        if(count[0]<k){
        count[0]++;
        if(count[0]==k){
        count[1]= root.val;
        return;
        }
        }
        //  if(count[0]<k)
         kthHelper(root.right,k,count);
    }
}
