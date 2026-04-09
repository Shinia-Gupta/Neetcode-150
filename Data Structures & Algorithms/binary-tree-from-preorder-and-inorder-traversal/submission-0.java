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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
    return build(0,preorder.length-1,preorder,0,inorder.length-1,inorder,map);
    }

    private TreeNode build(int preStart,int preEnd,int[] preorder,int inStart,int inEnd,int[] inorder,Map<Integer,Integer> map){
        if(preStart>preEnd||inStart>inEnd) return null;

TreeNode root=new TreeNode(preorder[preStart]);

int inorderRootIndex=map.get(root.val);
int remainingElem=inorderRootIndex-inStart;

root.left=build(preStart+1,preEnd,preorder,inStart,inorderRootIndex-1,inorder,map);
root.right=build(preStart+remainingElem+1,preEnd,preorder,inorderRootIndex+1,inEnd,inorder,map);

return root;

    }

}
