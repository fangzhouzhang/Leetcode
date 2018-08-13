import java.util.HashMap;
import java.util.Map;

public class GetCountArray {
	/**
	 * @param nums: a list of integers
	 * @return: return a list of integers
	 * time: o(nlogn) space:o(n)
	 */
	public int[] countArray(int[] nums) {
		// Write your solution here
		int[] res = new int[nums.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, 0);
		}
		if (nums == null || nums.length == 0) {
			return res;
		}
		int[] temp = new int[nums.length];
		sort(nums.clone(), temp, map, 0, nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			//System.out.println(num + "..." + map.get(num));
			res[i] = map.get(nums[i]);
		}
		return res;
	}
	public void sort(int[] nums, int[] temp, Map<Integer, Integer> map, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		sort(nums, temp, map, start, mid);
		sort(nums, temp, map, mid + 1, end);
		merge(nums, temp, map, start, end);
	}
	public void merge(int[] nums, int[] temp, Map<Integer, Integer> map, int start, int end) {
		int i = start;
		int mid = start + (end - start) / 2;
		int j = mid + 1;
		int k = start;
		while (i <= mid && j <= end) {
			if (nums[i] >= nums[j]) {
				temp[k++] = nums[j++];
			} else {
				map.put(nums[i], map.get(nums[i]) + j - mid - 1);
				//System.out.println("---" + nums[i] + "..." + map.get(nums[i]) + "---");
				temp[k++] = nums[i++];
			}
		}
		while (i <= mid && k <= end) {
			map.put(nums[i], map.get(nums[i]) + j - mid - 1);
			//System.out.println("===" + nums[i] + "..." + map.get(nums[i]) + "===");
			temp[k++] = nums[i++];
		}
		while (j <= end && k <= end) {
			temp[k++] = nums[j++];
		}
		for (int p = start; p <= end; p++) {
			nums[p] = temp[p];
		}
	}
}
