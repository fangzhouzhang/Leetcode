import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		dfs(res, s.toCharArray(), 0, new StringBuilder(), 0, s);
		return res;
	}
	private void dfs(List<String> res,
					 char[] arr,
					 int start,
					 StringBuilder sb,
					 int dot, String s) {
		//success
		if (dot == 3 && start == arr.length) {
			// System.out.println("finish");
			res.add(new String(sb));
			return;
		}
		//fail
		if (dot > 3) {
			// System.out.println("dot > 3");
			return;
		}
		if (start >= arr.length) {
			// System.out.println("dot > 3");
			return;
		}
		for (int len = 1; len <= 3; len++) {
			if (isValid(arr, start, len, s)) {
				int prevLen = sb.length();
				sb.append(arr, start, len);
				if (start + len - 1 != arr.length - 1) {
					sb.append('.');
					// System.out.println("sb is " + sb);
					dfs(res, arr, start + len, sb, dot + 1, s);
				} else {
					// System.out.println("sb is " + sb);
					dfs(res, arr, start + len, sb, dot, s);

				}
				sb.setLength(prevLen);
			}
		}
	}
	private boolean isValid(char[] arr, int start, int len, String s) {
		if (start + len > s.length()) {
			return false;
		}
		if (len > 1 && arr[start] == '0') {
			// System.out.println("first is 0 ");
			return false;
		}
		if (len == 3) {
			String num = s.substring(start, start + len);
			if (Integer.parseInt(num) > 255) {
				// System.out.println("num is > 255 ");
				return false;
			}
		}

		return true;
	}
}
