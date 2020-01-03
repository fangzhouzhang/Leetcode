import java.util.Arrays;
import java.util.Comparator;

public class _1048LongestStringChain {
	public int longestStrChain(String[] words) {
		if (words == null || words.length == 0) return 0;
		Arrays.sort(words, new MyComparator());
		Integer[] dp = new Integer[words.length];
		for (int i = 0; i < words.length; i++) dfs(words, i, dp);
		int res = 1;
		for (int n : dp) res = Math.max(res, n);
		return res;
	}

	private int dfs(String[] words, int idx, Integer[] dp) {
		// if (idx == words.length) return 0;
		if (dp[idx] != null) return dp[idx];
		int max = 1;
		for (int i = idx + 1; i < words.length; i++) {
			if (isPredecessor(words[idx].toCharArray(), words[i].toCharArray())) {
				max = Math.max(max, dfs(words, i, dp) + 1);
			}
		}
		dp[idx] = max;
		return max;
	}

	private boolean isPredecessor(char[] a, char[] b) {
		if (a.length + 1 != b.length) return false;
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				i++;
				j++;
			} else j++;
		}
		return i == a.length;
	}

	private class MyComparator implements Comparator<String> {
		public int compare(String a, String b) {
			return a.length() - b.length();
		}
	}
}
