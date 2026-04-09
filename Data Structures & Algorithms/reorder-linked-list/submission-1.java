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
    static ListNode root;
    public void reorderList(ListNode head) {
        root=head;
        ListNode tail=head;
    reOrderList(tail);
    }

    private static void reOrderList(ListNode tail){
if(tail==null){
    return;
}
reOrderList(tail.next);
if(root==null) return;
if(root==tail|| tail.next==root){
    root.next=null;
    root=null;
    return;
}
ListNode temp=root.next;
root.next=tail;
tail.next=temp;
root=temp;
    }
}
