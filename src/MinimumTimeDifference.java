import java.util.List;

public class MinimumTimeDifference {
	public int findMinDifference(List<String> timePoints) {
		int res = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int prev = -1;
		boolean[] b = new boolean[24 * 60];
		for (String s: timePoints) {
			String[] arr = s.split(":");
			int h = 0, m = 0;
			h = Integer.valueOf(arr[0]);
			m = Integer.valueOf(arr[1]);
			if (b[h * 60 + m]) {
				return 0;
			}
			b[h* 60 + m] = true;
		}

		for (int i = 0; i < 24 * 60; i++) {
			if (b[i]) {
				if (prev != -1) {
					res = Math.min(res, i - prev);
				}
				min = Math.min(min, i);
				max = Math.max(max, i);
				prev = i;
			}
		}
		return Math.min(res, 1440 + min - max);
	}
}
