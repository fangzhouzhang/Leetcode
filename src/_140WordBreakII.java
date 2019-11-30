import java.util.*;

public class _140WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) return res;
		Set<String> set = new HashSet<>(wordDict);
		Map<Integer, Boolean> dp = new HashMap<>();
		dfs(s, 0, set, dp, res, "");
		return res;
	}

	private void dfs(String s, int idx, Set<String> set, Map<Integer, Boolean> dp, List<String> res, String tmp) {
		if (idx == s.length()) {
			res.add(new String(tmp));
			return;
		}
		if (dp.get(idx) != null && !dp.get(idx)) return;
		int preLen = res.size();
		for (int i = idx; i < s.length(); i++) {
			String cut = s.substring(idx, i + 1);
			if (set.contains(cut)) {
				if (tmp.length() == 0) dfs(s, i + 1, set, dp, res, cut);
				else dfs(s, i + 1, set, dp, res, tmp + " " + cut);
			}
		}
		if (preLen == res.size()) dp.put(idx, false);
		else dp.put(idx, true);
	}
}
