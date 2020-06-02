public class _223RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int x_left = Math.max(A, E);
		int y_left = Math.max(B, F);
		int x_right = Math.min(C, G);
		int y_right = Math.min(D, H);

		if (x_left <= x_right && y_left <= y_right) return (C - A) * (D - B) + (G - E) * (H - F) - (x_right - x_left) * (y_right - y_left);
		return (C - A) * (D - B) + (G - E) * (H - F);
	}
}
