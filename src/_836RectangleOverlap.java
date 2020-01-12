public class _836RectangleOverlap {
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		if (rec1 == null || rec2 == null) return false;
		int x1 = Math.max(rec1[0], rec2[0]);
		int y1 = Math.max(rec1[1], rec2[1]);
		int x2 = Math.min(rec1[2], rec2[2]);
		int y2 = Math.min(rec1[3], rec2[3]);
		return (x1 < x2) && (y1 < y2);
	}
}
