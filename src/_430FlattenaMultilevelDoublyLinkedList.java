import java.util.Stack;

public class _430FlattenaMultilevelDoublyLinkedList {
	public Node flatten(Node head) {
		if (head == null) return null;
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		while (cur != null) {
			if (cur.child != null) {
				stack.push(cur.next);
				cur.next = cur.child;
				cur.child.prev = cur;
				cur.child = null;
			} else if (cur.next == null && !stack.isEmpty()) {
				Node next = stack.pop();
				if (next != null) next.prev = cur;
				cur.next = next;
			}
			cur = cur.next;
		}
		return head;
	}

	private class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {}

		public Node(int _val,Node _prev,Node _next,Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	};
}
