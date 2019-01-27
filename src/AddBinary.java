public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return a == null ? b : a;
		}
		if (a.length() > b.length()) {
			return addBinary(b, a);
		}
		int aIdx = a.length() - 1;
		int bIdx = b.length() - 1;
		int carry = 0;
		String res = "";
		while (aIdx >= 0 && bIdx >= 0) {
			int sum = a.charAt(aIdx) - '0' + b.charAt(bIdx) - '0' + carry;
			int digit = (sum) % 2;
			carry = (sum) / 2;
			res = digit + res;
			aIdx--;
			bIdx--;
		}
		while (bIdx >= 0) {
			int sum = b.charAt(bIdx) - '0' + carry;
			int digit = (sum) % 2;
			carry = (sum) / 2;
			res = digit + res;
			bIdx--;
		}
		if (carry > 0) {
			res = 1 + res;
		}
		return res;
	}
}