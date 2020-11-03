public class _43MultiplyStrings {
	public String multiply(String num1, String num2) {
		int n = num1.length(), m = num2.length();
		int[] a = new int[n], b = new int[m];
		int[] c = new int[n + m];
		for (int i = n - 1, idx = 0; i >= 0; i--, idx++) {
			a[idx] = num1.charAt(i) - '0';
		}
		for (int i = m - 1, idx = 0; i >= 0; i--, idx++) {
			b[idx] = num2.charAt(i) - '0';
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				c[i + j] += a[i] * b[j];
			}
		}
		for (int i = 0, t = 0; i < n + m; i++) {
			t += c[i];
			c[i] = t % 10;
			t /= 10;
		}
		int k = n + m - 1;
		while (k >= 0 && c[k] == 0) k--;
		StringBuilder sb = new StringBuilder();
		while (k >= 0) sb.append((char)(c[k--] + '0'));
		return sb.length() == 0 ? "0" : new String(sb);
	}
}
