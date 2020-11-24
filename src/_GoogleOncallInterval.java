import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _GoogleOncallInterval {
	private List<String> solve(int[][] nums, String[] names) {
		List<String> res = new ArrayList<>();
		int n = nums.length;
		TreeMap<Integer, List<Node>> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			String name = names[i];
			Node start  = new Node(name, true);
			Node end  = new Node(name, false);
			if (!map.containsKey(nums[i][0])) map.put(nums[i][0], new ArrayList<>());
			if (!map.containsKey(nums[i][1])) map.put(nums[i][1], new ArrayList<>());
			map.get(nums[i][0]).add(start);
			map.get(nums[i][1]).add(end);
		}
		int prev = -1;
		Set<String> people = new HashSet<>();
		for (Map.Entry<Integer, List<Node>> e: map.entrySet()) {
			int cur = e.getKey();
			if (people.size() > 0) {
				res.add("(" + prev + ", " + e.getKey() + "): " + people);
			}
			for (Node p : e.getValue()) {
				if (p.start) {
					people.add(p.name);
				} else {
					people.remove(p.name);
				}
			}
			prev = cur;
		}

		return res;
	}

	 private class Node{

		String name;
		boolean start;

		public Node(String name, boolean start) {
			this.name = name;
			this.start = start;
		}

	}
}
