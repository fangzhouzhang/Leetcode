import java.util.ArrayList;
import java.util.List;

public class _248StrobogrammaticNumberIII {
	private char[][] digits = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
	private char[] single = {'0', '1', '8'};
	public int strobogrammaticInRange(String low, String high) {
		int lowBits = low.length(), highBits = high.length(), count = 0;
		if (highBits - lowBits < 0) return 0;
		else if (highBits - lowBits >= 1) {
			count += generateNumbers(low, true);
			count += generateNumbers(high, false);
		} else {
			return findNumber(low, high);
		}
		int[] dp = new int[highBits];
		dp[0] = 0;
		if (highBits >= 2) dp[1] = 3;
		if (highBits >= 3) dp[2] = 5;
		for (int i = 3; i < highBits; i++) dp[i] = 5 * dp[i - 2];
		for (int i = lowBits + 1; i < highBits; i++) count += dp[i] * 4 / 5;
		return count;
	}

	private int findNumber(String small, String big) {
		char[] chs = new char[small.length()];
		List<String> nums = new ArrayList<>();
		int count = 0;
		int low = 0, high = small.length() - 1;
		dfs(nums, chs, low, high);
		for (String n : nums) {
			if (small.compareTo(n) <= 0 && n.compareTo(big) <= 0) count++;
		}
		return count;
	}

	private int generateNumbers(String num, boolean isLow) {
		char[] chs = new char[num.length()];
		List<String> nums = new ArrayList<>();
		int count = 0;
		int low = 0, high = num.length() - 1;
		dfs(nums, chs, low, high);
		if (isLow) {
			for (String n : nums) {
				if (num.compareTo(n) <= 0) count++;
			}
		} else {
			for (String n : nums) {
				if (n.compareTo(num) <= 0) count++;
			}
		}
		return count;
	}

	private void dfs(List<String> nums, char[] chs, int low, int high) {
		if (low > high) {
			nums.add(new String(chs));
			return;
		}
		if (low == high) {
			for (char c : single) {
				chs[low] = c;
				nums.add(new String(chs));
			}
			return;
		}

		for (char[] pair : digits) {
			if (low == 0 && pair[0] == '0') continue;
			chs[low] = pair[0];
			chs[high] = pair[1];
			dfs(nums, chs, low + 1, high - 1);
		}
	}
}
