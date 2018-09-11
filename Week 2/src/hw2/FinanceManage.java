package hw2;

import java.util.Scanner;

public class FinanceManage {
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		for(int i=0;i<12;i++) {
			double cb = sc.nextDouble();
			sum += cb;
		}
		double avg  = sum/12;
		System.out.printf("$%.2f",avg);
		sc.close();
	}
	
}
