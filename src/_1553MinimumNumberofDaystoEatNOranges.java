import java.util.HashMap;
import java.util.Map;

public class _1553MinimumNumberofDaystoEatNOranges {
	private Map<Integer, Integer> map = new HashMap<>();
	public int minDays(int n) {
		if (n <= 1) {
			return n;
		}
		if (map.containsKey(n)) return map.get(n);
		int ans = Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1);
		map.put(n, ans);
		return ans;
	}
}
