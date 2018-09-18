import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	private Map<Integer, Node> map;
	private int capacity;
	private Node head;
	private Node tail;
	private List<Node> list;
	/*
	 * @param capacity: An integer
	 */public LRUCache(int capacity) {
		// do intialization if necessary
		this.capacity = capacity;
		map = new HashMap<>();
		head = null;
		tail = null;
		list = new LinkedList<>();
	}

	/*
	 * @param key: An integer
	 * @return: An integer
	 */
	public int get(int key) {
		// write your code here
		if (!map.containsKey(key)) {
			return -1;
		} else {
			Node node = map.get(key);
			//adjust position to tail
			if (node == tail) {
				//do nothing
			} else if (node == head) {//
				Node temp = head.next;
				head.next = null;
				head = temp;
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = tail.next;
			} else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = tail.next;
			}
			return node.val;
		}
	}

	/*
	 * @param key: An integer
	 * @param value: An integer
	 * @return: nothing
	 */
	public void set(int key, int value) {
		// write your code here
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.val = value;
			//adjust position to tail
			if (node == tail) {
				//do nothing
			} else if (node == head) {//
				Node temp = head.next;
				head.next = null;
				head = temp;
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = tail.next;
			} else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = tail.next;
			}
		} else {
			Node node = new Node(key, value);
			if (list.size() == 0) {
				head = node;
				tail = node;
			}
			else if (list.size() < capacity) {
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = tail.next;
			} else {//delete oldest node
				map.remove(head.key);
				list.remove(head);
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = tail.next;
				Node temp = head.next;
				head.next = null;
				head = temp;
			}
			list.add(node);
			map.put(key, node);
		}
	}
	class Node {
		int key;
		int val;
		Node prev;
		Node next;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			prev = null;
			next = null;
		}
	}
}


