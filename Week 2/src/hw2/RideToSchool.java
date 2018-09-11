package hw2;

import java.util.Scanner;

public class RideToSchool {
	
	public static void main(String[] arg) {
		Scanner sc =new Scanner(System.in);
		while(true) {
			int nb = sc.nextInt();
			if(nb == 0) {
				break;
			}
			int minT = Integer.MAX_VALUE;
			for(int b=0;b<nb;b++) {
				int s = sc.nextInt(); int t = sc.nextInt();
				if(t>-1) {
					double endtime = Math.ceil((4.5/s*3600 + t));
//					System.out.println(endtime);
					if(endtime<minT) {
						minT = (int)endtime;
					}
				}
				
			}
			System.out.println(minT);
		}
		sc.close();
	}

}
