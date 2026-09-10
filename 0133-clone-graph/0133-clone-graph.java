/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node,Node> hm = new HashMap<>();
        Node copy = new Node(node.val);
        hm.put(node,copy);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node top = queue.poll();
            for(Node curr : top.neighbors){
                if(!hm.containsKey(curr)){
                    hm.put(curr,new Node(curr.val));
                    queue.offer(curr);
                }
                hm.get(top).neighbors.add(hm.get(curr));
            }
        }
        return copy;
    }
}