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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null || l2!=null||carry!=0){
        int node1=0,node2=0;
            if(l1!=null){
node1=l1.val;
            }
            if(l2!=null){
                node2=l2.val;
            }


// int node1=l1.val,node2=l2.val;
int sum=node1+node2+carry;
carry=sum/10;
int digit=sum%10;
ListNode newNode=new ListNode(digit);
curr.next=newNode;
curr=newNode;
if(l1!=null)
l1=l1.next;
if(l2!=null)
l2=l2.next;
        }
        return dummy.next;
    }
}
