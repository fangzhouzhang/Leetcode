import java.util.*;

public class _1342ReduceArraySizetoTheHalf {
	public int minSetSize(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
		int del = 0, res = 0, idx = 0;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			list.add(e);
		}
		Collections.sort(list, new MyComparator());
		while (del < arr.length / 2) {
			del += list.get(idx++).getValue();
			res++;
		}
		return res;
	}

	private class MyComparator implements Comparator<Map.Entry<Integer, Integer>> {
		public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
			return b.getValue() - a.getValue();
		}
	}
}
