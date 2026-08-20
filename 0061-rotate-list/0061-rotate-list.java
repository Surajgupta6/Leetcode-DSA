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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int size=1;
        ListNode start=head;
        ListNode end=head;
        while(end.next!=null){
            size++;
            end=end.next;
        }
        end.next=start;
        k=k%size;
        int steps=size-k-1;
        while(steps-->0){
            start=start.next;
        }
        ListNode next=start.next;
        start.next=null;
        return next;
    }
}