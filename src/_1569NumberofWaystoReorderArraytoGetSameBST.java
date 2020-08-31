import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1569NumberofWaystoReorderArraytoGetSameBST {
	private long[][] fac;
	private int M = 1000000007;
	public int numOfWays(int[] nums) {
		fac = new long[nums.length + 1][nums.length + 1];
		for (int i = 1; i < fac.length; i++) {
			Arrays.fill(fac[i], 1);
			fac[i][1] = i;
		}
		for (int i = 1; i < fac.length; i++) {
			for (int j = 2; j < i; j++) {
				fac[i][j] = (fac[i - 1][j - 1] + fac[i - 1][j]) % M;
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int n : nums) list.add(n);
		return (int)dfs(list) - 1;
	}

	private long dfs(List<Integer> list) {
		int n = list.size();
		if (n <= 2) return 1;
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		int root = list.get(0);
		for (Integer num : list) {
			if (num < root) left.add(num);
			if (num > root) right.add(num);
		}
		long l = dfs(left) % M;
		long r = dfs(right) % M;
		int leftSize = left.size(), rightSize = right.size();
		long cur = fac[leftSize + rightSize][leftSize];
		return (cur * l) % M * r % M;
	}
}
