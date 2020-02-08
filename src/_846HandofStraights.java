import java.util.TreeMap;

public class _846HandofStraights {
	public boolean isNStraightHand(int[] hand, int W) {
		if (hand == null || hand.length == 0) return false;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int n : hand) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		while (map.size() > 0) {
			Integer first = map.firstKey();
			if (!isValid(map, first, W)) return false;
		}
		return true;
	}

	private boolean isValid(TreeMap<Integer, Integer> map, int key, int w) {
		for (int i = 0; i < w; i++) {
			if (!map.containsKey(key + i)) return false;
			map.put(key + i, map.get(key + i) - 1);
			if (map.get(key + i) == 0) map.remove(key + i);
		}
		return true;
	}
}
