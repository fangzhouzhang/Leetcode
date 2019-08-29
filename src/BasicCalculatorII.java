public class BasicCalculatorII {
	public int calculate(String s1) {
		String s = s1.replaceAll(" ", "");
		int res = 0;
		int prevNum = 0;
		int curNum = 0;
		char op = '#';
		int idx = 0;
		while (idx < s.length()) {
			while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
				curNum = curNum * 10 + s.charAt(idx) - '0';
				idx++;
			}
			if (op == '+') {
				res += curNum;
				prevNum = curNum;
				curNum = 0;
			} else if (op =='-') {
				res -= curNum;
				prevNum = -curNum;
				curNum = 0;
			} else if (op == '*') {
				res = (res - prevNum) + (prevNum * curNum);
				prevNum = prevNum * curNum;
				curNum = 0;
			} else if (op == '/') {
				res = (res - prevNum) + (prevNum / curNum);
				prevNum = prevNum / curNum;
				curNum = 0;
			} else if (op == '#')  {
				//op == '#'
				res += curNum;
				prevNum = curNum;
				curNum = 0;
			}
			if (idx < s.length()) {
				op = s.charAt(idx);
				idx++;
			}
		}
		return res;
	}
}
