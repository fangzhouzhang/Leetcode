import java.util.ArrayList;

public class _1585CheckIfStringIsTransformableWithSubstringSortOperations {
	public boolean isTransformable(String s, String t) {
		ArrayList<Integer>[] idx = new ArrayList[10];
		for (int i = 0; i < 10; i++)
			idx[i] = new ArrayList<Integer>();
		int[] cnt = new int[10];
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - '0';
			idx[index].add(i);
		}
		for (int i = 0; i < t.length(); i++) {
			int d = t.charAt(i) - '0';
			if (cnt[d] >= idx[d].size()) return false;
			for (int k = 0; k < d; k++) {
				if (cnt[k] < idx[k].size() && idx[k].get(cnt[k]) < idx[d].get(cnt[d])) return false;
			}
			cnt[d]++;
		}
		return true;
	}
}
