import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _690EmployeeImportance {
	private Map<Integer, Employee> map;
	private Set<Integer> set;
	public int getImportance(List<Employee> employees, int id) {
		map = new HashMap<>();
		for (int i = 0; i < employees.size(); i++) {
			map.put(employees.get(i).id, employees.get(i));
		}
		return dfs(id);
	}

	private int dfs(int id) {
		int sum = 0;
		for (int w : map.get(id).subordinates) {
			sum += dfs(w);
		}
		sum += map.get(id).importance;
		return sum;
	}

	private class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	};
}
