import java.util.HashSet;
import java.util.Set;

public class _128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Set<Integer> set = new HashSet<>();
		for (int n : nums) set.add(n);
		int res = 1, cur_streak = 1;
		for (int n : nums) {
			if (!set.contains(n - 1)) {
				while (set.contains(n + 1)) {
					cur_streak++;
					n++;
				}
				res = Math.max(res, cur_streak);
				cur_streak = 1;
			}
		}
		return res;
	}
}
