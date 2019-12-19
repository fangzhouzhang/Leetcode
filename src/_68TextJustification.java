import java.util.ArrayList;
import java.util.List;

public class _68TextJustification {
	//https://www.youtube.com/watch?v=qrZLQmL6fyI&t=798s
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		if (words == null || words.length == 0) return res;
		int n = words.length;
		int idx = 0;
		while (idx < n) {
			int chars = words[idx].length();
			int next = idx + 1;
			while (next < n && chars + 1 + words[next].length() <= maxWidth) {
				chars = chars + 1 + words[next].length();
				next++;
			}
			int gaps = next - idx - 1;//words number - 1
			StringBuilder sb = new StringBuilder();
			if (next == n || gaps == 0) {
				for (int i = idx; i < next; i++) {
					sb.append(words[i]).append(' ');
				}
				sb.deleteCharAt(sb.length() - 1);
				while (sb.length() < maxWidth) sb.append(' ');
			} else {
				int avgAddSpace = (maxWidth - chars) / gaps + 1;
				int moreSpaceIdx = (maxWidth - chars) % gaps;
				for (int i = idx; i < idx + moreSpaceIdx; i++) {
					sb.append(words[i]);
					addSpace(sb, avgAddSpace + 1);
				}
				for (int i = idx + moreSpaceIdx; i < next - 1; i++) {
					sb.append(words[i]);
					addSpace(sb, avgAddSpace);
				}
				sb.append(words[next - 1]);
			}
			res.add(new String(sb));
			idx = next;
		}
		return res;
	}

	private void addSpace(StringBuilder sb, int n) {
		for (int i = 0; i < n; i++) sb.append(' ');
	}
}
