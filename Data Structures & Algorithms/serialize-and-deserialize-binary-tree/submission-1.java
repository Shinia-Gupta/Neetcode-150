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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
Queue<TreeNode> q=new LinkedList<>();
String res="";
q.add(root);
while(!q.isEmpty()){
TreeNode polledRoot=q.poll();
if(!res.equals(""))res+=",";
res+=polledRoot!=null?String.valueOf(polledRoot.val):String.valueOf(polledRoot);
if(polledRoot!=null){
    q.add(polledRoot.left);
    q.add(polledRoot.right);

}

}
// System.out.println(res+"...res");
  return res;

    }

    // Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) return null;

    String[] arr = data.split(",");
    if (arr[0].equals("null")) return null;

    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int i = 1;

    while (!q.isEmpty() && i < arr.length) {
        TreeNode curr = q.poll();

        // LEFT child
        if (i < arr.length && !arr[i].equals("null")) {
            curr.left = new TreeNode(Integer.parseInt(arr[i]));
            q.add(curr.left);
        }
        i++;

        // RIGHT child
        if (i < arr.length && !arr[i].equals("null")) {
            curr.right = new TreeNode(Integer.parseInt(arr[i]));
            q.add(curr.right);
        }
        i++;
    }

    return root;
}

}
