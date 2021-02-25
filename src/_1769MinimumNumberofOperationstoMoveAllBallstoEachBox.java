public class _1769MinimumNumberofOperationstoMoveAllBallstoEachBox {
	public int[] minOperations(String boxes) {
		if (boxes == null || boxes.length() == 0) return new int[0];
		int n = boxes.length();
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			for (int left = 0; left < i; left++) {
				if (boxes.charAt(left) == '1') {
					res[i] += i - left;
				}
			}
			for (int right = i + 1; right < n; right++) {
				if (boxes.charAt(right) == '1') {
					res[i] += right - i;
				}
			}
		}
		return res;
	}
}
