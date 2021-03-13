public class _510InorderSuccessorinBSTII {
	public Node inorderSuccessor(Node node) {
		if (node == null) return null;

		if (node.right == null) {
			Node cur = node;
			while (cur.parent != null && cur.parent.right == cur) {
				cur = cur.parent;
			}
			return cur.parent;
		} else {
			node = node.right;
			while (node.left != null) node = node.left;
			return node;
		}
	}

	private class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	};
}
