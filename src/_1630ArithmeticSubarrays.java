import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1630ArithmeticSubarrays {
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		if (nums == null || nums.length == 0) return new ArrayList<Boolean>();
		int n = l.length;
		List<Boolean> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			res.add(isAp(nums, l, r, i));
		}
		return res;
	}

	private boolean isAp(int[] nums, int[] l, int[] r, int i) {
		int len = r[i] - l[i] + 1;
		int[] copy = new int[len];
		for (int j = 0; j < len; j++) {
			copy[j] = nums[l[i] + j];
		}
		Arrays.sort(copy);
		if (len < 3) return true;
		int d = copy[1] - copy[0];
		for (int j = 2; j < len; j++) {
			if (copy[j] - copy[j - 1] != d) return false;
		}
		return true;
	}
}
