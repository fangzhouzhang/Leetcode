public class LowestCommonAncestorofaBinaryTree {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     * time: o(n) space: o(h)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;// base case
        }
        //step 1
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        //step 2 + 3
        if (left != null && right != null) {
            return root;
        } else if (left != null || right != null) {
            return left == null ? right : left;
        } else  {
            return null;
        }
    }
}
