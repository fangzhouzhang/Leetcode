import java.util.*;

public class _269AlienDictionary {
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) return "";
		Map<Character, Set<Character>> map = new HashMap<>();
		int[] indegree = new int[26];
		buildGraph(words, map, indegree);
		return bfs(map,indegree);
	}

	private void buildGraph(String[] words, Map<Character, Set<Character>> map, int[] indegree) {
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!map.containsKey(c)) map.put(c, new HashSet<>());
			}
		}

		for (int i = 1; i < words.length; i++) {
			int len = Math.min(words[i - 1].length(), words[i].length());
			for (int j = 0; j < len; j++) {
				char a = words[i - 1].charAt(j);
				char b = words[i].charAt(j);
				if (a != b) {//we will exit after comparing difference
					if (!map.get(a).contains(b)) {
						map.get(a).add(b);
						indegree[b - 'a']++;
					}
					break;
				}
			}
		}
	}

	private String bfs(Map<Character, Set<Character>> map, int[] indegree) {
		Queue<Character> q = new LinkedList<>();
		Set<Character> set = new HashSet<>();
		for (Map.Entry<Character, Set<Character>> e : map.entrySet()) {
			char c = e.getKey();
			if (indegree[c - 'a'] == 0) {
				q.add(c);
				set.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			char c = q.poll();
			sb.append(c);
			Set<Character> neighbors = map.get(c);
			if (neighbors == null || neighbors.size() == 0) continue;
			for (Character neighbor : neighbors) {
				indegree[neighbor - 'a']--;
				if (indegree[neighbor - 'a'] == 0 && !set.contains(neighbor)) {
					set.add(neighbor);
					q.add(neighbor);
				}
			}
		}
		return sb.length() == map.size() ? new String(sb) : "";
	}
}
