import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		if (num == 0) {
			res.add("0:00");
			return res;
		}
		int[] hours = new int[]{8, 4, 2, 1};
		int[] mins = new int[]{32, 16, 8, 4, 2, 1};
		for (int i = 0; i <= num; i++) {
			List<Integer> hour = getNumber(hours, num - i);
			List<Integer> min = getNumber(mins, i);
			for (int h : hour) {
				if (h > 11) {
					continue;
				}
				for (int m : min) {
					if (m > 59) {
						continue;
					}
					String tmp = "";
					tmp += h;
					if (m < 10) {
						tmp += ":0" + m;
					} else {
						tmp += ":" + m;
					}
					res.add(tmp);
				}
			}
		}
		return res;
	}

	private List<Integer> getNumber(int[] nums, int cnt) {
		List<Integer> res = new ArrayList<>();
		dfs(nums, cnt, 0, res, 0);
		return res;
	}

	private void dfs(int[] nums, int cnt, int start, List<Integer> res, int sum) {
		if (cnt == 0) {
			res.add(sum);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			dfs(nums, cnt - 1, i + 1, res, sum + nums[i]);
		}
	}
}
