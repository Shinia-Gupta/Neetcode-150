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
    public ListNode removeNthFromEnd(ListNode head, int n) {
return rec(head,new int[]{n});
    }
    private static ListNode rec(ListNode head,int[] n){
        if(head==null) return null;

        head.next=rec(head.next,n);
        n[0]--;

        if(n[0]==0){
            return head.next;
        }

        return head;
    }
}
