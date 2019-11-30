import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496NextGreaterElementI {
	//https://www.youtube.com/watch?v=uFso48YRRao
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		try {
			if (nums1 == null || nums2 == null) throw new Exception();
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		if (nums1.length == 0 || nums2.length == 0) return new int[0];
		Stack<Integer> stack = new Stack<>();
		//find index in nums1
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) map.put(nums1[i], i);
		int[] res = new int[nums1.length];
		Arrays.fill(res, -1);
		int idx = 0;
		while (idx < nums2.length) {
			if (stack.isEmpty() || nums2[stack.peek()] >= nums2[idx]) stack.push(idx++);
			else {
				int pop = stack.pop();
				if (map.containsKey(nums2[pop])) res[map.get(nums2[pop])] = nums2[idx];
			}
		}
		return res;
	}
}
