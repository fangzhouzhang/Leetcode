import java.util.*;

public class _1302DeepestLeavesSum {
	public int deepestLeavesSum(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int tmp = 0;
			for (int k = 0; k < size; k++) {
				TreeNode cur = q.poll();
				tmp += cur.val;
				if (cur.left != null) q.add(cur.left);
				if (cur.right != null) q.add(cur.right);
			}
			res = tmp;
		}
		return res;
	}
}
