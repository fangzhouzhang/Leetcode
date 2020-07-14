import java.util.ArrayList;
import java.util.List;

public class _282ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		if (num == null || num.length() == 0) return res;
		char[] nums = num.toCharArray();
		char[] exp = new char[2 * nums.length];
		dfs(nums, exp, res, target, 0, 0, 0, 0);
		return res;
	}

	private void dfs(char[] nums, char[] exp, List<String> res, int target, long sum, long prev,int idx, int idxp) {
		if (idx == nums.length && sum == target) {
			res.add(new String(exp, 0, idxp));
			return;
		}
		if (idx == nums.length) return;
		if (idx == 0) {
			long val = 0;
			for (int i = idx; i < nums.length; i++, idxp++) {
				val = val * 10 + (nums[i] - '0');
				//+
				exp[idxp] = nums[i];
				dfs(nums, exp, res, target, sum + val, val, i + 1, idxp + 1);
				if (val == 0) break;
			}
		} else {
			int signIdx = idxp;
			idxp++;
			long val = 0;
			for (int i = idx; i < nums.length; i++, idxp++) {
				val = val * 10 + (nums[i] - '0');
				//+
				exp[signIdx] = '+';
				exp[idxp] = nums[i];
				dfs(nums, exp, res, target, sum + val, val, i + 1, idxp + 1);

				//-
				exp[signIdx] = '-';
				exp[idxp] = nums[i];
				dfs(nums, exp, res, target, sum - val, -1 * val, i + 1, idxp + 1);

				//*
				exp[signIdx] = '*';
				exp[idxp] = nums[i];
				dfs(nums, exp, res, target, sum - prev + prev * val, prev * val, i + 1, idxp + 1);
				if (val == 0) break;
			}
		}
	}
}
