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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead=null,newTail=null,head1=list1==null?null:list1,head2=list2==null?null:list2;
        while(head1!=null && head2!=null){
            if(newHead==null){
                if(head1.val<=head2.val){
                    newHead=head1;
                    newTail=head1;
                    head1=head1.next;
                }else{
                    newHead=head2;
                    newTail=head2;
                    head2=head2.next;
                }
            }else{
               if(head1.val<=head2.val){
                    // newHead.next=head1;
                    newTail.next=head1;
                    newTail=head1;
                    head1=head1.next;
                }else{
                    // newHead.next=head1;
                    newTail.next=head2;
                    newTail=head2;
                    head2=head2.next;
                } 
            }

        }

        while(head1!=null){
            if(newHead==null){
                 newHead=head1;
                    newTail=head1;
                    head1=head1.next;
            }else{
        newTail.next=head1;
        newTail=head1;
        head1=head1.next;  
        }
        }

        while(head2!=null){
                       if(newHead==null){
                 newHead=head2;
                    newTail=head2;
                    head2=head2.next;
            }else{
        newTail.next=head2;
        newTail=head2;
        head2=head2.next; 
        }
        }

        return newHead;
    }
}