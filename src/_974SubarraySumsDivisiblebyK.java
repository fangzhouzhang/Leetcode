import java.util.HashMap;
import java.util.Map;

public class _974SubarraySumsDivisiblebyK {
	public int subarraysDivByK(int[] A, int K) {
		if (A == null || A.length == 0) return 0;
		int n = A.length;
		int[] prefix = new int[n + 1];
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int res = 0;
		for (int i = 0; i < n; i++) {
			sum = (sum + A[i]) % K;
			if (sum < 0) sum += K;
			res += map.getOrDefault(sum, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
}
