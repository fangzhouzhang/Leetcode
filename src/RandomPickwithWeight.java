import java.util.Random;

public class RandomPickwithWeight {
	private int[] prefix;
	public RandomPickwithWeight(int[] w) {
		prefix = new int[w.length];
		int sum = 0;
		for (int i = 0; i < w.length; i++) {
			sum += w[i];
			prefix[i] = sum;
		}
	}

	public int pickIndex() {
		int t = new Random().nextInt(prefix[prefix.length - 1]);
		int start = 0, end = prefix.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (prefix[mid] <= t) start = mid + 1;
			else end = mid - 1;
		}
		return start;
	}
}
