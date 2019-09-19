public class Base7 {
	public String convertToBase7(int num) {
		if (num == 0) {
			return "0";
		}
		boolean neg = num < 0 ? true : false;
		StringBuilder sb = new StringBuilder();
		num = Math.abs(num);
		while (num != 0) {
			sb.insert(0, (num % 7));
			num /= 7;
		}
		if (neg) {
			sb.insert(0, '-');
		}
		return new String(sb);
	}
}
