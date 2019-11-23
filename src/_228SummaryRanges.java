import java.util.ArrayList;
import java.util.List;

public class _228SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		int start = 0;
		int end = 1;
		while (start < nums.length) {
			while (end < nums.length && nums[end - 1] + 1  == nums[end]) {
				end++;
			}
			StringBuilder sb = new StringBuilder();
			if (start == end - 1) sb.append(nums[start]);
			else sb.append(nums[start]).append("->").append(nums[end - 1]);
			start = end;
			end++;
			res.add(new String(sb));
		}
		return res;
	}
}
