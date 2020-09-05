public class _1274NumberofShipsinaRectangle {
	public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
		int x1 = bottomLeft[0], y1 = bottomLeft[1], x2 = topRight[0], y2 = topRight[1];
		if (x1 > x2 || y1 > y2 || !sea.hasShips(topRight, bottomLeft)) return 0;
		if (x1 == x2 && y1 == y2) return 1;
		int x3 = (x1 + x2) / 2, y3 = (y1 + y2) / 2;
		return countShips(sea, new int[]{x3, y3}, new int[]{x1, y1}) +
				countShips(sea, new int[]{x2, y3}, new int[]{x3 + 1, y1}) +
				countShips(sea, new int[]{x3, y2}, new int[]{x1, y3 + 1}) +
				countShips(sea, new int[]{x2, y2}, new int[]{x3 + 1, y3 + 1});
	}

	private class Sea {
		boolean hasShips(int[] topRight, int[] bottomLeft) {
			return false;
		}
	}
}
