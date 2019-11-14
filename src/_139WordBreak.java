import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0) return true;
		Set<String> set = new HashSet<>(wordDict);
		Boolean[] dp = new Boolean[s.length()];
		return dfs(s, s.length() - 1, set, dp);
	}

	private boolean dfs(String s, int idx, Set<String> set, Boolean[] dp) {
		if (idx < 0) return true;
		if (dp[idx] != null) return dp[idx];
		for (int i = 0; i <= idx; i++) {
			String cut = s.substring(i, idx + 1);
			if (!set.contains(cut)) continue;
			if (dfs(s, i - 1, set, dp)) {
				dp[idx] = true;
				return true;
			}
		}
		dp[idx] = false;
		return false;
	}
}
