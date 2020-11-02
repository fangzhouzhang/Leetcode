import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1640CheckArrayFormationThroughConcatenation {
	public boolean canFormArray(int[] arr, int[][] pieces) {
		// Key is the pieces idx, value is the idxes showing up already.
		Map<Integer, Set<Integer>> map = new HashMap<>();
		Map<Integer, int[]> idxs = new HashMap<>();
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				int[] ar = {i, j};
				idxs.put(pieces[i][j], ar);
			}
		}
		for (int num : arr) {
			if (!idxs.containsKey(num)) return false;
			int[] ar = idxs.get(num);
			if (!map.containsKey(ar[0])) map.put(ar[0], new HashSet<>());
			Set<Integer> set = map.get(ar[0]);
			for (int i = 0; i < ar[1]; i++) {
				if (!set.contains(i)) return false;
			}
			for (int i = ar[1] + 1; i < pieces[ar[0]].length; i++) {
				if (set.contains(i)) return false;
			}
			set.add(ar[1]);
		}
		return true;
	}
}
