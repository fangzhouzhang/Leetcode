public class InsertintoaCyclicSortedList {
	public Node insert(Node head, int insertVal) {
		if (head == null) {
			Node node = new Node(insertVal);
			node.next = node;
			return node;
		}
		Node cur = head;
		while (cur != null && cur.next != null && cur.next != head && cur.val <= cur.next.val) {cur = cur.next;}

		Node min = cur.next;
		Node max = cur;
		if ((min != null && insertVal <= min.val) || (max != null && insertVal >= max.val)) {
			Node node = new Node(insertVal, min);
			max.next = node;
		} else {
			cur = min;
			while (cur != null && cur.next != null && cur.next.val < insertVal) {cur = cur.next;}
			Node node = new Node(insertVal, cur.next);
			cur.next = node;
		}
		return head;
	}
	private class Node {
		public int val;
		public Node next;

		public Node() {}

		public Node(int _val,Node _next) {
			val = _val;
			next = _next;
		}
		public Node(int _val) {
			val = _val;
			next = null;
		}
	};
}
