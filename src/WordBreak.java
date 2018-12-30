import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length()];
		Set<String> set = new HashSet<>(wordDict);

		for (int end = 0; end < s.length(); end++) {
			if (set.contains(s.substring(0, end + 1))) {
				dp[end] = true;
				continue;
			}

			for (int start = 1; start < s.length(); start++) {
				if (dp[start - 1] == true &&
						set.contains(s.substring(start, end + 1))) {
					dp[end] = true;
					break;
				}
			}
		}

		return dp[s.length() - 1];
	}
}
