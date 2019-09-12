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

	public String toHex1(int num) {
		String res = "";
		char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		for (int i = 0; i < 8 && num != 0; i++) {
			int t = num & 0xf;
			res = map[t] + res;
			num >>= 4;
		}
		return res.length() == 0? "0" : new String(res);
	}
}
