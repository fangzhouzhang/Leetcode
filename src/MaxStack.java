import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MaxStack {
	private int idx;
	private TreeMap<Integer, List<Node>> map;
	private Node head;
	private Node tail;
	/** initialize your data structure here. */
	public MaxStack() {
		idx = 0;
		map = new TreeMap<>();

		head = new Node(-1);
		head.pre = null;

		tail = new Node(-1);
		tail.next = null;

		head.next = tail;
		tail.pre = head;
	}

	public void push(int x) {
		Node node = new Node(x);
		addNode(node);
		if (map.containsKey(x)) {
			List<Node> nodes = map.get(x);
			nodes.add(node);
			map.put(x, nodes);
		} else {
			List<Node> nodes = new ArrayList<>();
			nodes.add(node);
			map.put(x, nodes);
		}
	}

	public int pop() {
		Node node = popHead();
		List<Node> nodes = map.get(node.val);
		nodes.remove(nodes.size() - 1);
		if (nodes.size() == 0) {
			map.remove(node.val);
		}
		return node.val;
	}

	public int top() {
		return head.next.val;
	}

	public int peekMax() {
		return map.lastKey();
	}

	public int popMax() {
		int res = map.lastKey();
		List<Node> nodes = map.get(res);
		Node del = nodes.get(nodes.size() - 1);
		removeNode(del);
		nodes.remove(nodes.size() - 1);
		if (nodes.size() == 0) {
			map.remove(res);
		}
		return res;
	}
	private class Node{
		private Node pre;
		private Node next;
		// private int key;
		private int val;
		public Node(int val) {
			// this.key = key;
			this.val = val;
			pre = null;
			next = null;
		}
	}
	private void addNode(Node node) {
		node.pre = head;
		node.next = head.next;

		head.next.pre = node;
		head.next = node;
	}
	private void removeNode(Node node) {
		Node np = node.pre;
		Node nn = node.next;
		np.next = nn;
		nn.pre = np;
	}
	private Node popHead() {
		Node res = head.next;
		removeNode(res);
		return res;
	}
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */