package Trees;

public class 124_Binary_Tree_Maximum_Path_Sum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        int path = left + right + root.val;
        maxSum = Math.max(path, maxSum);
        return root.val + Math.max(left, right);
    }
}
