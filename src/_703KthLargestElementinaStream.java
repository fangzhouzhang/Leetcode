import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _703KthLargestElementinaStream {
	class KthLargest {
		private int size = 0;
		private Deque<Integer> dq = new LinkedList<>();
		public KthLargest(int k, int[] nums) {
			size = k;
			Arrays.sort(nums);
			if (nums.length <= 0) return;
			for (int i = nums.length - 1; i >= nums.length - k && i >= 0; i--) dq.addLast(nums[i]);
		}

		public int add(int val) {
			if (dq.size() >= size && dq.getLast() >= val) return dq.getLast();
			Stack<Integer> stack = new Stack<>();
			while (dq.size() > 0 && dq.getLast() < val) {
				stack.push(dq.pollLast());
			}
			dq.addLast(val);
			while (dq.size() < size && !stack.isEmpty()) dq.addLast(stack.pop());
			return dq.getLast();
		}
	}
}
