import java.util.*;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(k, new MyComparator());
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		for (Integer key: map.keySet()) {
			if (pq.size() < k) {
				pq.add(new Node(key, map.get(key)));

			} else {
				if (map.get(key) > pq.peek().fre) {
					pq.poll();
					pq.add(new Node(key, map.get(key)));
				}
			}
		}
		List<Integer> res = new ArrayList<>(k);
		for (int i = k - 1; i >= 0; i--) {
			res.add(pq.poll().num);
		}
		return res;
	}
	private class Node {
		private int num;
		private int fre;
		public Node(int num, int fre) {
			this.num = num;
			this.fre = fre;
		}
	}
	private class MyComparator implements Comparator<Node> {
		public int compare(Node n1, Node n2) {
			return n1.fre - n2.fre;
		}
	}
}
