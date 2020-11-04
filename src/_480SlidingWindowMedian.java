import java.util.Comparator;
import java.util.PriorityQueue;

public class _480SlidingWindowMedian {
	private PriorityQueue<Integer> first = new PriorityQueue<>(new MyComparator());
	private PriorityQueue<Integer> second = new PriorityQueue<>();
	private boolean odd;
	public double[] medianSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) return new double[0];
		int n = nums.length;
		odd = k % 2 != 0;
		double[] res = new double[n - k + 1];
		for (int t = 0; t < k; t++) second.add(nums[t]);
		for (int t = 0; t < k / 2; t++) {
			first.add(second.poll());
		}
		int idx = 0;
		res[idx++] = getMedian();
		for (int t = k; t < n; t++) {
			int x = nums[t], y = nums[t - k];
			if (!second.isEmpty() && y >= second.peek()) second.remove(y);
			else first.remove(y);
			if (!second.isEmpty() && x >= second.peek()) second.add(x);
			else first.add(x);
			while (first.size() > second.size()) {
				second.add(first.poll());
			}
			while (first.size() + 1 < second.size()) {
				first.add(second.poll());
			}
			res[idx++] = getMedian();
		}
		return res;
	}

	private double getMedian() {
		if (odd) {
			return second.peek();
		} else {
			return ((long)first.peek() + (long)second.peek()) * 1.0 / 2;
		}
	}

	private class MyComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return Integer.compare(b, a);
		}
	}
}
