public class _1550ThreeConsecutiveOdds {
	public boolean threeConsecutiveOdds(int[] arr) {
		if (arr == null || arr.length == 0) return false;
		int idx = 0, n = arr.length;
		while (idx + 2 < n) {
			if (arr[idx] % 2 == 1 && arr[idx + 1] % 2 == 1 && arr[idx + 2] % 2 == 1) return true;
			idx++;
		}
		return false;
	}
}
