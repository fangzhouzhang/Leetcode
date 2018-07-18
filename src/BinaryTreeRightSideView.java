import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    /*
     * @param source: treenode root
     * @return: results
     * bfs version
     * time : o(n) space: o(n)
     */
    public List<Integer> rightView(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
        }
        return res;
    }
    /*
     * @param source: treenode root
     * @return: results
     * dfs version
     * time : o(n) space: o(n)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, 0, root);
        return res;
    }
    public void dfs(List<Integer> res, int level, TreeNode root) {
        if (root == null) {
            return;//base case
        }
        if (level == res.size()) {
            res.add(root.val);
        }
        dfs(res, level + 1, root.right);
        dfs(res, level + 1, root.left);
    }
}
