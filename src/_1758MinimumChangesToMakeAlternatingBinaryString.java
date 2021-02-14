public class _1758MinimumChangesToMakeAlternatingBinaryString {
	public int minOperations(String s) {
		if (s == null || s.length() == 0) return 0;
		int left = 0, right = 0, n = s.length();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				if (s.charAt(i) == '1') left++;
			}
			if (i % 2 == 1) {
				if (s.charAt(i) == '0') left++;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (i % 2 == 0) {
				if (s.charAt(i) == '0') right++;
			}
			if (i % 2 == 1) {
				if (s.charAt(i) == '1') right++;
			}
		}
		return Math.min(left, right);
	}
}
