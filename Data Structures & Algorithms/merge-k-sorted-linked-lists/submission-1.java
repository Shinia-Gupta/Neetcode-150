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
        ListNode newHead=new ListNode(0);
        ListNode curr=newHead;
        while(true){
            int minNode=-1;
            for(int i=0;i<lists.length;i++){
                
                //if that head is null, we dont need to compare it with minNode,
                //so skip that iteration or head
                if(lists[i]==null){
                    continue;
                }

                //if minNode is null, or minNode's value is greater than the current head being referenced, 
                //modify the minNode to the new Head index
                if(minNode==-1||lists[minNode].val>lists[i].val){
                    minNode=i;
                }

            }

            //if all heads in the params list are null, 
            //we can't traverse and merge anything as lists are empty 
            if(minNode==-1){
                break;
            }
            //append the next smallest element head to the list being formed 
            curr.next=lists[minNode];
            //update the head to the new head
            lists[minNode]=lists[minNode].next;
            //update the current node to the next element
            curr=curr.next;
        }
        return newHead.next;
    }
}
