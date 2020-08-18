import java.util.Arrays;

public class _1552MagneticForceBetweenTwoBalls {
	public int maxDistance(int[] position, int m) {
		if (position == null || position.length == 0) return 0;
		Arrays.sort(position);
		int n = position.length;
		int min = Integer.MAX_VALUE, max = position[n - 1] - position[0];
		for (int i = 0; i < n - 1; i++) {
			if (position[i + 1] - position[i] < min) {
				min = position[i + 1] - position[i];
			}
		}
		if (m == 2) return max;
		int start = min, end = max / (m - 1);
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (canPut(mid, position, m)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end >= min ? end : min;
	}

	private boolean canPut(int delta, int[] position, int m) {
		int count = 0, n = position.length, cur = position[0] + delta;
		for (int i = 0; i < n - 1; i++) {
			if (position[i + 1] >= cur) {
				cur = position[i + 1] + delta;
				count++;
			}
		}
		return count >= m - 1;
	}
}
