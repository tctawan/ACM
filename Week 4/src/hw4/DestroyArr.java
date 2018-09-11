package hw4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class DestroyArr {
	
	public static void main (String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] id = new int[n+1];
		long[] sum = new long[n+1];
		int[] size = new int[n+1];
		int[] instruct = new int[n];
		HashSet<Integer> visited = new HashSet<>();
		
		for(int i =1 ; i<n+1; i++) {
			long x = sc.nextLong();
			sum[i] = x; 
			size[i] = 1;
			id[i] = i;
		}
		
		for(int i=0 ; i<n ; i++) {
			instruct[i] = sc.nextInt();
		}
		
		long max = 0;
		long[] ans = new long[n];
		for(int i=n-1; i>0; i--) {
			int y = instruct[i];
			if(visited.contains(y+1)) {
				long s = union(id,size,sum,y,y+1);
				if(s>max) {
					max = s;
				}
			}
			if(visited.contains(y-1)) {
				long s =union(id,size,sum,y,y-1);
				if(s>max) {
					max = s;
				}
			}
			if(!visited.contains(y+1)&& !visited.contains(y-1)) {
				id[y] = y;
				long s = sum[y];
				if(s>max) {
					max = s;
				}
			}
			ans[i-1] = max;
			visited.add(y);
		}
		for(int i =0 ; i<ans.length; i++) {
			long a = ans[i];
			System.out.println(a);
		}
		System.out.println(Arrays.toString(ans));
		sc.close();
	}
	
	public static long union(int[] id,int[] size,long[] sum,int v, int u) {
		int pv = find(id,size,v);
		int pu = find(id,size,u);
		
		if(pv != pu) {
			if(size[pv] > size[pu]) {
				size[pv] += size[pu];
				id[pu] = id[pv];
				sum[pv] += sum[pu];
				return sum[pv];
			}else {
				size[pu] += size[pv];
				id[pv] = id[pu];
				sum[pu] += sum[pv];
			}
		}
		return sum[pu];
		
	}
	
	public static int find(int[] id, int[] size, int v) {
		
		int root = v;
		while(id[root] != root) { 
			root = id[root];
		}
		
		while( v != root) {
			int next = id[v];
			id[v] = root;
			v = next;
		}
		return root;
		
	}

}
