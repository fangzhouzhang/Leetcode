import java.util.ArrayList;

public class BinarySearchTreeIterator {
	class BSTIterator {
		private ArrayList<TreeNode> nodes;
		private int index;
		public BSTIterator(TreeNode root) {
			index = 0;
			nodes = new ArrayList<>();
			addNodes(root, nodes);
		}

		/** @return the next smallest number */
		public int next() {
			if (index < nodes.size()) {
				int res = nodes.get(index).val;
				index++;
				return res;
			}
			return Integer.MIN_VALUE;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			if (index >= nodes.size()) {
				return false;
			} else {
				return true;
			}
		}
		private void addNodes(TreeNode root, ArrayList<TreeNode> nodes) {
			if (root == null) {
				return;
			}
			addNodes(root.left, nodes);
			nodes.add(root);
			addNodes(root.right, nodes);
		}
	}
}
