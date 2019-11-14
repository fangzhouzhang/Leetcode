import java.util.HashMap;
import java.util.Map;

class _146LRUCache {
	Map<Integer, Node> map;
	int capacity;
	Node head;
	Node tail;



	public _146LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
		head = new Node(-1, -1);
		tail = new Node(-1, -1);

		head.next = tail;
		tail.pre = head;
	}

	private void addNode(Node node) {
		node.pre = head;
		node.next = head.next;

		head.next = node;
		node.next.pre = node;
	}

	private void removeNode(Node node) {
		Node nodePre = node.pre;
		Node nodeNext = node.next;

		nodePre.next = nodeNext;
		nodeNext.pre = nodePre;

		node.pre = null;
		node.next = null;


	}

	private Node popTail() {
		Node del = tail.pre;
		removeNode(del);
		return del;
	}

	private void addToHead(Node node) {
		removeNode(node);
		addNode(node);
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		} else {
			addToHead(node);
			return node.val;
		}
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			Node newNode = new Node(key, value);
			if (map.size() >= capacity) {
				Node del = popTail();
				map.remove(del.key);
			}
			map.put(key, newNode);
			addNode(newNode);
		} else {
			node.val = value;
			addToHead(node);
		}
	}

	private class Node {
		int key;
		int val;
		Node pre;
		Node next;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			pre = null;
			next = null;
		}
	}

}

/**
 * Your _146LRUCache object will be instantiated and called as such:
 * _146LRUCache obj = new _146LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


