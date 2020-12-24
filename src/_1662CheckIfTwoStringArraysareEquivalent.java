public class _1662CheckIfTwoStringArraysareEquivalent {
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder sb = new StringBuilder();
		for (String w : word1) sb.append(w);
		StringBuilder sb1 = new StringBuilder();
		for (String w : word2) sb1.append(w);
		return new String(sb).equals(new String(sb1));
	}
}
