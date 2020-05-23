public class _159LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) return 0;
		int slow = 0, fast = 0;
		int res = 1;
		int[] map = new int[256];
		int unique = 0;
		while (fast < s.length()) {
			map[s.charAt(fast)]++;
			if (map[s.charAt(fast)] == 1) unique++;
			while (slow < fast && unique > 2) {
				map[s.charAt(slow)]--;
				if (map[s.charAt(slow)] == 0) unique--;
				slow++;
			}
			res = Math.max(res, fast - slow + 1);
			fast++;
		}
		return res;
	}
}
