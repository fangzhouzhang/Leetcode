import java.util.*;

public class _444SequenceReconstruction {
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		if (org == null || org.length == 0) return false;
		if (seqs == null || seqs.size() == 0) return false;
		int[] map = new int[org.length + 1];
		boolean[] visit = new boolean[org.length + 1];
		for (int i = 0; i < org.length; i++) map[org[i]] = i;
		int cnt = org.length - 1;
		boolean exec = false;
		for (List<Integer> seq : seqs) {
			for (int i = 0; i < seq.size(); i++) {
				exec = true;
				int pre = seq.get(i);
				if (pre <= 0 || pre > org.length) return false;
				if (i == seq.size() - 1) continue;
				int cur = seq.get(i + 1);
				if (cur <= 0 || cur > org.length) return false;
				if (map[pre] >= map[cur]) return false;
				if (!visit[pre] && map[pre] + 1 == map[cur]) {
					cnt--;
					visit[pre] = true;
				}
			}
		}
		return cnt == 0 && exec;
	}
}
