/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
    //    Approach 3 - Single pass hashmap
    HashMap<Node,Node> map=new HashMap<>();
    Node curr=head;
    map.put(null,null);

    while(curr!=null){
        //put in the node with its value
        if(!map.containsKey(curr)){
            map.put(curr,new Node(0));
        }

        map.get(curr).val=curr.val;

//put in the node that curr node points to
if(!map.containsKey(curr.next)){
    map.put(curr.next,new Node(0));
}

map.get(curr).next=map.get(curr.next);

//put in the node that curr node randomly points to
if(!map.containsKey(curr.random)){
    map.put(curr.random,new Node(0));
}

map.get(curr).random=map.get(curr.random);
curr=curr.next;
    }
    return map.get(head); 
    }
}
