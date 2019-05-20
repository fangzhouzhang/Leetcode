import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (desiredTotal <= maxChoosableInteger) {
			return true;
		}
		if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
			return false;
		}
		// Map<String, Boolean> cache = new HashMap<>();
		Map<Integer, Boolean> cache = new HashMap<>();
		boolean[] used = new boolean[maxChoosableInteger + 1];
		return dfs(used, desiredTotal, 0, cache);
	}
	// private boolean dfs(boolean[] used, int desiredTotal, int curSum, Map<String, Boolean> cache) {
	private boolean dfs(boolean[] used, int desiredTotal, int curSum, Map<Integer, Boolean> cache) {
		if (curSum >= desiredTotal) {
			return false;
		}
		// String key = Arrays.toString(used);
		Integer key = format(used);
		Boolean res = cache.get(key);
		if (res != null) {
			return res;
		}
		for (int i = 1; i < used.length; i++) {
			if (!used[i]) {
				used[i] = true;
				boolean val = dfs(used, desiredTotal, curSum + i, cache);
				used[i] = false;
				if (!val) {
					cache.put(key, true);
					return true;
				}
			}
		}
		cache.put(key, false);
		return false;
	}
	private int format(boolean[] used){
		int num = 0;
		for(boolean b: used){
			num <<= 1;
			if(b) num |= 1;
		}
		return num;
	}
}
