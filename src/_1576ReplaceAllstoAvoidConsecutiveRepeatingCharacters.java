public class _1576ReplaceAllstoAvoidConsecutiveRepeatingCharacters {
	public String modifyString(String s) {
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		int idx = 0;
		while (idx < n) {
			char cur = s.charAt(idx);
			if (cur == '?') {
				cur = 'a';
				if (idx - 1 >= 0) {
					char prev = sb.charAt(idx - 1);
					cur = (char)('a' + (prev - 'a' + 1) % 26);
				}
				if (idx + 1 < n) {
					char post = s.charAt(idx + 1);
					if (cur == post) {
						cur = (char)('a' + (cur - 'a' + 1) % 26);
					}
				}
			}
			sb.append(cur);
			idx++;
		}
		return sb.toString();
	}
}
