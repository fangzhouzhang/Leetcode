public class BinaryTreeUpsideDown {
    /**
     * @param root: the root of binary tree
     * @return: new root
     * time : o(n)
     * space: o(n) tree is not balanced
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newHead = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newHead;
    }
}
