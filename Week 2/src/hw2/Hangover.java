package hw2;

import java.util.Scanner;

public class Hangover {
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			double l = sc.nextDouble();
			if(l == 0) {
				break;
			}
			int nc = 0;
			double n = 2;
			while(l>0) {
				l -= 1/n;
				n++;
				nc++;
			}
			System.out.println(nc + " card(s)");
		}
		sc.close();
	}

}
