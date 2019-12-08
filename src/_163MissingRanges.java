import java.util.ArrayList;
import java.util.List;

public class _163MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		if (nums == null) return res;
		if (nums.length == 0) {
			res.add(getInterval(lower, upper));
			return res;
		}
		if (lower < nums[0]) res.add(getInterval(lower, nums[0] - 1));
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			if ((long)nums[i + 1] > (long)nums[i] + 1) res.add(getInterval(nums[i] + 1, nums[i + 1] - 1));
		}
		if (nums[n - 1] < upper) res.add(getInterval(nums[n - 1] + 1, upper));
		return res;
	}

	private String getInterval(int low, int high) {
		return low == high ? "" + low : low + "->" + high;
	}
}
