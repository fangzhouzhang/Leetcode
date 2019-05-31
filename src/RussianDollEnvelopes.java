import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0 || envelopes[0].length == 0) {
			return 0;
		}
		Arrays.sort(envelopes, new Comparator<int[]>(){
			public int compare(int[] arr1, int[] arr2){
				if(arr1[0] == arr2[0])
					return arr2[1] - arr1[1];
				else
					return arr1[0] - arr2[0];
			}
		});
		int len = 0;
		int[] dp = new int[envelopes.length];
		for (int[] e : envelopes) {
			int ret = Arrays.binarySearch(dp, 0, len, e[1]);
			int insertIdx = 0;
			if (ret < 0) {
				insertIdx = -(ret + 1);
			} else {
				insertIdx = ret;
			}
			dp[insertIdx] = e[1];
			if (insertIdx == len) {
				len++;
			}
		}
		return len;
		// Map<String, Integer> map = new HashMap<>();
		// return dfs(envelopes, 0, map, -1, -1);

	}
	private int dfs(int[][] e, int idx, Map<String, Integer> map, int minWidth, int minHeight) {
		if (idx == e.length) {
			return 0;
		}



		Integer cout = map.get(e[idx][0] + "#" + e[idx][1]);
		if (cout != null) {
			return cout;
		}


		int max = 0;
		for (int i = idx; i < e.length; i++) {
			int curWidth = e[i][0];
			int curHeight = e[i][1];
			if (minHeight < curHeight && minWidth < curWidth) {
				max = Math.max(max, dfs(e, i + 1, map, curWidth, curHeight) + 1);
			}
		}
		map.put(e[idx][0] + "#" + e[idx][1], max);
		return max;
	}
}
