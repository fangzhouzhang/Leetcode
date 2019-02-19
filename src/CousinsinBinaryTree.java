import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {
	/**
	 * time: o(n) space: o(n)
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null) {
			return true;
		}
		Pair[] arr = new Pair[2];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(null, root));
		int idx = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				TreeNode n = pair.node;
				if (n.left != null) {
					q.add(new Pair(n, n.left));
				}
				if (n.right != null) {
					q.add(new Pair(n, n.right));
				}
				if (n.val == x || n.val == y) {
					arr[idx] = pair;
					idx++;
				}
			}
			if (idx == 1) {
				return false;
			}
			if (idx == 2) {
				break;
			}
		}
		if (arr[0] == null && arr[1] == null) {
			return false;
		}
		if (arr[0] == null || arr[1] == null) {
			return false;
		}
		if (arr[0].parent != arr[1].parent) {
			return true;
		} else {
			return false;
		}
	}
	private class Pair {
		private TreeNode parent;
		private TreeNode node;
		public Pair(TreeNode parent, TreeNode node) {
			this.parent = parent;
			this.node = node;
		}
	}
}
