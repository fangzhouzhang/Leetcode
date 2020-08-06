public class _1535FindtheWinnerofanArrayGame {
	public int getWinner(int[] arr, int k) {
		if (arr == null || arr.length == 0) return 0;
		int curMax = arr[0];
		int times = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > curMax) {
				curMax = arr[i];
				times = 1;
			} else {
				times++;
			}
			if (times >= k) return curMax;
		}
		return curMax;
	}
}
