public class VerifyinganAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
		int[] map = new int[26];
		for (int i = 0; i < order.length(); i++) map[order.charAt(i) - 'a'] = i;

		for (int i = 1; i < words.length; i++) {
			if (!compare(words[i - 1], words[i], map)) return false;
		}
		return true;
	}

	private boolean compare(String a, String b, int[] map) {
		int len = Math.min(a.length(), b.length());
		for (int i = 0; i < len; i++) {
			int cmp = map[a.charAt(i) - 'a'] - map[b.charAt(i) - 'a'];
			if (cmp < 0) {
				return true;
			}
			if (cmp > 0) {
				return false;
			}
			if (cmp == 0 && a.length() > b.length()) {
				return false;
			}
		}
		return true;
	}
}
