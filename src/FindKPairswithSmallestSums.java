import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) {
			return res;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
		for (int i = 0; i < nums1.length; i++) {
			pq.offer(new int[]{nums1[i], nums2[0], 0});
		}
		while (k > 0 && !pq.isEmpty()) {
			k--;
			int[] arr = pq.poll();
			List<Integer> tmp = new ArrayList<>();
			tmp.add(arr[0]);
			tmp.add(arr[1]);
			res.add(tmp);
			if (arr[2] == nums2.length - 1) {
				continue;
			}
			pq.add(new int[]{arr[0], nums2[arr[2] + 1], arr[2] + 1});
		}
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] + a[1] - b[0] - b[1];
		}
	}
}
