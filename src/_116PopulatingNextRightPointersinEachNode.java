public class _116PopulatingNextRightPointersinEachNode {
	public Node connect(Node root) {
		if (root == null) return null;
		Node cur = root;
		Node child = null;
		Node childHead = null;
		while (cur != null) {
			while (cur != null) {
				if (cur.left != null) {
					if (childHead != null) {
						child.next = cur.left;
					} else {
						childHead = cur.left;
					}
					child = cur.left;
				}

				if (cur.right != null) {
					if (childHead != null) {
						child.next = cur.right;
					} else {
						childHead = cur.right;
					}
					child = cur.right;
				}

				cur = cur.next;
			}
			cur = childHead;
			childHead = null;
			child = null;
		}
		return root;
	}
	private class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val,Node _left,Node _right,Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}
