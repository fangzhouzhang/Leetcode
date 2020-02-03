import java.util.ArrayList;
import java.util.List;

public class _1220CountVowelsPermutation {
	private int M = 1000000007;
	public int countVowelPermutation(int n) {
		if (n == 0) return 0;
		List<Character>[] map = new List[26];
		constructMap(map);
		Integer[][] dp = new Integer[26][n + 1];
		dfs(dp, map, 'a', n);
		dfs(dp, map, 'e', n);
		dfs(dp, map, 'i', n);
		dfs(dp, map, 'o', n);
		dfs(dp, map, 'u', n);
		int res = 0;
		res += dp[0][n];
		res %= M;
		res += dp[4][n];
		res %= M;
		res += dp[8][n];
		res %= M;
		res += dp[14][n];
		res %= M;
		res += dp[20][n];
		res %= M;
		return res;
	}

	private int dfs(Integer[][] dp, List<Character>[] map, char cur, int rem) {
		if (rem == 1) {
			dp[cur - 'a'][rem] = 1;
			return 1;
		}
		if (dp[cur - 'a'][rem] != null) return dp[cur - 'a'][rem];
		int sum = 0;
		for (char c : map[cur - 'a']) {
			sum += dfs(dp, map, c, rem - 1);
			sum %= M;
		}
		dp[cur - 'a'][rem] = sum;
		return sum;
	}

	private void constructMap(List<Character>[] map) {
		map[0] = new ArrayList<>();
		map[0].add('e');
		map[4] = new ArrayList<>();
		map[4].add('a');
		map[4].add('i');
		map[8] = new ArrayList<>();
		map[8].add('a');
		map[8].add('e');
		map[8].add('o');
		map[8].add('u');
		map[14] = new ArrayList<>();
		map[14].add('i');
		map[14].add('u');
		map[20] = new ArrayList<>();
		map[20].add('a');
	}
}
