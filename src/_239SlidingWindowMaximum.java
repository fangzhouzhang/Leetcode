import java.util.ArrayDeque;
import java.util.Deque;

public class _239SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) return new int[0];
		Deque<Integer> dq = new ArrayDeque<>();
		int n = nums.length;
		int[] res = new int[n - k + 1];
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) dq.pollLast();
			dq.addLast(i);
		}
		res[0] = nums[dq.getFirst()];
		int idx = 1;
		for (int i = k; i < n; i++) {
			if (i - k >= dq.getFirst()) dq.pollFirst();
			while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) dq.pollLast();
			dq.addLast(i);
			res[idx++] = nums[dq.getFirst()];
		}
		return res;
	}
}

