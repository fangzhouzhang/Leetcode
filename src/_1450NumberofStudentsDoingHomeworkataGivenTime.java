public class _1450NumberofStudentsDoingHomeworkataGivenTime {
	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int res = 0;
		int n = startTime.length;
		for (int i = 0; i < n; i++) {
			if (startTime[i] <= queryTime && queryTime <= endTime[i]) res++;
		}
		return res;
	}
}
