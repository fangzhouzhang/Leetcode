public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int[] arr = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j;
				int p2 = i + j + 1;
				int sum = val + arr[p2];
				arr[p1] += sum / 10;
				arr[p2] = sum % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean leadZero = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && leadZero) {
				continue;
			} else {
				leadZero = false;
				sb.append(arr[i]);
			}
		}
		return sb.length() == 0 ? "0" : new String(sb);
	}
}
