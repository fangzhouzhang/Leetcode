public class _1446ConsecutiveCharacters {
	public int maxPower(String s) {
		if (s == null || s.length() == 0) return 0;
		int chars = 0, slow = 0, fast = 0;
		int[] map = new int[26];
		int res = 0;
		while (fast < s.length()) {
			int idx = s.charAt(fast) - 'a';
			map[idx]++;
			if (map[idx] == 1) chars++;
			while (chars > 1) {
				int j = s.charAt(slow) - 'a';
				map[j]--;
				if (map[j] == 0) chars--;
				slow++;
			}
			res = Math.max(res, fast - slow + 1);
			fast++;
		}
		return res;
	}
}
