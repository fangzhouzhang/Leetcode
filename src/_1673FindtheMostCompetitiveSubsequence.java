import java.util.Stack;

public class _1673FindtheMostCompetitiveSubsequence {
	public int[] mostCompetitive(int[] nums, int k) {
		if (nums == null || nums.length == 0) return new int[0];
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.size() + n - i - 1 >= k && stack.peek() > nums[i]) {
				stack.pop();
			}
			if (stack.size() < k) stack.push(nums[i]);
		}
		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i--) res[i] = stack.pop();
		return res;
	}
}
