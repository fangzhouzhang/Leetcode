import java.util.*;

public class RandomPickIndex {
	private Map<Integer, List<Integer>> map;
	private Random r;
	public RandomPickIndex(int[] nums) {
		r = new Random();
		map = new HashMap<>();
		buildMap(map, nums);
	}

	public int pick(int target) {
		//it must exist
		List<Integer> list = map.get(target);
		int size = list.size();
		int idx = r.nextInt(size);
		return list.get(idx);
	}
	private void buildMap(Map<Integer, List<Integer>> map, int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				List<Integer> list = map.get(nums[i]);
				list.add(i);
				map.put(nums[i], list);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(nums[i], list);
			}
		}
	}
}
