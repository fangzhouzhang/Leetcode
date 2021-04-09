public class _1816TruncateSentence {
	public String truncateSentence(String s, int k) {
		StringBuilder sb = new StringBuilder();
		String[] arr = s.split(" ");
		for (int i = 0; i < k; i++) sb.append(arr[i]).append(' ');
		sb.setLength(sb.length() - 1);
		return new String(sb);
	}
}
