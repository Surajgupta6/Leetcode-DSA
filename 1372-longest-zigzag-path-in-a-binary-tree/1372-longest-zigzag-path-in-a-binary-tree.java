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
    int len=0;
    public int longestZigZag(TreeNode root) {
        dfs(root,0,0);
        return len;
    }
    private void dfs(TreeNode root,int side,int size){
        if(root==null){
            return;
        }
        len=Math.max(len,size);
        if(side==0){
            dfs(root.left,0,1);
            dfs(root.right,1,size+1);
        }
        else{
            dfs(root.right,1,1);
            dfs(root.left,0,size+1);
        }
    }
}