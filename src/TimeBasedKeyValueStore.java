import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
	Map<String, TreeMap<Integer, String>> map;
	/** Initialize your data structure here. */
	public TimeBasedKeyValueStore() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key)) map.put(key, new TreeMap<>());
		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key)) return "";
		Integer t = map.get(key).floorKey(timestamp);
		return t == null ? "" : map.get(key).get(t);
	}
}
