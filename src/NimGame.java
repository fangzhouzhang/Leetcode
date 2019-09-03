import java.util.HashMap;
import java.util.Map;

public class NimGame {
	public boolean canWinNim(int n) {
		Map<Integer, Boolean> map = new HashMap<>();
		return dfs(n, n, map);
	}

	private boolean dfs(int n, int rem, Map<Integer, Boolean> map) {
		if (rem >= 1 && rem <= 3) {
			return true;
		}

		Boolean ret = map.get(rem);
		if (ret != null) {
			return ret;
		}

		for (int i = 1; i <= 3; i++) {
			if (!dfs(n, rem - i, map)) {
				map.put(rem, true);
				return true;
			}
		}
		map.put(rem, false);
		return false;
	}

	public boolean canWinNim1(int n) {
		return !(n % 4 == 0);
	}
}
