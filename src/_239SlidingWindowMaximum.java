import java.util.ArrayDeque;
import java.util.Deque;

public class _239SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) return new int[0];
		int n = nums.length;
		Deque<Integer> dq = new ArrayDeque<>();
		int[] res = new int[n - k + 1];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (!dq.isEmpty() && dq.getFirst() < i - k + 1) dq.removeFirst();
			while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.removeLast();
			dq.addLast(i);
			if (i >= k - 1) res[idx++] = nums[dq.getFirst()];
		}
		return res;
	}
}

