import java.util.*;

public class _1331RankTransformofanArray {
	public int[] arrayRankTransform(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new ArrayList<>());
				pq.add(arr[i]);
			}
			map.get(arr[i]).add(i);
		}
		int[] res = new int[arr.length];
		int rank = 1;
		while (!pq.isEmpty()) {
			int num = pq.poll();
			List<Integer> idxs = map.get(num);
			for (int idx : idxs) res[idx] = rank;
			rank++;
		}
		return res;
	}
}
