import java.util.ArrayDeque;
import java.util.Deque;

public class _1696JumpGameVI {
	public int maxResult(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int[] dp = new int[n];
		Deque<Integer> dq = new ArrayDeque<>();
		dp[0] = nums[0];
		dq.add(0);
		for (int i = 1; i < n; i++) {
			while (!dq.isEmpty() && i - dq.peekFirst() > k) dq.pollFirst();
			dp[i] = dq.isEmpty() ? nums[i] : dp[dq.peekFirst()] + nums[i];
			while (!dq.isEmpty() && dp[i] >= dp[dq.peekLast()]) dq.pollLast();
			dq.addLast(i);
		}
		return dp[n - 1];
	}
}
