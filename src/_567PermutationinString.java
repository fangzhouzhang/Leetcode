public class _567PermutationinString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s2 == null) return false;
		int n = s1.length(), m = s2.length();
		if (n > m) return false;
		int[] m1 = new int[26];
		int[] m2 = new int[26];
		for (int i = 0; i < n; i++) {
			m1[s1.charAt(i) - 'a']++;
			m2[s2.charAt(i) - 'a']++;
		}
		if (isMatch(m1, m2)) return true;
		for (int i = n; i < m; i++) {
			m2[s2.charAt(i) - 'a']++;
			m2[s2.charAt(i - n) - 'a']--;
			if (isMatch(m1, m2)) return true;
		}
		return false;
	}

	private boolean isMatch(int[] a, int[] b) {
		for (int i = 0; i < 26; i++) {
			if (a[i] != b[i]) return false;
		}
		return true;
	}
}
