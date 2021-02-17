public class _1754LargestMergeOfTwoStrings {
	public String largestMerge(String word1, String word2) {
		int n = word1.length(), m = word2.length();
		if (n == 0 || m == 0) return word1 + word2;
		if (word1.compareTo(word2) > 0) return word1.charAt(0) + largestMerge(word1.substring(1), word2);
		return word2.charAt(0) + largestMerge(word1, word2.substring(1));
	}
}
