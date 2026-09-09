/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        inOrder(root1,first);
        inOrder(root2,second);
        int r=0,l=0;
        while(l<first.size() && r<second.size()){
            if(first.get(l)<=second.get(r)){
                result.add(first.get(l));
                l++;
            }
            else {
                result.add(second.get(r));
                r++;
            }
        }
        while(l<first.size()){
            result.add(first.get(l));
            l++;
        }
        while(r<second.size()){
            result.add(second.get(r));
            r++;
        }
        return result;
    }
    private void inOrder(TreeNode root,List<Integer> ls){
        if(root==null) return;
        inOrder(root.left,ls);
        ls.add(root.val);
        inOrder(root.right,ls);
    }
}