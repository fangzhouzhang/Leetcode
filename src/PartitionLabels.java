import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		List<Integer> res = new ArrayList<>();
		if (S.length() == 0) return res;
		int[] map = new int[26];
		for (int i = 0; i < S.length(); i++) {
			map[S.charAt(i) - 'a'] = i;
		}

		int start = 0;
		int end = 0;
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, map[S.charAt(i) - 'a']);
			if (i == end) {
				res.add(end - start + 1);
				start = end + 1;
			}
		}
		return res;
	}
}
