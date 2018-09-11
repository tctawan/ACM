package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class PostOffice {
	
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		int nh = sc.nextInt();
		int np = sc.nextInt();
		int[] dist = new int[nh-1]; 
		
		int s = sc.nextInt();
		for(int h = 0; h<nh-1; h++) {
			int l = sc.nextInt();
			dist[h] = l - s;
			s = l;
			
		}
		
		int[][] table = new int[nh][nh];
		for(int f =0; f<nh-1; f++) {
			int sum = 0;
			for(int t = f+1;t<nh; t++) {
				sum += dist[t-1];
				table[f][t] = sum;
				table[t][f] = sum;
			}
		}
		System.out.println(Arrays.deepToString(table));
		sc.close();
	}
	
	public static int findMinDis(int h, int f, int t, int[][] table, int np) {
		if(t-f == 0) {
			return 0;
		}else {
			findMinDis(h,f+1,t,table,np);
			findMinDis(h-1, h-1,f,table,np);
		}
		
		
	}

}
