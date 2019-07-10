import java.util.HashMap;
import java.util.Map;

public class CoinChange2 {
	public int change(int amount, int[] coins) {
		Map<String, Integer> cache = new HashMap<>();
		return dfs(cache, amount, coins, 0);
	}
	private int dfs(Map<String, Integer> map, int amount, int[] coins, int idx) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0 || idx == coins.length) {
			return 0;
		}
		if (map.get(amount + "." + idx) != null) {
			return map.get(amount + "." + idx);
		}
		int count = 0;
		for (int i = 0; amount - coins[idx] * i >= 0; i++) {
			count += dfs(map, amount - coins[idx] * i, coins, idx + 1);
		}
		map.put(amount + "." + idx, count);
		return count;

	}
}
