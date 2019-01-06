public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		Node newRoot = getMinNode(root);
		Node maxNode = getMaxNode(root);
		Node[] pre = new Node[1];
		dfs(root, pre, newRoot);
		newRoot.left = maxNode;
		maxNode.right = newRoot;
		return newRoot;
	}
	private void dfs(Node root, Node[] pre, Node newRoot) {
		if (root == null) {
			// pre[0] = root;
			return;
		}
		if (root == newRoot) {
			pre[0] = root;
			dfs(root.right, pre, newRoot);
			return;
		}


		dfs(root.left, pre, newRoot);
		pre[0].right = root;
		root.left = pre[0];
		pre[0] = root;
		dfs(root.right, pre, newRoot);

	}

	private Node getMinNode(Node root) {
		if (root.left != null) {
			return getMinNode(root.left);
		}
		return root;
	}

	private Node getMaxNode(Node root) {
		if (root.right != null) {
			return getMaxNode(root.right);
		}
		return root;
	}

	private class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}

		public Node(int _val,Node _left,Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}
}
