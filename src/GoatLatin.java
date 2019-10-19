import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
	public String toGoatLatin(String S) {
		char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		Set<Character> set = new HashSet<>();
		for (char ch : vowels) set.add(ch);
		int aNum = 1;
		StringBuilder sb = new StringBuilder();
		String[] arr = S.split(" ");
		for (String str : arr) {
			StringBuilder cur = new StringBuilder(str);
			char c = str.charAt(0);
			if (set.contains(c)) {


			} else {
				cur = cur.deleteCharAt(0);
				cur.append(c);
			}
			cur.append("ma");
			for (int j = 0; j < aNum; j++) cur.append('a');
			cur.append(" ");
			aNum++;
			sb.append(cur);
		}
		sb = sb.deleteCharAt(sb.length() - 1);
		return new String(sb);
	}
}
