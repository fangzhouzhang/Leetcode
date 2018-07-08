import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    /**
     * @param root: the root of binary tree.
     * @return: true if it is a complete binary tree, or false.
     * time:o(n) space:o(n)
     */
    public boolean isComplete(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean nullChild = false;
        while (!queue.isEmpty()) {
            //int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                /*if (nullChild == true) {
                    return false;
                }*/
                TreeNode node = queue.poll();
                if (node.left != null && nullChild == true) {
                    return false;
                } else if (node.left != null && nullChild == false) {
                    queue.offer(node.left);
                } else if (node.left == null) {
                    nullChild = true;
                }
                if (node.right != null && nullChild == true) {
                    return false;
                } else if (node.right != null && nullChild == false) {
                    queue.offer(node.right);
                } else if (node.right == null) {
                    nullChild = true;
                }
            }
        }
        return true;
    }
}
