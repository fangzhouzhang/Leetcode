import java.util.ArrayList;
import java.util.List;

public class _300LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		/** dp[i] means the last number value of subsequence whose length is i + 1
		 dp: [3, 4]
		 [3] 3 is the last number of subsequece whose length is 1
		 [*, 4] 3 is the last number of subsequece whose length is 1, the first number might be some other value instead of 3**/
		List<Integer> dp = new ArrayList<>();
		for (int num : nums) {
			int n = dp.size();
			if (dp.isEmpty() || dp.get(n - 1) < num) dp.add(num);
			else {
				/** find the first position which is >= num
				 we try to make each element as small as possible
				 dp: [1, 3], cur element is 2,
				 it means we can replace 3 using 2 to greedly make subsequence long
				 **/
				int l = 0, r = n - 1;
				while (l < r) {
					int mid = l + r >> 1;
					if (dp.get(mid) >= num) r = mid;
					else l = mid + 1;
				}
				dp.set(l, num);
			}
		}
		return dp.size();
	}
}
