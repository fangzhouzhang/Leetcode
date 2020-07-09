public class _273IntegertoEnglishWords {
	//http://rainykat.blogspot.com/2017/01/leetcodef-273-integer-to-english-words.html
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	public String numberToWords(int num) {
		if (num == 0) return "Zero";
		int idx = 0;
		String res = "";
		while (num > 0) {
			int digit = num % 1000;
			if (num % 1000 > 0) res = getString(digit)  + THOUSANDS[idx] +  " " + res;
			num /= 1000;
			idx++;
		}
		return res.trim();
	}

	/**
	 * return a string with spaces inside
	 * @param num
	 * @return
	 */
	private String getString(int num) {
		if (num == 0) return "";
		if (0 < num && num < 20) {
			return LESS_THAN_20[num] + " ";
		} else if (20 <= num && num < 100) {
			return TENS[num / 10] + " " + getString(num % 10);
		} else  {
			return LESS_THAN_20[num / 100] + " Hundred " + getString(num % 100);
		}
	}
}
