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

	public int compressII(char[] chars) {
		if (chars == null || chars.length == 0) {
			return 0;
		}

		String res = "";
		int i = 0, j = 0, number = 0;
		while (j < chars.length) {
			if (chars[i] == chars[j]) {
				j++;
				number++;
			} else {
				res += chars[i];
				res += number == 1 ? "" : number;
				number = 0;
				i = j;
			}
		}
		if (number != 0) {
			res += chars[i];
			res += number == 1 ? "" : number;
		}
		for (int k = 0; k < res.length(); k++) {
			chars[k] = res.charAt(k);
		}
		return res.length();
	}
}
