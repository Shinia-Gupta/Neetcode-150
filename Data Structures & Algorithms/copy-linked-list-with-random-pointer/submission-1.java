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
        //normal copy of list
Node curr=head;
while(curr!=null){
    Node dupCopy=new Node(curr.val);
    Node currNext=curr.next;
    curr.next=dupCopy;
    dupCopy.next=currNext;
    curr=currNext;      //curr=curr.next.next possible? is it same?
}

curr=head;
//add next and random pointers
while(curr!=null){
    Node dupCopy=curr.next;
    // dupCopy.next=dupCopy.next!=null?dupCopy.next.next:null;
    dupCopy.random=curr.random!=null?curr.random.next:null;
    curr=curr.next.next;
}

//unwind interleaving
curr=head;
Node newHead=null,newTail=null;
while(curr!=null){
    if(newHead==null) {newHead=curr.next;newTail=curr.next;}
    curr.next=curr.next.next;
    if(newTail.next!=null){

    newTail.next=newTail.next.next;
    }
    curr=curr.next;
    newTail=newTail.next;
}
return newHead;
    }
}
