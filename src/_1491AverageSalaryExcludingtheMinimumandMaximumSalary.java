public class _1491AverageSalaryExcludingtheMinimumandMaximumSalary {
	public double average(int[] salary) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int sum = 0;
		for (int x : salary) {
			min = Math.min(min, x);
			max = Math.max(max, x);
			sum += x;
		}
		return (sum - min - max) * 1.0 / (salary.length - 2);
	}
}
