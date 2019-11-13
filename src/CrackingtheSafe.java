import java.util.HashSet;
import java.util.Set;

public class CrackingtheSafe {
	public String crackSafe(int n, int k) {
		if (n <= 0) return "";
		double target = Math.pow(k, n);
		Set<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('0');
		}
		set.add(new String(sb));
		if (dfs(target, sb, set, k, n)) return new String(sb);
		return "";
	}

	private boolean dfs(double target, StringBuilder sb, Set<String> set, int k, int n) {
		if (set.size() == target) return true;
		//cut previous string from index 1
		String str = sb.substring(sb.length() - n + 1);
		for (char c = '0'; c < '0' + k; c++) {
			int prev = sb.length();
			sb.append(c);
			String cur = str + c;
			if (!set.contains(cur)) {
				set.add(cur);
				if (dfs(target, sb, set, k, n)) return true;
				set.remove(cur);
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return false;
	}
}
