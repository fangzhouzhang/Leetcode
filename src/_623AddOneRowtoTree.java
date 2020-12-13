import java.util.LinkedList;
import java.util.Queue;

public class _623AddOneRowtoTree {
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (root == null) return root;
		if (d == 1) {
			TreeNode newHead = new TreeNode(v);
			newHead.left = root;
			return newHead;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int height = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				TreeNode left = cur.left;
				TreeNode right = cur.right;
				if (height == d - 1) {
					TreeNode l = new TreeNode(v);
					cur.left = l;
					if (left != null) {
						l.left = left;
					}
					TreeNode r = new TreeNode(v);
					cur.right = r;
					if (right != null) {
						r.right = right;
					}
				}
				if (left != null) q.add(left);
				if (right != null) q.add(right);
			}
			if (height == d - 1) break;
			height++;
		}
		return root;
	}
}
