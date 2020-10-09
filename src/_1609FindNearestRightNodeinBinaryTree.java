import java.util.LinkedList;
import java.util.Queue;

public class _1609FindNearestRightNodeinBinaryTree {
	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
		if (root == null || u == null) return null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode res = null;
		while (!q.isEmpty()) {
			int size = q.size();
			int idx = -1;
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (cur == u) {
					// Next will be answer
					idx = i + 1;
				}
				if (i == idx) return cur;
				if (cur.left != null) q.add(cur.left);
				if (cur.right != null) q.add(cur.right);
			}
		}
		return null;
	}
}
