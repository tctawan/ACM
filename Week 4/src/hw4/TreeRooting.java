package hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TreeRooting {
	
	static class DAG{
		
		Map<Integer, Set<Integer>> adjTable;
		
		public DAG() {
			adjTable = new HashMap<>();
		}
		
		public void addEdge(int u, int v) {
			addVertex(u);
			addVertex(v);
			adjTable.get(u).add(v);
		}
		
		public void addVertex(int v) {
			if(!adjTable.containsKey(v)) {
				adjTable.put(v, new HashSet<>());
			}
		}
		
		
	}
	
	static class UDG{
		
		Map<Integer, Set<Integer>> adjTable;
		
		public UDG() {
			adjTable = new HashMap<>();
		}
		
		public void addEdge(int u, int v) {
			addVertex(u);
			addVertex(v);
			adjTable.get(u).add(v);
			adjTable.get(v).add(u);
		}
		
		public void addVertex(int v) {
			if(!adjTable.containsKey(v)) {
				adjTable.put(v, new HashSet<>());
			}
		}
		
		public Iterable<Integer> adj(int v){
			return adjTable.get(v);
		}
		
	}
	
	public static DAG rooting(UDG g, int v){
		
		Set<Integer> visited = new HashSet<>();
		Set<Integer> visited2 = new HashSet<>();
		DAG newG = new DAG();
		dfs(g,v,-1,visited,newG);
		
		DAG newG2 = nonRecursDfs(g,v,visited2);
		System.out.println("non-re : "  +newG2.adjTable );
		return newG;
	}
	
	public static void dfs(UDG g, Integer v,Integer p, Set<Integer> visited, DAG newG) {
		if(!visited.contains(v)) {
			visited.add(v);
			newG.addEdge(v, p);
			for(Integer u: g.adj(v) ) {
				dfs(g,u,v,visited,newG);
			}
		}
		
	}
	
	public static DAG nonRecursDfs(UDG g, Integer v, Set<Integer> visited) {
		
		DAG newG = new DAG();
		Stack<Integer> s = new Stack<>();
		HashMap<Integer,Integer> parent = new HashMap<>();
		s.push(v);
		parent.put(v, -1);
		while(!s.isEmpty()) {
			int w = s.pop();
			visited.add(w);
			int p = parent.get(w);
			newG.addEdge(w, p);
			
			for(int u: g.adj(w)) {
				if(!visited.contains(u)) {
					s.push(u);
					parent.put(u, w);
				}
			}
				
		}
		
		return newG;
		
		
	}
	
	public static void main(String[] arg) {
		
		UDG udg = new UDG();
		udg.addEdge(1, 2);udg.addEdge(3, 2);udg.addEdge(4, 3);udg.addEdge(4, 7);
		udg.addEdge(7, 8);udg.addEdge(7, 9);
		DAG dag = rooting(udg,8);
//		System.out.println(udg.adjTable);
		System.out.println(dag.adjTable);
		
	}

}
