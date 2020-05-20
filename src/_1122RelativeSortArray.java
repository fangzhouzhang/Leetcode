import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _1122RelativeSortArray {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[arr1.length];
		for (int n : arr1) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int idx = 0;
		for (int n : arr2) {
			for (int i = 0; i < map.get(n); i++) {
				res[idx++] = n;
			}
			map.remove(n);
		}
		TreeSet<Integer> set = new TreeSet<>();
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			set.add(e.getKey());
		}
		for (int k : set) {

			for (int i = 0; i < map.get(k); i++) {
				res[idx++] = k;
			}

		}
		return res;
	}
}
