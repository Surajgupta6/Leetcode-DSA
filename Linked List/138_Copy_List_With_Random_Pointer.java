/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
 */

// Approach : Using HashMap
// Time Complexity : O(n)
// Space Complexity : O(n)

class 138_Copy_List_With_Random_Pointer {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node dummy = head;
        while (dummy != null) {
            hm.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }
        dummy = head;
        while (dummy != null) {
            if (dummy.random != null) {
                hm.get(dummy).random = hm.get(dummy.random);
            }
            dummy = dummy.next;
        }
        Node ans = new Node(0);
        Node result = ans;
        dummy = head;
        while (dummy != null) {
            ans.next = hm.get(dummy);
            ans = ans.next;
            dummy = dummy.next;
        }
        return result.next;
    }
}
