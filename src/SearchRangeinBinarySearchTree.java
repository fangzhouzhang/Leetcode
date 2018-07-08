import java.util.ArrayList;
import java.util.List;

public class SearchRangeinBinarySearchTree {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     * naive solution
     * time: o(n) space:o(h)
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        helper(root, k1, k2, res);
        return res;
    }
    public void helper(TreeNode root, int k1, int k2, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, k1, k2, res);
        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }
        helper(root.right, k1, k2, res);
    }
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     * pruning solution
     * time: o(n) space:o(h)
     */
    public List<Integer> searchRange1(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        helper1(root, k1, k2, res);
        return res;
    }
    public void helper1(TreeNode root, int k1, int k2, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            helper(root.left, k1, k2, res);
        }
        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }
        if (root.val < k2) {
            helper(root.right, k1, k2, res);
        }
    }
}
