import java.util.*;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> res = new ArrayList<>();
		Map<String, Integer> email_id = new HashMap<>();
		Map<String, String> email_name = new HashMap<>();
		int id = 0;
		UnionFind uf = new UnionFind();
		for (List<String> account : accounts) {
			String name = "";
			for (int i = 0; i < account.size(); i++) {
				if (i == 0) {
					name = account.get(0);
				} else if (i == 1) {
					uf.construct(id);
					if (!email_id.containsKey(account.get(i))) {
						email_id.put(account.get(i), id++);
					}
					if (!email_name.containsKey(account.get(i))) {
						email_name.put(account.get(i), name);
					}
				} else if (i >= 2) {
					if (!email_id.containsKey(account.get(i))) {
						uf.construct(id);
						uf.union(email_id.get(account.get(1)), id);
						email_id.put(account.get(i), id++);
					} else {
						uf.union(email_id.get(account.get(1)), email_id.get(account.get(i)));
					}
					if (!email_name.containsKey(account.get(i))) {
						email_name.put(account.get(i), name);
					}
				}
			}
		}
		Map<Integer, List<String>> vals = new HashMap<>();
		for (Map.Entry<String, Integer> e : email_id.entrySet()) {
			int dad = uf.root(e.getValue());
			List<String> list = vals.getOrDefault(dad, new ArrayList<String>());
			list.add(e.getKey());
			vals.put(dad, list);
		}

		for (Map.Entry<Integer, List<String>> e : vals.entrySet()) {
			List<String> emails = e.getValue();
			Collections.sort(emails);
			emails.add(0, email_name.get(emails.get(0)));
			res.add(emails);
		}
		return res;
	}

	private class UnionFind {
		//最终parent[index]不一定是直达根节点，如果一个点有爷爷，此时指向的可能是爸爸
		private int[] parent;//store index i's parent
		private int[] size;//decide who is dad bewteen i and j index
		public UnionFind() {
			parent = new int[10001];
			Arrays.fill(parent, -1);
			size = new int[10001];
		}

		private void construct(int idx) {
			if (parent[idx] == -1) {
				parent[idx] = idx;
				size[idx] = 1;
			}
		}

		private int root(int idx) {//find parent
			int cur = idx;
			while (parent[cur] != cur) {
				parent[cur] = parent[parent[cur]];
				cur = parent[cur];
			}
			parent[idx] = cur;
			return cur;
		}

		private void union(int a, int b) {
			int ra = root(a);
			int rb = root(b);
			if (ra == rb) return;//already have same dad
			if (size[ra] >= size[rb]) {
				//a is dad
				parent[rb] = ra;
				size[ra] += size[rb];
			} else {
				parent[ra] = rb;
				size[rb] += size[ra];
			}
		}
	}
}
