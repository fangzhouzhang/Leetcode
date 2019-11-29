import java.util.ArrayList;
import java.util.List;

public class _315CountofSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Item[] items = new Item[nums.length];
		Item[] sorted = new Item[nums.length];
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) items[i] = new Item(nums[i], i);
		mergeSort(items, 0, nums.length - 1, ans, sorted);
		for (int n : ans) res.add(n);
		return res;
	}

	private void mergeSort(Item[] items, int start, int end, int[] ans, Item[] sorted) {
		if (start >= end) return;
		int mid = start + (end - start) / 2;
		mergeSort(items, start, mid, ans, sorted);
		mergeSort(items, mid + 1, end, ans, sorted);
		merge(items, start, mid, end, ans, sorted);
	}

	private void merge(Item[] items, int start, int mid, int end, int[] ans, Item[] sorted) {
		int loPtr = start, hiPtr = mid + 1, rightCnt = 0, idx = start;
		while (loPtr <= mid && hiPtr <= end) {
			if (items[loPtr].val > items[hiPtr].val) {
				rightCnt++;
				sorted[idx++] = items[hiPtr++];
			} else {
				ans[items[loPtr].idx] += rightCnt;
				sorted[idx++] = items[loPtr++];
			}
		}

		while (loPtr <= mid) {
			ans[items[loPtr].idx] += rightCnt;
			sorted[idx++] = items[loPtr++];
		}

		while (hiPtr <= end) {
			sorted[idx++] = items[hiPtr++];
		}

		for (int i = start; i <= end; i++) items[i] = sorted[i];
	}

	private class Item {
		int val;
		int idx;
		public Item(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}
}
