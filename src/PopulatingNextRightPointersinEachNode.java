public class PopulatingNextRightPointersinEachNode {
	public Node connect(Node root) {
		if (root == null || root.left == null) {
			return root;
		}
		Node cur = root;
		Node newLevelStart = null;
		boolean newLevel = true;
		while (cur != null && cur.left != null) {
			if (newLevel) {
				newLevelStart = cur.left;
			}
			if (cur.left != null) {
				cur.left.next = cur.right;
			}
			if (cur.next == null) {
				cur.right.next = null;
			} else {
				cur.right.next = cur.next.left;
			}
			if (cur.next == null) {
				cur = newLevelStart;
				newLevel = true;
			} else {
				newLevel = false;
				cur = cur.next;
			}
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
