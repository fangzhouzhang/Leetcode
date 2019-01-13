public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return num1 == null ? num2 : num1;
		}
		if (num1.length() < num2.length()) {
			return multiply(num2, num1);
		}
		if (isZero(num1) || isZero(num2)) {
			return "0";
		}
		//num1.length > num2.length
		// System.out.println("num1 " + num1);
		// System.out.println("num2 " + num2);
		int[] mul = new int[num1.length() + num2.length()];
		int carry = 0;
		for (int i = num2.length() - 1, k = mul.length - 1; i >= 0 && k >= 0; i--, k--) {
			int l = k;
			carry = 0;
			for (int j = num1.length() - 1; j >= 0 && l >= 0; j--, l--) {
				int sum = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carry;
				// System.out.println("sum " + sum);
				mul[l] += sum % 10;
				// System.out.println("mul " + mul[l]);
				carry = sum / 10;
				// System.out.println("carry1 " + carry);
				carry += mul[l] / 10;
				// System.out.println("carry2 " + carry);
				mul[l] = mul[l] % 10;
				// System.out.println("final mul is  " + mul[l]);
				if (j == 0 && carry > 0) {
					mul[l - 1] += carry;
				}
			}
			// System.out.println();
		}
		String res = "";
		for (int i = 0; i < mul.length; i++) {
			if (i == 0 && mul[i] == 0) {
				continue;
			}
			res = res + mul[i];
		}
		// if (carry > 0) {
		//     res = carry + res;
		// }
		return res;
	}
	private boolean isZero(String num) {
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) - '0' != 0) {
				return false;
			}
		}
		return true;
	}
}
