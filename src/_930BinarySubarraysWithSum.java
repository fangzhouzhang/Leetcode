import java.util.HashMap;
import java.util.Map;

public class _930BinarySubarraysWithSum {
	public int numSubarraysWithSum(int[] A, int S) {
		if (A == null || A.length == 0) return 0;
		int n = A.length;
		int sum = 0;
		int[] prefix = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sum += A[i];
			prefix[i + 1] = sum;
		}
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < n; i++) {
			if (map.containsKey(prefix[i + 1] - S)) {
				res += map.get(prefix[i + 1] - S);
			}
			map.put(prefix[i + 1], map.getOrDefault(prefix[i + 1], 0) + 1);

		}
		return res;
	}
}
