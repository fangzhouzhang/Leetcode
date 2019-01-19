import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		if (num == null || num.length() == 0) {
			return res;
		}
		dfs(res, new StringBuilder(), num, target, 0, 0, 0);
		return res;
	}
	private void dfs(List<String> res,
					 StringBuilder sb,
					 String num,
					 int target,
					 long sum,
					 long lastNum,
					 int level) {
		if (sum == (long)target && level == num.length()) {
			res.add(new String(sb));
			return;
		}
		if (sum != (long)target && level >= num.length()) {
			return;
		}
		if (level == 0) {
			int prevLen  = sb.length();
			long cur = 0;
			for (int offset = 1; level + offset <= num.length(); offset++) {
				if (offset != 1 && num.charAt(level) == '0') {
					continue;
				}
				cur = Long.parseLong(num.substring(level, level + offset));
				sb.append(cur);
				dfs(res, sb, num, target, sum + cur, cur, level + offset);
				sb.setLength(prevLen);
			}
		} else {//level >= 1
			for (int i = 0; i < 3; i++) {
				if (i == 0) {//+
					int prevLen  = sb.length();
					long cur = 0;
					for (int offset = 1; level + offset <= num.length(); offset++) {
						if (offset != 1 && num.charAt(level) == '0') {
							continue;
						}
						cur = Long.parseLong(num.substring(level, level + offset));
						sb.append("+");
						sb.append(cur);
						dfs(res, sb, num, target, sum + cur, cur, level + offset);
						sb.setLength(prevLen);
					}
				} else if (i == 1) {//-
					int prevLen  = sb.length();
					long cur = 0;
					for (int offset = 1; level + offset <= num.length(); offset++) {
						if (offset != 1 && num.charAt(level) == '0') {
							continue;
						}
						cur = Long.parseLong(num.substring(level, level + offset));
						sb.append("-");
						sb.append(cur);
						dfs(res, sb, num, target, sum + (-1 * cur), -1 * cur, level + offset);
						sb.setLength(prevLen);
					}
				} else {//*
					int prevLen  = sb.length();
					long cur = 0;
					for (int offset = 1; level + offset <= num.length(); offset++) {
						if (offset != 1 && num.charAt(level) == '0') {
							continue;
						}
						cur = Long.parseLong(num.substring(level, level + offset));
						sb.append("*");
						sb.append(cur);
						dfs(res, sb, num, target, sum - lastNum + lastNum * cur, lastNum * cur, level + offset);
						sb.setLength(prevLen);
					}
				}
			}
		}

	}
}
