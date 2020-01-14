public class _223RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int x1 = Math.max(A, E);
		int y1 = Math.max(B, F);
		int x2 = Math.min(C, G);
		int y2 = Math.min(D, H);
		if (x1 < x2 && y1 < y2) return Math.abs(C - A) * Math.abs(D - B) + Math.abs(E - G) * Math.abs(H - F) - Math.abs(x1 - x2) * Math.abs(y1 - y2);
		return Math.abs(C - A) * Math.abs(D - B) + Math.abs(E - G) * Math.abs(H - F);
	}
}
