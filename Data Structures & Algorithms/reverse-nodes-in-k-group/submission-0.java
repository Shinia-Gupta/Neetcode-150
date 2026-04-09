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
    public ListNode reverseKGroup(ListNode head, int k) {
        //rotate the array and reverse at k nodes?...nhi...usse toh array reverse hota h shayad...
    int lengthOfList=findLength(head);
    int lastNodeNumber=lengthOfList-(lengthOfList%k);
    int count=0;
    ListNode curr=head,dummyHead=null;
ListNode prevGroupTail = null;
    while(count<lastNodeNumber){
        ListNode dummyTail=curr,prev=null;
        // ListNode groupNext = null;

        int numNodes=0;

        while(numNodes<k){
            // if(count<lastNodeNumber){
                // if (numNodes == 0) groupNext = curr.next;
            ListNode currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currNext;
            numNodes++;
            count++;
            // }
        }
if (dummyHead == null) {
    dummyHead = prev;
} else {
    prevGroupTail.next = prev;
}
prevGroupTail = dummyTail;
        // dummyTail=prev;
        // subTail=prev;
        // subTail.next=curr;
        dummyTail.next=curr;
    }
    return dummyHead;
    
    }
    private int findLength(ListNode head){
        ListNode curr=head;
        int len=0;
        while(curr!=null){
            len++;curr=curr.next;
        }
        return len;
    }
}
