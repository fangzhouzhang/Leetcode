import java.util.HashMap;
import java.util.Map;

public class _1497CheckIfArrayPairsAreDivisiblebyk {
	public boolean canArrange(int[] arr, int k) {
		if (arr == null || arr.length == 0) return false;
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : arr) {
			map.put(((n % k + k) % k), map.getOrDefault(((n % k + k) % k), 0) + 1);
		}
		if (map.get(0) != null && map.get(0) % 2 == 1) return false;
		for (int i = 1; i <= k / 2; i++) {
			if (map.get(i) != null && map.get(k - i) != null) {
				if ((int)map.get(i) != (int)map.get(k - i)) return false;
			} else if (map.get(i) != null || map.get(k - i) != null) {
				return false;
			}
		}
		return true;
	}
}
