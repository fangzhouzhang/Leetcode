import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
	/**
	 * @param head: The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public Node copyRandomList(Node head) {
		if (head == null) return null;
		Node cur = head;
		Map<Node, Node> map = new HashMap<>();
		while (cur != null) {
			Node tmp = new Node(cur.val);
			map.put(cur, tmp);
			cur = cur.next;
		}

		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(head);
	}

	private class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {}

		public Node(int _val,Node _next,Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
		public Node(int _val) {
			val = _val;
		}
	};
}
