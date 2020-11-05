import java.util.PriorityQueue;
import java.util.Random;

public class _215KthLargestElementinanArray {
	/**
	 * there are n elements in nums
	 * time: o(k * logn) space: o(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length);
		for (int num: nums) {
			pq.add(num);
		}
		for (int i = 1; i <= nums.length - k; i++) {
			pq.poll();
		}
		return pq.poll();
	}

	private Random random = new Random();
	public int findKthLargestQuickPartition(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int start = 0, end = n - 1;
		while (start <= end) {
			int idx = quickPartition(nums, start, end, k);
			if (idx == n - k) break;
			else if (idx < n - k) start = idx + 1;
			else end = idx - 1;
		}
		return nums[n - k];
	}

	private int quickPartition(int[] nums, int start, int end, int k) {
		if (start == end) return start;
		int selectIdx = start + random.nextInt(end - start + 1);
		int pivot = nums[selectIdx];
		swap(nums, start, selectIdx);
		int pivotIdx = start;
		start += 1;
		while (start <= end) {
			while (start <= end && nums[start] < pivot) start++;
			while (start <= end && nums[end] > pivot) end--;
			if (start <= end) {
				swap(nums, start++, end--);
			}
		}
		swap(nums, pivotIdx, end);
		return end;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private int n = 0;
	public int findKthLargestQuickPartition1(int[] nums, int k) {
		if (nums == null || nums.length == 0) return -1;
		n = nums.length;
		quickPartition1(nums, 0, n - 1, k);
		return nums[n - k];
	}

	private void quickPartition1(int[] nums, int start, int end, int k) {
		if (start >= end) return;
		int pivot = nums[start];
		int pivotIdx = start;
		while (start <= end) {
			while (start <= end && nums[start] <= pivot) start++;
			while (start <= end && nums[end] >= pivot) end--;
			if (start <= end) {
				int tmp = nums[start];
				nums[start] = nums[end];
				nums[end] = tmp;
			}
		}

		int tmp = nums[end];
		nums[end] = nums[pivotIdx];
		nums[pivotIdx] = tmp;

		if (end == n - k) return;
		else if (end > n - k) {
			quickPartition(nums, 0, end - 1, k);
		} else {
			quickPartition(nums, start, n - 1, k);
		}

	}

	private int quickPartition2(int[] nums, int start, int end, int k) {
		if (start >= end) return nums[start];
		int l = start - 1, r = end + 1, x = nums[start + (end - start) / 2];
		while (l < r) {
			while (nums[++l] > x);
			while (nums[--r] < x);
			if (l < r) {
				int tmp = nums[l];
				nums[l] = nums[r];
				nums[r] = tmp;
			}
		}
		if (k <= r) return quickPartition2(nums, start, r, k);
		else return quickPartition2(nums, r + 1, end, k);
	}
}
