public class _1013PartitionArrayIntoThreePartsWithEqualSum {
	public boolean canThreePartsEqualSum(int[] arr) {
		int sum = 0;
		for (int x : arr) sum += x;
		if (sum % 3 != 0) return false;
		int cur = 0, cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cur += arr[i];
			if (cur == sum / 3) {
				cnt++;
				cur = 0;
			}
		}
		return cnt >= 3;
	}
}
