public class ConvertaNumbertoHexadecimal {
	/**
	 * @param num: an integer
	 * @return: convert the integer to hexadecimal
	 * time : o(n) space : o(n)
	 */
	public String toHex(int num) {
		// Write your code here
		if (num == 0) {
			return "0";
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int temp = (num >> (i * 4)) & 15;
			if (temp < 10) {
				char c = (char)(temp + '0');
				res.append(c);
			} else {
				char c = (char)(temp + 'a' - 10);
				res.append(c);
			}
		}
		StringBuilder sb = res.reverse();
		int idx = 0;
		for (int i = 0; i < 8; i++) {
			if (sb.charAt(i) != '0') {
				idx = i;
				break;
			}
		}
		return sb.substring(idx).toString();
	}
}
