import java.util.HashMap;
import java.util.Map;

public class _1711CountGoodMeals {
	int M = 1000000007;
	public int countPairs(int[] deliciousness) {
		long[] p = new long[22];
		p[0] = 1;
		long cur = 1;
		for (int i = 1; i <= 21; i++) {
			cur *= 2;
			p[i] = cur;
		}
		Map<Integer, Integer> map = new HashMap<>();
		long res = 0;
		for (int x : deliciousness) {
			for (long pp : p) {
				if (map.containsKey((int)pp - x)) {
					res = (res + map.get((int)pp - x)) % M;
				}
			}
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		return (int)res;
	}
}
