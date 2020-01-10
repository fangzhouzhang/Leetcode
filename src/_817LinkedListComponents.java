import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _817LinkedListComponents {
	public int numComponents(ListNode head, int[] G) {
		if (head == null) return 0;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			if (pre != null) {
				if (!map.containsKey(pre.val)) map.put(pre.val, new HashSet<>());
				if (!map.containsKey(cur.val)) map.put(cur.val, new HashSet<>());
				map.get(pre.val).add(cur.val);
				map.get(cur.val).add(pre.val);
			}
			pre = cur;
			cur = cur.next;
		}
		//how to search adjacent nodes
		Set<Integer> dedup = new HashSet<>();
		Set<Integer> dict = new HashSet<>();
		for (int n : G) dict.add(n);
		int res = 0;
		for (int n : G) {
			if (!dedup.contains(n)) {
				res++;
				dedup.add(n);
				dfs(n, map, dict, dedup);
			}
		}
		return res;
	}

	private void dfs(int n, Map<Integer, Set<Integer>> map, Set<Integer> dict, Set<Integer> dedup) {
		Set<Integer> neighbors = map.get(n);
		if (neighbors == null || neighbors.size() == 0) return;
		for (int neighbor : neighbors) {
			if (!dedup.contains(neighbor) && dict.contains(neighbor)) {
				dedup.add(neighbor);
				dfs(neighbor, map, dict, dedup);
			}
		}
	}
}
