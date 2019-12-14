public class _168ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n <= 0) return null;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int digit = (n - 1) % 26;
			sb.append((char)('A' + digit));
			n = (n - 1) / 26;
		}
		return new String(sb.reverse());
	}
}
