import java.util.*;

public class AlienDictionary {
	public String alienOrder(String[] words) {
		int[] indegree = new int[26];
		Map<Character, Set<Character>> map = new HashMap<>();
		buildGraph(words, indegree, map);
		return bfs(indegree, map);
	}
	private void buildGraph(String[] words, int[] indegree, Map<Character, Set<Character>> map) {
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				if (!map.containsKey(word.charAt(i))) {
					map.put(word.charAt(i), new HashSet<Character>());
				}
			}
		}

		for (int i = 1; i < words.length; i++) {
			int len = Math.min(words[i - 1].length(), words[i].length());
			for (int j = 0; j < len; j++) {
				char out = words[i - 1].charAt(j);
				char in = words[i].charAt(j);
				if (out != in) {
					if (map.get(out).add(in)) {
						indegree[in - 'a']++;
					}

					break;
				}
			}
		}
		// System.out.println("map size is " + map.size());
	}
	private String bfs(int[] indegree, Map<Character, Set<Character>> map) {
		Queue<Character> q = new LinkedList<>();
		for (Character key : map.keySet()) {
			if (indegree[key - 'a'] == 0) {
				q.add(key);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			Character c = q.poll();
			sb.append(c);
			Set<Character> set = map.get(c);
			if (set == null || set.size() == 0) {
				continue;
			}
			for (Character ch : set) {
				indegree[ch - 'a']--;
				if (indegree[ch - 'a'] == 0) {
					q.add(ch);
				}
			}
		}
		return sb.length() == map.size() ? new String(sb) : "";
	}
}
