public class _159LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s.length() == 0) return 0;
		int[] map = new int[128];
		int cnt = 0, max = -1;
		int slow = 0, fast = 0;
		while (fast < s.length()) {
			char c = s.charAt(fast);
			map[c]++;
			if (map[c] == 1) cnt++;
			while (cnt > 2) {
				char tmp = s.charAt(slow);
				map[tmp]--;
				if (map[tmp] == 0) cnt--;
				slow++;
			}
			max = Math.max(max, fast - slow + 1);
			fast++;
		}
		return max;
	}
}
