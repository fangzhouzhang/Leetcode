import java.util.PriorityQueue;

public class KthLargestElementinanArray {
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
}
