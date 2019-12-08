public class _340LongestSubstringwithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0) return 0;
		int[] map = new int[256];
		int max = -1;
		int start = 0, end = 0, count = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			map[c]++;
			if (map[c] == 1) count++;
			while (count > k) {
				char tmp = s.charAt(start);
				map[tmp]--;
				if (map[tmp] == 0) count--;
				start++;
			}
			max = Math.max(max, end - start + 1);
			end++;
		}
		return max;
	}
}
