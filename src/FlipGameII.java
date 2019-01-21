import java.util.HashMap;
import java.util.Map;

public class FlipGameII {
	/**
	 * time: o(n^n) space : o(n)
	 * @param s
	 * @return
	 */
	public boolean canWin(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		char[] arr = s.toCharArray();
		Map<String, Boolean> map = new HashMap<>();
		boolean res = dfs(arr, map);
		// System.out.println(map.size());
		return res;
	}
	private boolean dfs(char[] arr, Map<String, Boolean> map) {

		if (map.containsKey(new String(arr))) {
			return map.get(new String(arr));
		}
		//map does not contain
		for (int i = 0; i + 1 < arr.length; i++) {

			if (isValid(arr, i, i + 1)) {
				arr[i] = '-';
				arr[i + 1] = '-';

				boolean res = dfs(arr, map);

				map.put(new String(arr), res);
				arr[i] = '+';
				arr[i + 1] = '+';

				if (res == false) {
					return true;
				}
			}

		}
		return false;
	}
	private boolean isValid(char[] arr, int i, int j) {
		if (arr[i] != '+' || arr[j] != '+' ) {
			return false;
		}
		return true;
	}
}
