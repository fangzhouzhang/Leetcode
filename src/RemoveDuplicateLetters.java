public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		boolean[] used = new boolean[26];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (used[c - 'a']) {
				count[c - 'a']--;
				continue;
			}
			while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[c - 'a'] > 0) {
				char prev = sb.charAt(sb.length() - 1);
				if (count[prev - 'a'] > 0) {
					sb.setLength(sb.length() - 1);
					used[prev - 'a'] = false;
				} else {
					break;
				}
			}
			sb.append(c);
			count[c - 'a']--;
			used[c - 'a'] = true;

		}
		return new String(sb);
	}
}
