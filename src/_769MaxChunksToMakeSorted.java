import java.util.Stack;

public class _769MaxChunksToMakeSorted {
	public int maxChunksToSorted(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		while (idx < arr.length) {
			if (stack.isEmpty() || stack.peek() <= arr[idx]) stack.push(arr[idx++]);
			else {
				int curMax = Integer.MIN_VALUE;
				while (!stack.isEmpty() && stack.peek() > arr[idx]) {
					curMax = Math.max(curMax, stack.pop());
				}
				stack.push(curMax);
				idx++;
			}
		}
		return stack.size();
	}
}
