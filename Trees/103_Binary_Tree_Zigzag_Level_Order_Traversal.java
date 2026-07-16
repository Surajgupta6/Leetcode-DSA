package Trees;

class 103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int flag = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (flag == 1) {
                    TreeNode node = queue.pollFirst();
                    ls.add(node.val);
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }

                } else {
                    TreeNode node = queue.pollLast();
                    ls.add(node.val);
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }

                }
            }
            flag = flag * -1;
            ans.add(ls);
        }
        return ans;
    }
}
