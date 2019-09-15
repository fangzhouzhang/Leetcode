import java.util.*;

public class SequenceReconstruction {
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		if (org.length == 0 || seqs.size() == 0) {
			return false;
		}
		//build graph
		Map<Integer, Integer> indegree = new HashMap<>();
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		buildGraph(seqs, indegree, graph);
		Queue<Integer> q = new LinkedList<>();
		if (org.length != indegree.size()) {
			return false;
		}
		for (Map.Entry<Integer, Integer> e : indegree.entrySet()) {
			if (e.getValue() == 0) {
				q.add(e.getKey());
			}
		}
		int idx = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if (size > 1) {
				return false;
			}
			int key = q.poll();
			if (idx == org.length || org[idx++] != key) {
				return false;
			}
			for (Integer n: graph.get(key)) {
				indegree.put(n, indegree.get(n) - 1);
				if (indegree.get(n) == 0) {
					q.offer(n);
				}
			}
		}
		return idx == org.length;
	}

	private void buildGraph(List<List<Integer>> seqs, Map<Integer, Integer> indegree, Map<Integer, Set<Integer>> graph) {
		for (List<Integer> seq: seqs) {
			if (seq.size() == 1) {
				if (!graph.containsKey(seq.get(0))) {
					graph.put(seq.get(0), new HashSet<>());
					indegree.put(seq.get(0), 0);
				}
			}
			else {
				for (int i = 0; i < seq.size() - 1; i++) {
					if (!graph.containsKey(seq.get(i))) {
						graph.put(seq.get(i), new HashSet<>());
						indegree.put(seq.get(i), 0);
					}
					if (!graph.containsKey(seq.get(i + 1))) {
						graph.put(seq.get(i + 1), new HashSet<>());
						indegree.put(seq.get(i + 1), 0);
					}
					if (graph.get(seq.get(i)).add(seq.get(i + 1))) {
						indegree.put(seq.get(i + 1), indegree.get(seq.get(i + 1)) + 1);
					}
				}
			}
		}
	}
}
