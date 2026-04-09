/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //DFS APPROACH
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> nodeCopies=new HashMap<>();
       return cloneGraphRecursive(node,nodeCopies);
    }

    private Node cloneGraphRecursive(Node node,HashMap<Node,Node> nodeCopies){
 if(node==null) return null;
 Node newNode=null;
        if(!nodeCopies.containsKey(node)){
        newNode=new Node(node.val);
            nodeCopies.put(node,newNode);
        }else{
newNode=nodeCopies.get(node);
return newNode;
        }
        for(int i=0;i<node.neighbors.size();i++){
         Node neighbor=node.neighbors.get(i);
         newNode.neighbors.add(cloneGraphRecursive(neighbor,nodeCopies));

        }
        return newNode;
    }
}