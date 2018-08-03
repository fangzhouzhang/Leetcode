import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	/*
	 * @param capacity: An integer
	 */
	static int capacity;
	List<CacheNode> list;
	CacheNode head;
	CacheNode tail;
	Map<Integer, CacheNode> map;
	public LRUCache(int capacity) {
		// do intialization if necessary
		this.capacity = capacity;
		list = new LinkedList<>();
		head = null;
		tail = null;
		map = new HashMap<>();
	}

	/*
	 * @param key: An integer
	 * @return: An integer
	 */
	public int get(int key) {
		// write your code here
		if (!map.containsKey(key)) {
			return -1;
		}
		CacheNode CacheNode = map.get(key);
		if (CacheNode == tail) {

		}
		else if (CacheNode == head) {
			head = head.next;
			head.prev = null;
			tail.next = CacheNode;
			CacheNode.prev = tail;
			CacheNode.next = null;
			tail = CacheNode;
		} else  {
			CacheNode.prev.next = CacheNode.next;
			CacheNode.next.prev = CacheNode.prev;
			tail.next = CacheNode;
			CacheNode.prev = tail;
			CacheNode.next = null;
			tail = CacheNode;
		}
		return CacheNode.val;
	}

	/*
	 * @param key: An integer
	 * @param value: An integer
	 * @return: nothing
	 */
	public void set(int key, int value) {
		// write your code here
		CacheNode CacheNode = new CacheNode(key, value);
		if (list.isEmpty()) {
			list.add(CacheNode);
			map.put(key, CacheNode);
			head = CacheNode;
			tail = CacheNode;
			return;
		}
		if (map.containsKey(key)) {
			CacheNode ref = map.get(key);
			ref.val = value;
			if (ref == tail) {

			}
			else if (ref == head) {
				head = head.next;
				head.prev = null;
				tail.next = ref;
				ref.prev = tail;
				ref.next = null;
				tail = ref;
			} else  {
				ref.prev.next = ref.next;
				ref.next.prev = ref.prev;
				tail.next = ref;
				ref.prev = tail;
				ref.next = null;
				tail = ref;
			}
		} else {
			if (list.size() < LRUCache.capacity) {
				list.add(CacheNode);
				tail.next = CacheNode;
				CacheNode.prev = tail;
				CacheNode.next = null;
				tail = CacheNode;
				map.put(key, CacheNode);
			} else {
				tail.next = CacheNode;
				CacheNode.prev = tail;
				CacheNode.next = null;
				tail = CacheNode;
				head = head.next;
				map.remove(head.prev.key);
				list.remove(head.prev);
				list.add(CacheNode);
				map.put(key, CacheNode);
			}
		}
	}
}
class CacheNode {
	int key;
	int val;
	CacheNode prev;
	CacheNode next;
	public CacheNode(int key, int val) {
		this.key = key;
		this.val = val;
		prev = null;
		next = null;
	}
}
