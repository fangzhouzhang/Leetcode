import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		if (num == null || num.length() == 0) {
			return res;
		}
		char[] sc = num.toCharArray();
		char[] path = new char[sc.length * 2];
		// dfs(res, new StringBuilder(), num, target, 0, 0, 0);
		dfs1(res, sc, path, target, 0, 0, 0, 0);
		return res;
	}
	private void dfs1(List<String> res, char[] sc, char[] path, int target, long sum, long lastNum, int idxs, int idxp) {
		if (idxs == sc.length && sum == target) {
			// System.out.println("target " + target + " sum " + sum + " last num " +  lastNum);
			res.add(new String(path, 0, idxp));
			return;
		}
		if (idxs == sc.length) {
			return;
		}
		long val = 0;
		int signIdx = idxp;
		if (idxs == 0) {
			for (int i = idxs; i < sc.length && idxp < path.length; i++, idxp++) {
				val = val * 10 + sc[i] - '0';
				path[idxp] = sc[i];
				dfs1(res, sc, path, target, sum + val, val, i + 1, idxp + 1);
				if (val == 0) {
					break;
				}
			}
		} else {
			idxp++;
			for (int i = idxs; i < sc.length && idxp < path.length; i++, idxp++) {
				val = val * 10 + sc[i] - '0';
				//+
				path[signIdx] = '+';
				path[idxp] = sc[i];
				dfs1(res, sc, path, target, sum + val, val, i + 1, idxp + 1);

				//-
				path[signIdx] = '-';
				path[idxp] = sc[i];
				dfs1(res, sc, path, target, sum - val, -val, i + 1, idxp + 1);

				//*
				//+
				path[signIdx] = '*';
				path[idxp] = sc[i];
				dfs1(res, sc, path, target, sum - lastNum + lastNum * val, lastNum * val, i + 1, idxp + 1);

				if (val == 0) {
					break;
				}
			}
		}

	}
	private void dfs(List<String> res,
					 StringBuilder sb,
					 String num,
					 int target,
					 long sum,
					 long lastNum,
					 int idx) {
		//success
		if (idx == num.length() && sum == target) {
			// System.out.println("target " + target + " sum " + sum + " last num " +  lastNum);
			res.add(new String(sb));
			return;
		}
		//fail
		if (idx == num.length()) {
			return;
		}
		int prevLen = sb.length();

		for (int i = idx; i < num.length(); i++) {
			Long cut = Long.parseLong(num.substring(idx, i + 1));

			if (prevLen != 0) {
				//+
				sb.append("+" + cut);
				dfs(res, sb, num, target, sum + cut, cut, i + 1);
				sb.setLength(prevLen);
				//-
				sb.append("-" + cut);
				dfs(res, sb, num, target, sum - cut, -cut, i + 1);
				sb.setLength(prevLen);
				//*
				sb.append("*" + cut);
				dfs(res, sb, num, target, sum - lastNum + lastNum * cut, lastNum * cut, i + 1);
				sb.setLength(prevLen);
			} else if (prevLen == 0) {
				sb.append(cut);
				dfs(res, sb, num, target, sum + cut, cut, i + 1);
				sb.setLength(prevLen);
			}
			if (cut == 0) {
				break;
			}
		}


	}
}
