public class ReversePairs {
	public int reversePairs(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		return merge(nums, 0, nums.length - 1, new int[nums.length]);
	}

	private int merge(int[] nums, int start, int end, int[] tmp) {
		if (start >= end) return 0;
		int mid = start + (end - start) / 2;
		int ret = 0;
		ret += merge(nums, start, mid, tmp);
		ret += merge(nums, mid + 1, end, tmp);
		return ret + mergeSort(nums, start, mid, end, tmp);
	}

	private int mergeSort(int[] nums, int start, int mid, int end, int[] tmp) {
		int p = start, q = mid + 1;
		int count = 0;
		while (p <= mid && q <= end) {
			if ((long)nums[p] > 2 * (long)nums[q]) {
				count += mid - p + 1;
				q++;
			} else {
				p++;
			}
		}

		p = start; q = mid + 1;
		int idx = start;
		while (p <= mid && q <= end) {
			if (nums[p] < nums[q]) {
				tmp[idx++] = nums[p++];
			} else {
				tmp[idx++] = nums[q++];
			}
		}

		while (p <= mid) {
			tmp[idx++] = nums[p++];
		}

		while (q <= end) {
			tmp[idx++] = nums[q++];
		}

		for (int i = start; i <= end; i++) {
			nums[i] = tmp[i];
		}

		return count;
	}
}
