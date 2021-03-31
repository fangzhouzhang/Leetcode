public class _738MonotoneIncreasingDigits {
	public int monotoneIncreasingDigits(int N) {
		char[] num = (N + "").toCharArray();
		int idx = 0, n = num.length;
		while (idx + 1 < n && num[idx + 1] >= num[idx]) idx++;
		if (idx == n - 1) return N;
		while (idx - 1 >= 0 && num[idx - 1] == num[idx]) idx--;
		num[idx] = (char)(num[idx] - 1);
		for (int i = idx + 1; i < n; i++) num[i] = '9';
		return Integer.parseInt(new String(num));
	}
}
