import java.util.ArrayList;
import java.util.List;

public class _705DesignHashSet {
	class MyHashSet {

		private int N = 19997;

		private List[] arr = new List[N];

		/** Initialize your data structure here. */
		public MyHashSet() {
			for (int i = 0; i < N; i++) arr[i] = new ArrayList<Integer>();
		}

		private int find(List<Integer> chain, int key) {
			for (int i = 0; i < chain.size(); i++) {
				if (chain.get(i) == key) return i;
			}
			return -1;
		}

		public void add(int key) {
			int pos = find(arr[key % N], key);
			if (pos == -1) {
				arr[key % N].add(key);
			}
		}

		public void remove(int key) {
			int pos = find(arr[key % N], key);
			if (pos != -1) {
				arr[key % N].remove(pos);
			}
		}

		/** Returns true if this set contains the specified element */
		public boolean contains(int key) {
			int pos = find(arr[key % N], key);
			if (pos != -1) {
				return true;
			}
			return false;
		}
	}

}
