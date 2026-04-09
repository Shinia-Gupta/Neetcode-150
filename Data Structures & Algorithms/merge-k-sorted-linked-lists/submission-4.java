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
        if(lists.length==0) return null;
        for(int i=1;i<lists.length;i++){
            lists[i]=merge(lists[i-1],lists[i]);
        }
        return lists[lists.length-1];
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0),curr=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                curr.next=l1;
                curr=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                curr=l2;
                l2=l2.next;
            }
        }

        while(l1!=null){
                curr.next=l1;
                curr=l1;
                l1=l1.next;
        }

        while(l2!=null){
                curr.next=l2;
                curr=l2;
                l2=l2.next;
        }
    return dummy.next;
    }
}
