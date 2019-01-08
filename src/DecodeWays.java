import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<String, Integer> map = new HashMap<>();
		initMap(map);
		int[] res = new int[1];
		dfs(map, s, 0, res);
		return res[0];
	}
	private void initMap(Map<String, Integer> map ) {
		for (int i = 0; i < 26; i++) {
			map.put((i + 1) + "", 'A' + i);
		}
	}
	private void dfs(Map<String, Integer> map, String s, int level, int[] res) {
		if (level >= s.length()) {
			res[0]++;
			return;
		}

		if (level + 1 <= s.length()) {
			String sub = s.substring(level, level + 1);
			if (map.containsKey(sub)) {
				dfs(map, s, level + 1, res);
			}
		}

		if (level + 2 <= s.length()) {
			String sub = s.substring(level, level + 2);
			if (map.containsKey(sub)) {
				dfs(map, s, level + 2, res);
			}
		}
	}
}
