public class CountandSay {
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		//n >= 2
		StringBuilder prev = new StringBuilder("1");
		StringBuilder cur = new StringBuilder();;
		for (int i = 2; i <= n; i++) {
			int idx = 1;
			int cnt = 1;
			char prevChar = prev.charAt(0);
			while (idx < prev.length()) {
				if (prev.charAt(idx) == prevChar) {
					cnt++;
					idx++;
				} else {
					cur.append(cnt);
					cur.append(prevChar);
					prevChar = prev.charAt(idx);
					cnt = 1;
					idx++;
				}
			}
			cur.append(cnt);
			cur.append(prevChar);
			StringBuilder tmp = new StringBuilder();
			prev = cur;
			cur = tmp;
		}
		return new String(prev);
	}
}
