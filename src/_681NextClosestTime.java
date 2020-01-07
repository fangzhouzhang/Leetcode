import java.util.HashSet;
import java.util.Set;

public class _681NextClosestTime {
	public String nextClosestTime(String time) {
		if (time == null || time.length() == 0) return "";
		//1 get all the chars in original array
		Set<Character> chars = getChars(time);
		int originIdx = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
		// System.out.println(originIdx);
		char[] res = new char[4];
		res[0] = time.charAt(0);
		res[1] = time.charAt(1);
		res[2] = time.charAt(3);
		res[3] = time.charAt(4);
		int[] diff = new int[1];
		diff[0] = 1440;
		permutation(chars, originIdx, res, diff);
		StringBuilder sb = new StringBuilder();
		sb.append(res[0]).append(res[1]).append(':').append(res[2]).append(res[3]);
		return new String(sb);
	}

	private Set<Character> getChars(String time) {
		Set<Character> res = new HashSet<>();
		for (int i = 0; i < time.length(); i++) {
			if (i == 2) continue;
			res.add(time.charAt(i));
		}
		return res;
	}

	private void permutation(Set<Character> chars, int originIdx, char[] res, int[] diff) {
		char[] arr = new char[4];
		dfs(chars, originIdx, res, diff, arr, 0);
	}

	private void dfs(Set<Character> chars, int originIdx, char[] res, int[] diff, char[] arr, int idx) {
		if (idx == arr.length) {
			int cur = ((arr[0] - '0') * 10 + (arr[1] - '0')) * 60 + ((arr[2] - '0') * 10 + (arr[3] - '0'));
			// System.out.println(cur + "  " + new String(arr));
			if (cur < originIdx) {
				if ((cur + 1339 - originIdx) < diff[0]) {
					diff[0] = cur + 1339 - originIdx;
					for (int i = 0; i < 4; i++) res[i] = arr[i];
				}
			} else if (cur > originIdx){
				if ((cur - originIdx) < diff[0]) {
					diff[0] = cur - originIdx;
					for (int i = 0; i < 4; i++) res[i] = arr[i];
				}
			}
			return;
		}

		for (Character c: chars) {
			if (idx == 0 && c <= '2') {
				arr[0] = c;
				dfs(chars, originIdx, res, diff, arr, idx + 1);
			} else if (idx == 1) {
				if ((arr[0] == '2' && c <= '3') || (arr[0] == '1' || arr[0] == '0')) {
					arr[1] = c;
					dfs(chars, originIdx, res, diff, arr, idx + 1);
				}
			} else if (idx == 2 && c <= '5') {
				arr[2] = c;
				dfs(chars, originIdx, res, diff, arr, idx + 1);
			} else if (idx == 3 ) {
				arr[3] = c;
				dfs(chars, originIdx, res, diff, arr, idx + 1);
			}
		}
	}
}
