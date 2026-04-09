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
        if(node==null) return null;

        HashMap<Node,Node> nodeCopies=new HashMap<>();
        Queue<Node> nodes=new LinkedList<>();
        nodes.add(node);
        Node newNode=new Node(node.val);
        nodeCopies.put(node,newNode);
        
        while(!nodes.isEmpty()){
            Node nextNode=nodes.poll();
            for(Node neighbor:nextNode.neighbors){
                if(!nodeCopies.containsKey(neighbor)){
                    Node neighborClone=new Node(neighbor.val);
                    nodeCopies.put(neighbor,neighborClone);
                    nodes.add(neighbor);
                }
                nodeCopies.get(nextNode).neighbors.add(nodeCopies.get(neighbor));
            }
        }
        return nodeCopies.get(node);
    }
}