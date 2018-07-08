public class MaximumDepthofBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     * time : o(n) space : o(h)
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {//Base case
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
