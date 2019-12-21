import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _632SmallestRangeCoveringElementsfromKLists {
	public int[] smallestRange(List<List<Integer>> nums) {
		if (nums == null || nums.size() == 0) return new int[]{-1, -1};
		int n = nums.size();
		int[] sizes = new int[n];
		for (int i = 0; i < n; i++) sizes[i] = nums.get(i).size();
		int[] idxs = new int[n];
		boolean outOfBound = false;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator(nums));
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, curMax = Integer.MIN_VALUE, diff = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (idxs[i] < sizes[i]) {
				int[] tmp = new int[]{i, idxs[i]};
				pq.add(tmp);
				curMax = Math.max(curMax, nums.get(i).get(idxs[i]));
				idxs[i]++;
			}
		}
		while (!outOfBound) {
			int[] arr = pq.poll();
			int curMin = nums.get(arr[0]).get(arr[1]);
			if (diff > curMax - curMin) {
				diff = curMax - curMin;
				min = curMin;
				max = curMax;
			}
			if (idxs[arr[0]] < sizes[arr[0]]) {
				int[] tmp = new int[]{arr[0], idxs[arr[0]]};
				pq.add(tmp);
				curMax = Math.max(curMax, nums.get(arr[0]).get(idxs[arr[0]]));
				idxs[arr[0]]++;
			} else {
				outOfBound = true;
			}
		}
		return new int[]{min, max};
	}

	private class MyComparator implements Comparator<int[]> {
		private List<List<Integer>> nums;
		public MyComparator(List<List<Integer>> nums) {
			this.nums = nums;
		}
		public int compare(int[] a, int[] b) {
			return nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]);
		}
	}
}
