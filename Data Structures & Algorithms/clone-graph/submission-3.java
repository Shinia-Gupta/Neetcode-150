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
    public Node cloneGraph(Node node) {
        Queue<Node> nodes=new LinkedList<>();
        HashMap<Node,Node> nodeCopies=new HashMap<>();
        return clonebfs(node,nodes,nodeCopies);
    }

    private Node clonebfs(Node node,Queue<Node> nodes, HashMap<Node,Node> nodeCopies){
        if(node==null) return null;
        Node newNode=new Node(node.val);
        nodes.add(node);
        nodeCopies.put(node,newNode);

        while(!nodes.isEmpty()){
            Node currNode=nodes.poll();
            for(Node neighbor:currNode.neighbors){
        if(!nodeCopies.containsKey(neighbor)) {
        Node newClone=new Node(neighbor.val);
        nodeCopies.put(neighbor,newClone);
        nodes.add(neighbor);
        }
                        nodeCopies.get(currNode).neighbors.add(nodeCopies.get(neighbor));

            }
        }
        return newNode;
    }
}