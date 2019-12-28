import java.util.Deque;
import java.util.LinkedList;

public class _239SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) return new int[0];
		Deque<Integer> dq = new LinkedList<>();
		int n = nums.length;
		int[] res = new int[n - k + 1];
		for (int i = 0; i < n; i++) {
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
			dq.addLast(i);
			if (i - 0 + 1 >= k) res[i - k + 1] = nums[dq.peekFirst()];
			if (i - dq.peekFirst() + 1 >= k) dq.pollFirst();
		}
		return res;
	}
}

