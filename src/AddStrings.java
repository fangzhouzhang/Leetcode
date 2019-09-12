public class AddStrings {
	public String addStrings(String num1, String num2) {
		int carry = 0;
		int i1 = num1.length() - 1;
		int i2 = num2.length() - 1;
		String res = "";
		while (i1 >= 0 || i2 >= 0) {
			int v1 = i1 >= 0 ? num1.charAt(i1--) - '0' : 0;
			int v2 = i2 >= 0 ? num2.charAt(i2--) - '0' : 0;
			int sum = v1 + v2 + carry;
			res = (sum % 10) + res;
			carry = sum / 10;
		}
		return carry == 0 ? res : "1" + res;
	}
}
