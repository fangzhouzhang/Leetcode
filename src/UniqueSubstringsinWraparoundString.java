public class UniqueSubstringsinWraparoundString {
	public int findSubstringInWraproundString(String p) {
		if (p.length() == 0) {
			return 0;
		}
		int[] map = new int[26];
		int len = 0;
		for (int i = 0; i < p.length(); i++) {
			if (i > 0 && (p.charAt(i) == p.charAt(i - 1) + 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
				len++;
			} else {
				len = 1;
			}
			int idx = (int)(p.charAt(i) - 'a');
			map[idx] = Math.max(map[idx], len);
		}
		int res = 0;
		for (int n : map) {
			res += n;
		}
		return res;
	}
}
