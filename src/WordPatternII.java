import java.util.HashMap;
import java.util.Map;

public class WordPatternII {
	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern.length() == 0 && str.length() == 0) {
			return true;
		}
		return dfs(pattern, 0, str, 0, new HashMap<Character, String>(), new HashMap<String, Character>());
	}
	private boolean dfs(String p, int idxp, String s, int idxs, Map<Character, String> map, Map<String, Character> map2) {
		if (idxp == p.length() && idxs == s.length()) {
			return true;
		}
		if (idxp == p.length() || idxs == s.length()) {
			return false;
		}

		char key = p.charAt(idxp);
		for (int j = idxs; j < s.length(); j++) {
			String val = s.substring(idxs, j + 1);
			boolean c1 = map.containsKey(key);
			boolean c2 = map2.containsKey(val);
			if (c1 && !map.get(key).equals(val) || c2 && map2.get(val) != key) {
				continue;
			}
			map.put(key, val);
			map2.put(val, key);
			boolean ret = dfs(p, idxp + 1, s, j + 1, map, map2);
			if (!c1) {
				map.remove(key);
			}
			if (!c2) {
				map2.remove(val);
			}
			if (ret) {
				return true;
			}
		}

		return false;
	}
}
