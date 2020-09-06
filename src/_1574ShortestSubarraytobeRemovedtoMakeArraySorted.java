public class _1574ShortestSubarraytobeRemovedtoMakeArraySorted {
	public int findLengthOfShortestSubarray(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		int left = 0, n = arr.length;
		while (left + 1 < n && arr[left] <= arr[left + 1]) {
			left++;
		}
		if (left == n - 1) return 0;
		int right = n - 1;
		while (right - 1 >= 0 && arr[right - 1] <= arr[right]) {
			right--;
		}
		int i = 0, j = right, res = Math.min(n - 1 - left, right);
		while (i <= left && j < n) {
			if (arr[i] <= arr[j]) {
				res = Math.min(res, j - 1 - i);
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
}
