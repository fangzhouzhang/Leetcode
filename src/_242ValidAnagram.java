public class _242ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null) return false;
		if (s.length() != t.length()) return false;
		int[] map = new int[256];
		for (char c : s.toCharArray()) map[c]++;
		for (char c : t.toCharArray()) {
			map[c]--;
			if (map[c] < 0) return false;
		}
		return true;
	}

	public boolean isAnagramII(String s, String t) {
		if (s == null && t == null) return true;
		if (s == null || t == null) return false;
		if (s.length() != t.length()) return false;
		int[] map = new int[26];
		int num = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int idx = s.charAt(i) - 'a';
			map[idx]++;
			if (map[idx] == 1) num++;
		}
		for (int i = 0; i < n; i++) {
			int idx = t.charAt(i) - 'a';
			map[idx]--;
			if (map[idx] == 0) num--;
		}
		return num == 0;
	}
}
