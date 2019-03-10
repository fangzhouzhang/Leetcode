import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {
	private Node head;
	private Node tail;
	private Map<Integer, Node> cache;
	private int size;
	public LRUCache(int capacity) {
		cache = new HashMap<>();
		size = capacity;

		head = new Node(-1, -1);
		head.pre = null;

		tail = new Node(-1, -1);
		tail.next = null;

		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null) {
			return -1; // throw new exception
		} else {
			moveToHead(node);
			return node.val;
		}
	}

	public void put(int key, int value) {
		Node n = cache.get(key);
		if (n == null) {
			Node node = new Node(key, value);
			if (cache.size() < size) {
				addNode(node);
				cache.put(key, node);
			} else {
				Node del = popTail();
				cache.remove(del.key);
				addNode(node);
				cache.put(key, node);
			}
		} else {
			n.val = value;
			cache.put(key, n);
			moveToHead(n);
		}
	}
	private class Node {
		private int key;
		private int val;
		private Node pre;
		private Node next;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			pre = null;
			next = null;
		}
	}
	/**
	 * Always add the new node right after head;
	 */
	private void addNode(Node node) {
		node.pre = head;
		node.next = head.next;

		head.next.pre = node;
		head.next = node;

	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(Node node){
		Node np = node.pre;
		Node nn = node.next;

		np.next = nn;
		nn.pre = np;

		// node.pre = null;
		// node.next = null;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(Node node){
		removeNode(node);
		addNode(node);
	}

	// pop the current tail.
	private Node popTail(){
		Node del = tail.pre;
		removeNode(del);
		return del;
	}

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


