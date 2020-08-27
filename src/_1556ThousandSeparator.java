public class _1556ThousandSeparator {
	public String thousandSeparator(int n) {
		if (n == 0) return "0";
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (n > 0) {
			int cur = n % 10;
			n /= 10;
			if (count == 3) {
				sb.append('.');
				sb.append(cur);
				count = 0;
			} else {
				sb.append(cur);
			}
			count++;
		}
		return sb.reverse().toString();
	}
}
