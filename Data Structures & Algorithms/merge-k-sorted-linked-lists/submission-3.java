/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
PriorityQueue<ListNode> minHeap=new PriorityQueue<>((a,b)->a.val-b.val);

//add the current heads of the list into min heap
//this will add nodes in increasing order of their values
//so peak of the heap will always have the node with smallest value
for(ListNode list:lists){
    if(list!=null){
        minHeap.offer(list);
    }
}
ListNode dummy=new ListNode(0),curr=dummy;

while(!minHeap.isEmpty()){
ListNode minNode=minHeap.poll();
curr.next=minNode;
curr=curr.next;
minNode=minNode.next;
if(minNode!=null){
    minHeap.offer(minNode);
}
}
return dummy.next;
    }
}
