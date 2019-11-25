public class _67AddBinary {
	public String addBinary(String a, String b) {
		if (a == null && b == null) return null;
		if (a == null || b == null) return a == null ? b : a;
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		int carry = 0;
		while (i >= 0 && j >= 0) {
			int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
			int digit = sum % 2;
			carry = sum / 2;
			sb.append(digit);
			i--;
			j--;
		}

		while (i >= 0) {
			int sum = a.charAt(i) - '0' + carry;
			int digit = sum % 2;
			carry = sum / 2;
			sb.append(digit);
			i--;
		}

		while (j >= 0) {
			int sum = b.charAt(j) - '0' + carry;
			int digit = sum % 2;
			carry = sum / 2;
			sb.append(digit);
			j--;
		}

		if (carry > 0) sb.append(carry);
		return new String(sb.reverse());
	}
}
