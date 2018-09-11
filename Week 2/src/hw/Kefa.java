package hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kefa {
	
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		
		Integer[][] friends = new Integer[n][2]; 
		for(int i=0; i<n;i++) {
			friends[i][0] = sc.nextInt();
			friends[i][1] = sc.nextInt();
		}
		
		Arrays.sort(friends, new Comparator<Integer[]>() {	

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0]-o2[0];
			}
		});
//		System.out.println(Arrays.deepToString(friends));
		long maxFF = friends[0][1];
		long currFF = maxFF;
		int p1 =1;
		int p2 =0;
		int diff =0;
		while(p1 < n) {
			int richest = friends[p1][0];
			int poorest = friends[p2][0];
			long FF = friends[p1][1];
			diff = richest-poorest;
			while(diff >= d) {
				currFF -= friends[p2][1];
				p2++;
				poorest = friends[p2][0];
				richest = friends[p1][0];
				diff = richest-poorest;
			}
			currFF += FF;
			if(currFF > maxFF) {
				maxFF = currFF;
			}
			p1++;
		}
		System.out.println(maxFF);
		sc.close();
		
		
		
	}

}
