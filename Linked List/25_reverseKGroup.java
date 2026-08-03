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
class 26_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    int size = 0;
    ListNode temp = head;
    while (temp != null) {
        size++;
        temp = temp.next;
    }
    return helper(head, size, k);
}
    private ListNode helper(ListNode node,int size,int k){
        if(k>size){
            return node;
        }
        ListNode prev=null;
        ListNode curr=node;
        ListNode next=null;
        for(int i=0;i<k;i++){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        node.next=helper(curr,size-k,k);
        return prev;
    }
}