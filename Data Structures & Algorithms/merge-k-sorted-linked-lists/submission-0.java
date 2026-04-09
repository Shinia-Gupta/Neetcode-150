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
List<Integer> res=new ArrayList<Integer>();
for(int i=0;i<lists.length;i++){
    ListNode listHead=lists[i];
    System.out.println(listHead.val);
    while(listHead!=null){
        res.add(listHead.val);
        listHead=listHead.next;
    }
}

Collections.sort(res);

ListNode newHead=new ListNode(0,null);
ListNode newTail=new ListNode(0,null);

for(int nodeVal:res){
    ListNode newNode=new ListNode(nodeVal,null);
    if(newHead.next==null){
        newHead.next=newNode;   
    }
    newTail.next=newNode;
    newTail=newNode;

}
return newHead.next;
    }
}
