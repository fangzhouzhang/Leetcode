import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
	//https://www.youtube.com/watch?v=0cQcYJ3WHSs
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		if (words.length == 0) return res;
		int i = 0, curNum = 0;
		List<String> curLine = new ArrayList<>();
		while (i < words.length) {
			boolean foul = false;
			//if still valid, continue to add words to cur line
			if (curNum == 0) {
				if (words[i].length() <= maxWidth) {
					curLine.add(words[i]);
					curNum += words[i].length();
					i++;
				} else {
					foul = true;
				}
			} else {
				if (curNum + 1 + words[i].length() <= maxWidth) {
					curLine.add(words[i]);
					curNum += words[i].length() + 1;
					i++;
				} else {
					foul = true;
				}
			}
			//if not, add current result to res and clear curLine and curNum
			if (foul) {
				res.add(constructLine(curLine, curNum, maxWidth));
				curLine.clear();
				curNum = 0;
			}
		}
		if (curLine.size() > 0) {
			res.add(constructLastLine(curLine, curNum, maxWidth));
		}
		return res;
	}

	private String constructLine(List<String> curLine, int curNum, int maxWidth) {
		if (curLine.size() == 1) return constructLastLine(curLine, curNum, maxWidth);
		int slots = curLine.size() - 1;
		int wordLen = curNum - slots;
		int spaces = maxWidth - wordLen;
		int avg = spaces / slots;
		int add = spaces % slots;
		int[] arr = new int[slots];
		Arrays.fill(arr, avg);
		int m = 0;
		while (add > 0) {
			arr[m++] += 1;
			add--;
		}
		StringBuilder sb = new StringBuilder();
		m = 0;
		for (int i = 0; i < curLine.size(); i++) {
			if (i == curLine.size() - 1) {
				sb.append(curLine.get(i));
			} else {
				sb.append(curLine.get(i));
				sb.append(spaceToString(arr[m++]));
			}
		}
		return new String(sb);
	}

	private String constructLastLine(List<String> curLine, int curNum, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < curLine.size(); i++) {
			if (i == curLine.size() - 1) {
				sb.append(curLine.get(i));
			} else {
				sb.append(curLine.get(i)).append(' ');
			}
		}
		sb.append(spaceToString(maxWidth - sb.length()));
		return new String(sb);
	}

	private String spaceToString(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(" ");
			num--;
		}
		return new String(sb);
	}
}
