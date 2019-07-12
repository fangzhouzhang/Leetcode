import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		long l = (long) lower;
		long u = (long) upper;
		List<String> res = new ArrayList<>();

		if (nums.length == 0) {
            /*if (l == u) {
                return res;
            } else if (u - l >= 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(l);
                sb.append("->");
                sb.append(u);
                res.add(new String(sb));
                return res;
            }*/
			add(res, l - 1, u + 1);
			return  res;
		}

		add(res, l - 1, nums[0]);

		for (int i = 1; i < nums.length; i++) {
			add(res, nums[i - 1], nums[i]);
		}

		add(res, nums[nums.length - 1], u + 1);
		return res;
	}
	private void add(List<String> res, long lower, long upper) {

		if (lower == upper || lower + 1 == upper) {
			//do nothing
		} else if (lower + 2 == upper) {
			res.add(String.valueOf(lower + 1));
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(lower + 1);
			sb.append("->");
			sb.append(upper - 1);
			res.add(new String(sb));
		}
	}
}
