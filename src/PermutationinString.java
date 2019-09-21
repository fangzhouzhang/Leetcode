public class PermutationinString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) return false;
		if (s1.equals(s2)) return true;
		int[] m1 = new int[26];
		int[] m2 = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			m1[s1.charAt(i) - 'a']++;
			m2[s2.charAt(i) - 'a']++;
		}
		if (match(m1, m2)) {
			return true;
		}
		int n = s1.length();
		for (int i = s1.length(); i < s2.length(); i++) {
			m2[s2.charAt(i) - 'a']++;
			m2[s2.charAt(i - n) - 'a']--;
			if (match(m1, m2)) return true;
		}
		return false;
	}

	private boolean match(int[] m1, int[] m2) {
		for (int i = 0; i < 26; i++) {
			if (m1[i] != m2[i]) return false;
		}
		return true;
	}
}
