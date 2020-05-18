import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1451RearrangeWordsinaSentence {
	public String arrangeWords(String text) {
		String[] words = text.split(" ");
		PriorityQueue<Pair> pq  = new PriorityQueue(new MyComparator());
		for (int i = 0; i < words.length; i++) {
			pq.add(new Pair<String, Integer>(words[i], i));
		}
		StringBuilder sb = new StringBuilder(text.length());
		while (!pq.isEmpty()) {
			String cur = (String)pq.poll().getKey();
			for (int i = 0; i < cur.length(); i++) {
				if (i == 0 && sb.length() == 0) {
					sb.append(Character.toUpperCase(cur.charAt(i)));
				} else {
					sb.append(Character.toLowerCase(cur.charAt(i)));
				}
			}
			sb.append(' ');
		}
		sb.deleteCharAt(sb.length() - 1);
		return new String(sb);
	}



	class MyComparator implements Comparator<Pair<String, Integer>> {
		public int compare(Pair<String, Integer> a, Pair<String, Integer> b) {
			if (a.getKey().length() != b.getKey().length()) return a.getKey().length() - b.getKey().length();
			else return a.getValue() - b.getValue();
		}
	}
}
