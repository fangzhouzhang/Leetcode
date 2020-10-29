import java.util.Stack;

public class _321CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		if (nums1 == null || nums2 == null) return null;
		if (k == 0) return new int[0];
		int n = nums1.length, m = nums2.length;
		int[] res = new int[k];
		for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
			int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
			if (greater(candidate, 0, res, 0)) res = candidate;
		}
		return res;
	}

	private boolean greater(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			i++;
			j++;
		}
		return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}


	private int[] maxArray(int[] nums, int k) {
		int n = nums.length, idx = 0;
		int[] res = new int[k];
		Stack<Integer> stack = new Stack<>();
		while (idx < n) {
			while (!stack.isEmpty() && stack.size() + n - idx - 1 >= k && stack.peek() < nums[idx]) {
				stack.pop();
			}
			if (stack.size() < k) {
				stack.push(nums[idx]);
			}
			idx++;
		}
		for (int i = k - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}

	private int[] merge(int[] a, int[] b, int k) {
		int[] res = new int[k];
		int i = 0, j = 0, idx = 0;
		while (i < a.length && j < b.length) {
			if (greater(a, i, b, j)) {
				res[idx++] = a[i++];
			} else {
				res[idx++] = b[j++];
			}
		}
		while (i < a.length) {
			res[idx++] = a[i++];
		}
		while (j < b.length) {
			res[idx++] = b[j++];
		}
		return res;
	}
}
