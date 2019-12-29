import java.util.HashMap;
import java.util.Map;

public class _460LFUCache {
	private class LFUCache {
		private Map<Integer, MyList> fre;
		private Map<Integer, Node> map;
		private int capacity;
		private int min;
		public LFUCache(int capacity) {
			fre = new HashMap<>();
			map = new HashMap<>();
			this.capacity = capacity;
			min = -1;
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				int val = node.val;
				//delete node in pre list and update min, then add to cur fre list
				MyList preList = fre.get(node.fre);
				preList.removeNode(node);
				if (node.fre == min && preList.length == 0) min++;
				MyList curList = fre.getOrDefault(node.fre + 1, new MyList());
				curList.addNode(node);
				node.fre += 1;
				fre.put(node.fre, curList);
				return val;
			} else return -1;
		}

		public void put(int key, int value) {
			if (capacity == 0) return;
			if (map.containsKey(key)) {
				map.get(key).val = value;
				get(key);
			} else {
				if (capacity == map.size()) {
					MyList preList = fre.get(min);
					Node del = preList.popTail();
					map.remove(del.key);
				}
				min = 1;
				MyList curList = fre.getOrDefault(1, new MyList());
				Node node = new Node(key, value);
				curList.addNode(node);
				fre.put(1, curList);
				map.put(key, node);
			}
		}

		private class Node {
			int key;
			int val;
			int fre;
			Node pre;
			Node next;
			public Node(int key, int val) {
				this.key = key;
				this.val = val;
				fre = 1;
				pre = null;
				next = null;
			}
		}

		private class MyList{
			Node head;
			Node tail;
			int length;
			public MyList() {
				head = new Node(0, 0);
				tail = new Node(0, 0);

				head.next = tail;
				tail.pre = head;

				length = 0;
			}

			private void addNode(Node node) {
				node.pre = head;
				node.next = head.next;

				head.next = node;
				node.next.pre = node;

				length++;
			}

			private void removeNode(Node node) {
				Node nPre = node.pre;
				Node nNext = node.next;

				nPre.next = nNext;
				nNext.pre = nPre;

				node.pre = null;
				node.next = null;

				length--;
			}

			private void addToHead(Node node) {
				removeNode(node);
				addNode(node);
			}

			private Node popTail() {
				Node del = tail.pre;
				removeNode(del);
				return del;
			}
		}
	}
}
