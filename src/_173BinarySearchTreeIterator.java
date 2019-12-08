import java.util.ArrayList;
import java.util.List;

public class _173BinarySearchTreeIterator {
	class BSTIterator {
		private List<TreeNode> nodes;
		private int idx;
		public BSTIterator(TreeNode root) {
			nodes = new ArrayList<>();
			idx = 0;
			inOrder(root);
		}

		/** @return the next smallest number */
		public int next() {
			return nodes.get(idx++).val;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return idx < nodes.size() ? true : false;
		}

		private void inOrder(TreeNode root) {
			if (root == null) return;
			inOrder(root.left);
			nodes.add(root);
			inOrder(root.right);
		}
	}
}
