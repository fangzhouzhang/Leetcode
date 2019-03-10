class MyHashMap {
	private Node[] buckets;
	/** Initialize your data structure here. */
	public MyHashMap() {
		buckets = new Node[1000001];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		Node n = buckets[key];
		if (n == null) {
			buckets[key] = new Node(key, value);
			// System.out.println("key is " + buckets[key].key + " val is " + buckets[key].val);
		} else {
			buckets[key].val = value;
		}
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		Node n = buckets[key];
		if (n == null) {
			return -1;
		} else {
			// System.out.println("key is " + buckets[key].key + " val is " + buckets[key].val);
			// System.out.println("n key is " + n.key + " n val is " + n.val);
			return n.val;

		}
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		Node n = buckets[key];
		if (n != null) {
			buckets[key] = null;
		}
	}
	private class Node{
		private int key;
		private int val;
		// private Node next;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			// this.next = null;
		}
	}
}

