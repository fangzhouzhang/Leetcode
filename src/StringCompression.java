public class StringCompression {
	public int compress(char[] chars) {
		if (chars.length == 0) {
			return 0;
		}
		int slow = 0, fast = 0, cur = 0;
		while (slow < chars.length) {
			while (fast < chars.length && chars[slow] == chars[fast]) {
				fast++;
			}
			chars[cur++] = chars[slow];
			if (fast - slow == 1) {
				slow = fast;
				continue;
			}
			int num = fast - slow;
			char[] a = (num + "").toCharArray();
			for (char c : a) {
				chars[cur++] = c;
			}
			slow = fast;
		}
		return cur;
	}
}
