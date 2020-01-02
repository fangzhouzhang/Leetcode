import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _981TimeBasedKeyValueStore {
	private class TimeMap {
		private Map<String, TreeMap<Integer, String>> map;
		/** Initialize your data structure here. */
		public TimeMap() {
			map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			if (!map.containsKey(key)) map.put(key, new TreeMap<>());
			map.get(key).put(timestamp, value);
		}

		public String get(String key, int timestamp) {
			if (!map.containsKey(key) || map.get(key).floorEntry(timestamp) == null) return "";
			return map.get(key).floorEntry(timestamp).getValue();
		}
	}
}
