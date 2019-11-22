import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _252MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, new StartComparator());
		List<Integer> start = new ArrayList<>();
		for (int[] i : intervals) {
			start.add(i[0]);
		}
		Arrays.sort(intervals, new EndComparator());
		List<Integer> end = new ArrayList<>();
		for (int[] i : intervals) {
			end.add(i[1]);
		}
		int startIdx = 0, endIdx = 0;
		int rooms = 0;
		while (startIdx < intervals.length && endIdx < intervals.length) {
			if (start.get(startIdx) < end.get(endIdx)) {
				rooms++;
				startIdx++;
			} else {
				rooms--;
				endIdx++;
			}
			if (rooms > 1) {
				return false;
			}
		}
		return true;
	}

	private class StartComparator implements Comparator<int[]> {
		public int compare(int[] i1, int[] i2) {
			return i1[0] - i2[0];
		}
	}

	private class EndComparator implements Comparator<int[]> {
		public int compare(int[] i1, int[] i2) {
			return i1[1] - i2[1];
		}
	}
}
