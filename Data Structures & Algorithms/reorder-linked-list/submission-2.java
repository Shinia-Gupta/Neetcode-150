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
    // Note- recursion mei, root node and tail nodes are passed by value only..means a copy of reference is passed. isliye har baar root node ki separate call stack k hisab se local copy bnti h.
    // aur fir jab hum root=temp krte h toh same hi copy of root mei temp ja rha hota h..means if root=1, toh har rec call stack mei root=1 only and root=temp does not assig n the value of temp to an updated root value. it always assigns the root with root.next i.e the same next value of root.
    // tail k case mei hme uski copy of reference chahiye thi taki hum next pointer update kr sake... of the root 
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
