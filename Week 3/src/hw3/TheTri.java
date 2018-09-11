package hw3;

import java.util.Scanner;

public class TheTri {
	
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int[] top = {sc.nextInt()};
		int[] bot = top;
		
		for(int lvl =2; lvl<=d ; lvl++ ) {
			bot = new int[lvl];
			
			for(int i =0;i<bot.length; i++) {
				if(i ==0) {
					bot[i] = sc.nextInt()+ top[0];
				}else if(i== bot.length-1) {
					bot[i] = sc.nextInt() + top[i-1];
				}
				else {
					int n = Math.max(top[i], top[i-1]);
					bot[i] =  n+sc.nextInt();
				}
			}
			top = bot;
		}
		int max = Integer.MIN_VALUE;
		for(int sum: bot) {
			if(sum>max) {
				max = sum;
			}
		}
		System.out.println(max);
		sc.close();
	}

}
