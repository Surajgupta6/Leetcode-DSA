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
    int result=0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,root.val,root.val);
        return result;
    }
    private void dfs(TreeNode root,int max,int min){
        if(root==null){
            result=Math.max(result,Math.abs(max-min));
            return;
        }
        min=Math.min(root.val,min);
        max=Math.max(root.val,max);
        dfs(root.left,max,min);
        dfs(root.right,max,min);
    }
}