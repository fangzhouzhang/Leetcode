public class _387FirstUniqueCharacterinaString {
	/**
	 * time: o(n) space: o(26)
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) return -1;
		int[] map = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map[c - 'a'] == 1) return i;
		}
		return -1;
	}
}
