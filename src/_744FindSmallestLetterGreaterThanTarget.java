public class _744FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int l = 0, r = letters.length - 1;
		while (l < r) {
			int mid = l + r >> 1;
			if (letters[mid] <= target) l = mid + 1;
			else r = mid;
		}
		if (letters[l] <= target) return letters[0];
		return letters[l];
	}
}
