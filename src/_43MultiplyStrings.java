public class _43MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) return "";
		int n = num1.length(), m = num2.length();
		int[] res = new int[m + n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int curPos = i + j + 1;
				int prePos = i + j;
				int sum = product + res[curPos];
				res[curPos] =  sum % 10;
				res[prePos] += sum / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean allZero = true;
		for (int i = 0; i < res.length; i++) {
			if (res[i] == 0 && allZero) continue;
			else {
				allZero = false;
				sb.append(res[i]);
			}
		}
		return sb.length() == 0 ? "0" : new String(sb);
	}
}
