import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	private Map<Integer, Integer> vals;
	private Map<Integer, Integer> cnts;
	private Map<Integer, LinkedHashSet<Integer>> lists;
	private int size;
	private int min;

	public LFUCache(int capacity) {
		size = capacity;
		vals = new HashMap<>();
		cnts = new HashMap<>();
		lists = new HashMap<>();
		lists.put(1, new LinkedHashSet<Integer>());
		min = -1;
	}

	public int get(int key) {
		if (!vals.containsKey(key)) {
			return -1;
		}
		//vals contains key
		//update freq
		int count = cnts.get(key);
		lists.get(count).remove(key);
		if (count == min && lists.get(min).size() == 0) {
			min++;
		}
		if (!lists.containsKey(count + 1)) {
			lists.put(count + 1, new LinkedHashSet<>());
		}
		lists.get(count + 1).add(key);
		cnts.put(key, count + 1);
		return vals.get(key);
	}

	public void put(int key, int value) {
		if (size <= 0) {
			return;
		}
		if (vals.containsKey(key)) {
			vals.put(key, value);
			get(key);
			return;
		}
		//not contains
		if (vals.size() >= size) {
			int evict = lists.get(min).iterator().next();
			vals.remove(evict);
			cnts.remove(evict);
			lists.get(min).remove(evict);
		}
		vals.put(key, value);
		cnts.put(key, 1);
		min = 1;
		lists.get(1).add(key);
	}
}
