public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if (num.length() <= k) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		int len = num.length() - k;
		for (int i = 0; i < num.length(); i++) {
			while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > num.charAt(i)) {
				sb.deleteCharAt(sb.length() - 1);
				k--;
			}
			sb.append(num.charAt(i));
		}

		if (sb.length() > len) {
			sb = sb.delete(len, sb.length());
		}
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return sb.length() == 0 ? "0" : new String(sb);
	}
}
