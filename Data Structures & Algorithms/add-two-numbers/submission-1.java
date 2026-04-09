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
        return add(l1,l2,0);
    }

    private ListNode add(ListNode l1,ListNode l2,int carry){
        if(l1==null && l2==null && carry==0){
            return null;
        }

int node1Val=l1!=null?l1.val:0;
int node2Val=l2!=null?l2.val:0;

int currSum=node1Val+node2Val+carry;
int currNodeVal=currSum%10;
carry=currSum/10;

ListNode nextNode=add(l1==null?null:l1.next,l2==null?null:l2.next,carry);

return new ListNode(currNodeVal,nextNode);

    }
}
