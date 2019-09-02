public class IntegertoEnglishWords {
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] THOUSANDS = {"Billion", "Million", "Thousand", ""};
	private final int[] radix = {1000000000, 1000000, 1000, 1};
	public String numberToWords(int num) {
		if (num == 0) return "Zero";
		int i = 0;
		String res = "";
		for (i = 0; i < radix.length; i++) {
			if (num / radix[i] == 0) {
				continue;
			}
			res = res + " " + trans(num / radix[i]) + THOUSANDS[i];
			num %= radix[i];
		}
		return res.trim();
	}

	private String trans(int num) {
		if (num == 0) {
			return "";
		}
		else if (num < 20) {
			return LESS_THAN_20[num % 20] + " ";
		}
		else if (num < 100) {
			return TENS[num / 10] + " " + trans(num % 10);
		}
		else {
			return LESS_THAN_20[num / 100] + " Hundred " + trans(num % 100);
		}
	}
}
