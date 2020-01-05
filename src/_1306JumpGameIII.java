import java.util.HashSet;
import java.util.Set;

public class _1306JumpGameIII {
	public boolean canReach(int[] arr, int start) {
		if (arr == null || arr.length == 0) return false;
		if (!isValid(arr, start)) return false;
		Boolean[] dp = new Boolean[arr.length];
		return dfs(arr, start, dp, new HashSet<Integer>());
	}

	private boolean dfs(int[] arr, int idx, Boolean[] dp, Set<Integer> set) {
		if (set.contains(idx)) return false;
		set.add(idx);
		if (arr[idx] == 0) return true;
		if (dp[idx] != null) return dp[idx];
		if (isValid(arr, idx - arr[idx]) && dfs(arr, idx - arr[idx], dp, set) || (isValid(arr, idx + arr[idx]) && dfs(arr, idx + arr[idx], dp, set))) {
			dp[idx] = true;
			return true;
		}
		set.remove(idx);
		dp[idx] = false;
		return false;
	}

	private boolean isValid(int[] a, int start) {
		if (start < 0 || start >= a.length) return false;
		return true;
	}
}
