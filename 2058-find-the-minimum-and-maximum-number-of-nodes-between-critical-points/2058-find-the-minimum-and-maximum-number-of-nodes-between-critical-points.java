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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode prev=head;
        ListNode curr=prev.next;
        int j=2;
        while(curr.next!=null){
            ListNode next=curr.next;
            if(prev.val<curr.val && curr.val>next.val){
                list.add(j);
            }
            else if(prev.val>curr.val && curr.val<next.val){
                list.add(j);
            }
            prev=curr;
            curr=next;
            j++;
        }
        if(list.size()<2) return new int[]{-1,-1};
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            min=Math.min(list.get(i)-list.get(i-1),min);
        }
        return new int[]{min,list.get(list.size()-1)-list.get(0)};
    }
}