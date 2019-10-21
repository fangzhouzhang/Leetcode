public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int[] map = new int[256];
		for (char c : t.toCharArray()) map[c]++;
		int cnt = 0, left = 0, minLeft = -1, minLen = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (--map[s.charAt(i)] >= 0) cnt++;
			while (cnt == t.length()) {
				if (minLen > i - left + 1) {
					minLen = i - left + 1;
					minLeft = left;
				}
				if (++map[s.charAt(left)] > 0) cnt--;
				left++;
			}
		}
		return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
	}
}
