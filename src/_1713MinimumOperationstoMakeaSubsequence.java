import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1713MinimumOperationstoMakeaSubsequence {
	public int minOperations(int[] target, int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < target.length; i++) {
			map.put(target[i], i);
		}
		List<Integer> dp = new ArrayList<>();
		for (int x : arr) {
			if (!map.containsKey(x)) continue;
			int n = dp.size(), num = map.get(x);
			if (n == 0 || dp.get(n - 1) < num) dp.add(num);
			else {
				int l = 0, r = n - 1;
				while (l < r) {
					int mid = l + r >> 1;
					if (dp.get(mid) >= num) r = mid;
					else l = mid + 1;
				}
				dp.set(l, num);
			}
		}
		return target.length - dp.size();
	}
}
