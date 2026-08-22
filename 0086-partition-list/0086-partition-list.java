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
    public ListNode partition(ListNode head, int x) {
        ListNode after=new ListNode();
        ListNode before=new ListNode();
        ListNode a=after;
        ListNode b=before;
        while(head!=null){
            if(head.val<x){
                before.next=head;
                head=head.next;
                before=before.next;
            }
            else{
                after.next=head;
                head=head.next;
                after=after.next;
            }
        }
        before.next=a.next;
        after.next=null;
        return b.next;
    }
}