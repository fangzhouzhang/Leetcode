import java.util.Arrays;

public class _473MatchstickstoSquare {
	boolean[] visit;
	public boolean makesquare(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		int sum = 0;
		for (int n : nums) sum += n;
		if (sum % 4 != 0) return false;
		sum /= 4;
		visit = new boolean[nums.length];
		Arrays.sort(nums);
		for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		return dfs(0, 0, sum, 0, nums);
	}

	private boolean dfs(int idx, int cur, int length, int cnt, int[] nums) {
		if (cnt == 3) return true;
		if (cur == length) return dfs(0, 0, length, cnt + 1, nums);
		for (int i = idx; i < nums.length; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			if (dfs(i + 1, cur + nums[i], length, cnt, nums)) {
				return true;
			}
			visit[i] = false;
			if (cur == 0 || cur + nums[i] == length) return false;
			while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
		}
		return false;
	}
}
