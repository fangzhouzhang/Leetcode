import java.util.Stack;

public class _768MaxChunksToMakeSortedII {
	public int maxChunksToSorted(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		while (idx < arr.length) {
			if (stack.isEmpty() || stack.peek() <= arr[idx]) stack.push(arr[idx]);
			else {
				int max = -1;
				while (!stack.isEmpty() && stack.peek() > arr[idx]) {
					max = Math.max(max, stack.pop());
				}
				stack.push(max);
			}
			idx++;
		}
		return stack.size();
	}
}
