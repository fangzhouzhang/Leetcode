import java.util.*;

public class _1345JumpGameIV {
	public int minJumps(int[] arr) {
		if (arr == null || arr.length <= 1) return 0;
		Map<Integer, LinkedList<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) map.put(arr[i], new LinkedList<Integer>());
			map.get(arr[i]).add(i);
		}
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> dedup = new HashSet<>();
		q.add(0);
		dedup.add(0);
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int i = q.poll();
				if (i == arr.length - 1) return step;
				LinkedList<Integer> list = map.get(arr[i]);
				while (!list.isEmpty()) {
					int num = list.pollFirst();
					if (!dedup.contains(num)) {
						q.add(num);
						dedup.add(num);
					}
				}
				if (i - 1 >= 0 && !dedup.contains(i - 1)) {
					q.add(i - 1);
					dedup.add(i - 1);
				}
				if (i + 1 < arr.length && !dedup.contains(i + 1)) {
					q.add(i + 1);
					dedup.add(i + 1);
				}

			}
			step++;
		}
		return step;
	}
}
