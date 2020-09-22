import java.util.HashSet;
import java.util.Set;

public class _1593SplitaStringIntotheMaxNumberofUniqueSubstrings {
	int res = 0;
	private Set<String> set = new HashSet<>();
	public int maxUniqueSplit(String s) {
		dfs(s, 0);
		return res;
	}

	private void dfs(String s, int idx) {
		if (idx == s.length()) {
			res = Math.max(res, set.size());
			return;
		}
		for (int i = idx; i < s.length(); i++) {
			// if (idx == 0 && i == s.length() - 1) continue;
			String cur = s.substring(idx, i + 1);
			if (set.contains(cur)) continue;
			set.add(cur);
			dfs(s, i + 1);
			set.remove(cur);
		}
	}
}
