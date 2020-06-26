import java.util.ArrayList;
import java.util.List;

public class _260SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) return new int[0];
		int val = nums[0];
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			val ^= nums[i];
		}

		val = val & (-val);
		int count = 0;
		while (val != 0) {
			val >>= 1;
			count++;
		}
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for (int n : nums) {
			if (((n >> (count - 1)) & 1) == 1) a.add(n);
			else b.add(n);
		}
		int n1 = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			n1 ^= a.get(i);
		}
		int n2 = b.get(0);
		for (int i = 1; i < b.size(); i++) {
			n2 ^= b.get(i);
		}
		int[] res = new int[2];
		res[0] = n1;
		res[1] = n2;
		return res;
	}
}
