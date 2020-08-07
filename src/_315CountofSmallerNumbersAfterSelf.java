import java.util.ArrayList;
import java.util.List;

public class _315CountofSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Pair[] pairs = new Pair[nums.length];
		for (int i = 0; i < nums.length; i++) {
			Pair p = new Pair(nums[i], i);
			pairs[i] = p;
		}
		int[] tmp = new int[nums.length];
		mergeSort(pairs, tmp, 0, nums.length - 1, new Pair[nums.length]);
		for (int i = 0; i < nums.length; i++) {
			res.add(tmp[i]);
		}
		return res;
	}

	private void mergeSort(Pair[] pairs, int[] res, int start, int end, Pair[] tmp) {
		if (start >= end) return;
		int mid = start + (end - start) / 2;
		mergeSort(pairs, res, start, mid, tmp);
		mergeSort(pairs, res, mid + 1, end, tmp);
		merge(pairs, res, start, mid, end, tmp);
	}

	private void merge(Pair[] pairs, int[] res, int start, int mid, int end, Pair[] tmp) {
		int i = start, j = mid + 1, count = 0, idx = start;
		while (i <= mid && j <= end) {
			if (pairs[i].val > pairs[j].val) {
				count++;
				tmp[idx++] = pairs[j++];
			} else {
				tmp[idx++] = pairs[i];
				res[pairs[i].idx] += count;
				i++;
			}
		}
		while (i <= mid) {
			tmp[idx++] = pairs[i];
			res[pairs[i].idx] += count;
			i++;
		}
		while (j <= end) {
			tmp[idx++] = pairs[j++];
		}
		for (int k = start; k <= end; k++) {
			pairs[k] = tmp[k];
		}
	}

	private class Pair {
		int val;
		int idx;
		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}
}
