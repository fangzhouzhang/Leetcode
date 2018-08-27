import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
	/**
	 * @param input input string
	 * @param t   target string
	 * @return
	 * time: o(n) space: o(n)
	 */
	public String remove(String input, String t) {
		// Write your solution here
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			set.add(t.charAt(i));
		}
		char[] arr = input.toCharArray();
		int slow = 0;
		int fast = 0;
		while (fast < arr.length) {
			while (fast < arr.length && !set.contains(arr[slow])) {
				slow++;
				fast++;
			}
			while (fast < arr.length && set.contains(arr[fast])) {
				fast++;
			}
			if (fast < arr.length) {
				swap(arr, fast++, slow++);
			}
		}
		return new String(arr,0, slow);
	}
	public void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
