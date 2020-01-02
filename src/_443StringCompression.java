public class _443StringCompression {
	public int compress(char[] chars) {
		if (chars == null || chars.length == 0) return 0;
		int slow = 0, fast = 0, cur = 0;
		while (fast < chars.length) {
			while (fast < chars.length && chars[slow] == chars[fast]) fast++;
			chars[cur++] = chars[slow];
			int fre = fast - slow;
			if (fre > 1) {
				for (char c : (fre + "").toCharArray()) chars[cur++] = c;
			}
			slow = fast;
		}
		return cur;
	}
}
