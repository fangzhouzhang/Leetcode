import java.util.PriorityQueue;

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

	public int findKthLargest1(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		quickPartition(nums, 0, nums.length - 1, k);
		return nums[nums.length - k];
	}

	private void quickPartition(int[] nums, int start, int end, int k) {
		if (start == end) return;
		int pivotIdx = start;
		int pivot = nums[start];
		start += 1;
		while (start <= end) {
			while (start <= end && nums[start] < pivot) start++;
			while (start <= end && nums[end] > pivot) end--;
			if (start <= end) {
				swap(nums, start++, end--);
			}
		}
		swap(nums, pivotIdx, end);

		if (end == nums.length - k) return ;
		else if (end < nums.length - k)  quickPartition(nums, end + 1, nums.length - 1, k);
		else  quickPartition(nums, 0, end - 1, k);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
