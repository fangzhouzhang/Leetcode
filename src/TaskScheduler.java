public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		if (tasks.length == 0) return 0;
		int[] map = new int[26];
		for (char t : tasks) map[t - 'A']++;
		int max = 0;
		for (int fre : map) max = Math.max(max, fre);
		int maxNum = 0;
		for (int fre : map) {
			if (fre == max) maxNum++;
		}
		return Math.max(tasks.length, (max - 1) * (n + 1) + maxNum);
	}
}
