import java.util.Arrays;
import java.util.Stack;

public class _503NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {
		if (nums == null || nums.length == 0) return new int[0];
		int[] res = new int[nums.length];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		int n = nums.length;
		while (idx < 2 * n) {
			if (stack.isEmpty() || nums[stack.peek() % n] >= nums[idx % n]) stack.push(idx++);
			else {
				res[stack.pop() % n] = nums[idx % n];
			}
		}
		return res;
	}
}
