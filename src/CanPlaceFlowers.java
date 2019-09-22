public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed.length == 0) return false;
		if (flowerbed.length == 1 && n == 1) return flowerbed[0] == 0;
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				if (i == 0 || i == flowerbed.length - 1) {
					count++;
				}
				count++;
			} else {
				n -= (count - 1) /2;
				count = 0;
			}
		}
		n -= (count - 1) / 2;
		return n < 1;
	}
}
