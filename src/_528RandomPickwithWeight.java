import java.util.Random;

public class _528RandomPickwithWeight {
	private class Solution {
		private Random rand;
		private int[] prefix;
		public Solution(int[] w) {
			rand = new Random();
			prefix = new int[w.length];
			int sum = 0;
			for (int i = 0; i < w.length; i++) {
				sum += w[i];
				prefix[i] = sum;
			}
		}

		public int pickIndex() {
			int val = rand.nextInt(prefix[prefix.length - 1]);
			//find first idx which is equal or greater than val
			int start = 0, end = prefix.length - 1;
			while (start + 1 < end) {
				int mid = start + (end - start) / 2;
				if (mid == 0 && val < prefix[mid]) return mid;
				if (prefix[mid - 1] <= val && val < prefix[mid]) return mid;
				else if (val >= prefix[mid]) start = mid;
				else end = mid;
			}
			if (prefix[start] > val) return start;
			else return end;
		}
	}
}
