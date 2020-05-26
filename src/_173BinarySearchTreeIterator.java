import java.util.ArrayList;
import java.util.List;

public class _173BinarySearchTreeIterator {
	class BSTIterator {
		List<Integer> nodes;
		int idx = 0;
		public BSTIterator(TreeNode root) {
			nodes = new ArrayList<>();
			dfs(root);
		}

		private void dfs(TreeNode root) {
			if (null == root) return;
			dfs(root.left);
			nodes.add(root.val);
			dfs(root.right);
		}

		/** @return the next smallest number */
		public int next() {
			if (hasNext()) return nodes.get(idx++);
			else return -1;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return idx < nodes.size();
		}
	}
}
