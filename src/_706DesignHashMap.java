class _706DesignHashMap {
	private class MyHashMap {
		private Node[] buckets;
		/** Initialize your data structure here. */
		public MyHashMap() {
			buckets = new Node[1000001];
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			if (buckets[key] == null) buckets[key] = new Node(key, value);
			else buckets[key].val = value;
		}

		/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
		public int get(int key) {
			if (buckets[key] != null) return buckets[key].val;
			else return -1;
		}

		/** Removes the mapping of the specified value key if this map contains a mapping for the key */
		public void remove(int key) {
			if (buckets[key] != null) buckets[key] = null;
		}

		private class Node{
			int key;
			int val;
			public Node(int key, int val) {
				this.key = key;
				this.val = val;
			}
		}
	}
}

