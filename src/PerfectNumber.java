public class PerfectNumber {
	/**
	 * time: o(sqrt(n)) space: o(1)
	 * @param num
	 * @return
	 */
	public boolean checkPerfectNumber(int num) {
		if (num == 1) {
			return false;
		}
		int sum = 1;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i + num / i;
			}
		}
		return sum == num;
	}
}
