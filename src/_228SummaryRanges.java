import java.util.ArrayList;
import java.util.List;

public class _228SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null) return res;
		int n = nums.length;
		if (n == 0) return res;
		if (n == 1) {
			res.add("" + nums[0]);
			return res;
		}
		int i = 0, j = 1;
		while (j < n) {
			if (nums[j - 1] + 1 == nums[j]) j++;
			else {
				if (nums[j - 1] - nums[i] >= 1) {
					res.add(nums[i] + "->" + nums[j - 1]);
				} else res.add("" + nums[i]);
				i = j;
				j++;
			}
		}
		if (nums[j - 1] - nums[i] >= 1) {
			res.add(nums[i] + "->" + nums[j - 1]);
		} else res.add("" + nums[i]);
		return res;
	}
}
