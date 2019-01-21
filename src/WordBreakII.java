import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			res.add("");
			return res;
		}
		Set<String> set = new HashSet<>(wordDict);
		dfs(s, set, res, 0, "", new boolean[s.length()]);
		return res;
	}
	private void dfs(String s,
					 Set<String> set,
					 List<String> res,
					 int level,
					 String temp,
					 boolean[] fail) {
		if (level == s.length()) {
			res.add(new String(temp));
			return;
		}
		int curSize = res.size();
		for (int i = 1; level + i <= s.length(); i++) {
			if (isValid(s, level, level + i, set) && fail[level] == false) {
				if (level == 0) {
					dfs(s, set, res, level + i, temp + s.substring(level, level + i), fail);
				} else {
					dfs(s, set, res, level + i, temp + " " + s.substring(level, level + i), fail);

				}
			}
		}
		if (curSize == res.size()) {
			fail[level] = true;
		}
	}
	private boolean isValid(String s, int start, int end, Set<String> set) {
		String check = s.substring(start, end);
		if (set.contains(check)) {
			return true;
		}
		return false;
	}
}
