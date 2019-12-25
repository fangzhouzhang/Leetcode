import java.util.ArrayList;
import java.util.List;

public class _248StrobogrammaticNumberIII {
	private char[][] digits = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
	public int strobogrammaticInRange(String low, String high) {
		if (low == null || high == null || low.length() > high.length()) return 0;
		int lowLen = low.length();
		int highLen = high.length();
		if (lowLen == highLen) return search(low, high);
		int count = 0;
		count += searchLow(low);
		count += searchHigh(high);
		if (lowLen + 1 == highLen) return count;
		int[] dp = new int[highLen];
		dp[1] = 3;
		dp[2] = 5;
		for (int i = 3; i < highLen; i++) dp[i] = dp[i - 2] * 5;
		for (int i = lowLen + 1; i < highLen; i++) count += dp[i] * 4 / 5;
		return count;
	}

	private int search(String low, String high) {
		List<String> res = getStrobNums(low.length());
		int count = 0;
		for (String n : res) {
			if (low.compareTo(n) <= 0 && n.compareTo(high) <= 0) count++;
		}
		return count;
	}

	private int searchLow(String low) {
		List<String> res = getStrobNums(low.length());
		int count = 0;
		for (String n : res) {
			if (low.compareTo(n) <= 0) count++;
		}
		return count;
	}

	private int searchHigh(String high) {
		List<String> res = getStrobNums(high.length());
		int count = 0;
		for (String n : res) {
			if (n.compareTo(high) <= 0) count++;
		}
		return count;
	}

	private List<String> getStrobNums(int n) {
		char[] chs = new char[n];
		List<String> res = new ArrayList<>();
		dfs(res, chs, 0, n - 1);
		return res;
	}

	private void dfs(List<String> res, char[] chs, int start, int end) {
		if (start > end) {
			if (chs.length == 1 || chs[0] != '0') res.add(new String(chs));
			return;
		}
		for (char[] m : digits) {
			if (start == end && m[0] != m[1]) continue;
			chs[start] = m[0];
			chs[end] = m[1];
			dfs(res, chs, start + 1, end - 1);
		}
	}
}
