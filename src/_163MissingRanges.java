import java.util.ArrayList;
import java.util.List;

public class _163MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			addInterval(lower, upper, res);
			return res;
		}
		long start = (long)lower, end = 0;
		for (int n : nums) {
			end = (long)n - 1;
			if (start <= end) addInterval((int)start, (int)end, res);
			start = (long)n + 1;
		}
		end = (long)upper;
		if (start <= end) addInterval((int)start, (int)end, res);
		return res;
	}

	private void addInterval(int s, int e, List<String> res) {
		if (s == e) {
			res.add(s + "");
		} else {
			String cur = s + "->" + e;
			res.add(cur);
		}
	}
}
