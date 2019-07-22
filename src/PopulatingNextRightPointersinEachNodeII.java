public class PopulatingNextRightPointersinEachNodeII {
	public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		Node newLevelStart = null;//node to start traverse
		boolean newLevel = true;//whether need to find a new start
		Node cur = root;
		Node tmp = null;
		while (cur != null) {
			//System.out.println(cur.val);
			if (newLevel) {
				if (cur.left != null) {
					newLevelStart = cur.left;
					newLevel = false;
				} else if (cur.right != null) {
					newLevelStart = cur.right;
					newLevel = false;
				}
			}
			if (cur.left != null) {
				if (cur.right != null) {
					cur.left.next = cur.right;
				} else {
					tmp = cur.next;
					while (tmp != null) {
						if (tmp.left != null) {
							cur.left.next = tmp.left;
							break;
						} else if (tmp.right != null) {
							cur.left.next = tmp.right;
							break;
						}
						tmp = tmp.next;
					}
				}
			}

			if (cur.right != null) {
				if (cur.next == null) {
					cur.right.next = null;
				} else {
					tmp = cur.next;
					while (tmp != null) {
						if (tmp.left != null) {
							cur.right.next = tmp.left;
							break;
						} else if (tmp.right != null) {
							cur.right.next = tmp.right;
							break;
						}
						tmp = tmp.next;
					}

				}
			}

			if (cur.next == null) {
				newLevel = true;
				cur = newLevelStart;
				newLevelStart = null;
			} else {
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

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}
