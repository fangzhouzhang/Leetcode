public class _374GuessNumberHigherorLower {
	public int guessNumber(int n) {
		int start = 1;
		int end = n;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (guess(mid) == -1) {
				end = mid - 1;
			} else if (guess(mid) == 1) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	private int guess(int num) {
		return 0;
	}
}
