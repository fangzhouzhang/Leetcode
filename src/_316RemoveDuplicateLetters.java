public class _316RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0) return s;
		StringBuilder sb = new StringBuilder();
		int[] map = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map[c - 'a'] = i;
		}
		boolean[] exist = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (exist[c - 'a']) continue;
			while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && map[sb.charAt(sb.length() - 1) - 'a'] > i) {
				char cur = sb.charAt(sb.length() - 1);
				sb.setLength(sb.length() - 1);
				exist[cur - 'a'] = false;
			}
			sb.append(c);
			exist[c - 'a'] = true;
		}
		return new String(sb);
	}
}
