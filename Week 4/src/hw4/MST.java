package hw4;
import java.util.*;

public class MST {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int v, int u , int w) {
			from  = v;
			to = u; weight = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	public static void main(String[] arg) {

		Scanner sc = new Scanner(System.in);
		int nv = sc.nextInt();
		int ne = sc.nextInt();
		Edge[] sorted = new Edge[ne];
		Edge[] ori = new Edge[ne];
		HashSet<Edge> used = new HashSet<>();
		
		for(int e =0; e<ne; e++) {
			int v = sc.nextInt();
			int u = sc.nextInt();
			int w = sc.nextInt();
			sorted[e] = new Edge(v,u,w);
			ori[e] = new Edge(v,u,w);
		}
		Arrays.sort(sorted);
		
		int[] id = new int[nv+1];
		int[] size = new int[nv+1];
		
		for(int i=1; i<id.length; i++) {
			id[i] = i;
			size[i] = 1;
		}
		long sum = mst(id,size,sorted,used,0);
		long mstSum = sum;
		for(Edge e : ori) {
			if(!used.contains(e)) {
				
				
				
				System.out.println(sum);
			}else {
				System.out.println(mstSum);
			}
		}
		sc.close();
		
	}
	
	public static int searchMaxW(int v, int u,HashMap<Integer,Set<int[]>> g) {
		Stack<Integer> nodes = new Stack<>();
		Stack<Integer> weights = new Stack<>();
		nodes.push(v);
		
		while(!nodes.empty()) {
			int n = nodes.pop();
			
			for(int[] w : g.get(n)) {
				
			}
		}
	}
	
	public static void union(int[] id, int[] size ,int v, int u) {
		
		int pv = find(id,v);
		int pu = find(id,u);
		if(pv != pu) {
			if(size[pv] > size[pu]) {
				size[pv] += size[pu];
				id[pu] = id[pv];
			}else {
				size[pu] += size[pv];
				id[pv] = id[pu];
			}
		}
		
	}
	
	public static int find(int[] id , int v) {
		
		int root = id[v];
		while(root != id[root]) {
			root = id[root];
		}
		
		while(v != root) {
			int next = id[v];
			id[v] = root;
			v= next;
		}
		
		return root;
		
	}
	
	public static long mst(int[] id ,int[] size, Edge[] sorted,HashSet<Edge> used, long sum) {
		for(Edge e: sorted) {
			int v = e.from;
			int u = e.to;
			if(find(id,v) != find(id,u)) {
				union(id,size,v,u);
				sum += e.weight;
				used.add(e);
			}
		}
		return sum;
	}

}
