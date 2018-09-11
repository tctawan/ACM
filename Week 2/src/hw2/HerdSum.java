package hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HerdSum {
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		int p1 = 0;int p2 = 1;
		int sum = 1;
		int count =0;
//		ArrayList<int[]> a =new ArrayList<>();
		while(p2<=nc) {
			if(sum<nc) {
				p2++;
				sum += p2;
			}else {
				if(sum == nc) {
					count++;
//					int[] b = {p1,p2};
//					a.add(b);
				}
				p1++;
				sum -= p1;
			}
		}
		System.out.println(count);
//		for(int[] b: a) {
//			System.out.println(Arrays.toString(b));
//		}
		sc.close();
	}

}
