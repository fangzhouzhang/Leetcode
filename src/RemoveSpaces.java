public class RemoveSpaces {
	/**
	 *
	 * @param input
	 * @return
	 * time: o(n) space: o(n)
	 */
	public String removeSpaces(String input) {
		// Write your solution here
		char[] arr = input.toCharArray();
		int slow = 0;
		int fast = 0;
		boolean firstWord = true;
		while (fast < arr.length) {
			while (fast < arr.length && arr[fast] == ' ') {
				fast++;
			}
			if (firstWord) {
				firstWord = false;
				while (fast < arr.length && arr[fast] != ' ') {
					arr[slow++] = arr[fast++];
				}
			} else if (fast < arr.length && firstWord == false) {
				arr[slow++] = ' ';
				while (fast < arr.length && arr[fast] != ' ') {
					arr[slow++] = arr[fast++];
				}
			}
		}
		return new String(arr, 0, slow);
	}
}
