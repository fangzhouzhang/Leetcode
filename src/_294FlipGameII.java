import java.util.HashMap;
import java.util.Map;

public class _294FlipGameII {
	public boolean canWin(String s) {
		if (s == null || s.length() == 0) return false;
		Map<String, Boolean> dp = new HashMap<>();
		char[] arr = s.toCharArray();
		return dfs(arr, dp);
	}

	private boolean dfs(char[] arr, Map<String, Boolean> dp) {
		String key = new String(arr);
		if (dp.containsKey(key)) return dp.get(key);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1] && arr[i] == '+') {
				change(arr, i);
				boolean res = dfs(arr, dp);
				if (!res) {
					change(arr, i);
					dp.put(key, true);
					return true;
				}
				change(arr, i);
			}
		}
		dp.put(key, false);
		return false;
	}

	private void change(char[] arr, int i) {
		if (arr[i] == '+') {
			arr[i] = '-';
			arr[i + 1] = '-';
		} else {
			arr[i] = '+';
			arr[i + 1] = '+';
		}
	}
}
