import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		if (root == null) {
			return -1;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0 ; i < size; i++) {
				TreeNode n = q.poll();
				if (i == 0) res = n.val;
				if (n.left != null) q.add(n.left);
				if (n.right != null) q.add(n.right);
			}
		}
		return res;
	}
}
