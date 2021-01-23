public class _1603DesignParkingSystem {
	class ParkingSystem {
		int big = 0;
		int medium = 0;
		int small = 0;

		public ParkingSystem(int big, int medium, int small) {
			this.big = big;
			this.medium = medium;
			this.small = small;
		}

		public boolean addCar(int carType) {
			if (carType == 3 && this.small > 0) {
				this.small--;
				return true;
			} else if (carType == 2 && this.medium > 0) {
				this.medium--;
				return true;
			} else if (carType == 1 && this.big > 0) {
				this.big--;
				return true;
			} else return false;
		}
	}

}
