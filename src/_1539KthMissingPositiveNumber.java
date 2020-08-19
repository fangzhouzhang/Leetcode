import java.util.HashSet;
import java.util.Set;

public class _1539KthMissingPositiveNumber {
	public int findKthPositive(int[] arr, int k) {
		if (arr == null || arr.length == 0) return 0;
		Set<Integer> set = new HashSet<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) set.add(arr[i]);
		int start = 1, end = arr[n - 1] + k;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int len = getLastPos(mid, arr);
			if (mid - len < k) start = mid + 1;
			else if (mid - len > k) end = mid - 1;
			else {
				if (!set.contains(mid)) return mid;
				else end = mid - 1;
			}
		}
		return -1;
	}

	private int getLastPos(int target, int[] a) {
		int start = 0, end = a.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == target) return mid + 1;
			else if (a[mid] < target) start = mid + 1;
			else end = mid - 1;
		}
		return end + 1;
	}
}
