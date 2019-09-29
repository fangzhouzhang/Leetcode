import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree {
	public int maxLevelSum(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int max = root.val;
		int level = 0;
		int best = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int cur = 0;
			for (int i = 0; i < size; i++) {
				TreeNode n = q.poll();
				cur += n.val;
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
			level++;
			if (cur > max) {
				max = cur;
				best = level;
			}
		}
		return best;
	}
}
