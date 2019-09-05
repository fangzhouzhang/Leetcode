import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		stack.push(nums2[nums2.length - 1]);
		map.put(nums2[nums2.length - 1], -1);
		for (int i = nums2.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && nums2[i] > stack.peek()) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				map.put(nums2[i], -1);

			} else {
				map.put(nums2[i], stack.peek());
			}
			stack.push(nums2[i]);
		}
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}
		return res;
	}
}
