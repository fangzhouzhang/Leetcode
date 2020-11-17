import java.util.Random;

public class _528RandomPickwithWeight {
	private class Solution {
		int[] prefix;
		Random r;
		public Solution(int[] w) {
			r = new Random();
			int n = w.length, sum = 0;
			prefix = new int[n + 1];
			for (int i = 0; i < n; i++) {
				sum += w[i];
				prefix[i + 1] = sum;
			}
		}

		public int pickIndex() {
			int num = r.nextInt(prefix[prefix.length - 1]) + 1;
			int start = 0, end = prefix.length - 1;
			while (start <= end) {
				// Find the largest idx < num
				int mid = start + (end - start) / 2;
				if (prefix[mid] >= num) end = mid - 1;
				else start = mid + 1;
			}
			return end;
		}
	}
}
