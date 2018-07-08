public class TweakedIdenticalBinaryTree {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are tweaked identical, or false.
     * time:o(n^2) space:o(h)
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        }
        return isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right) ||
                isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left);

    }
}
