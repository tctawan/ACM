package Medium;

import java.util.Scanner;

public class UVa_00573 {
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
		while(h!=0) {
			double up = s.nextDouble();
			double down = s.nextDouble();
			double f = up*(s.nextInt()/100.0);
			int day =0;
			double dis = 0;
			while(dis>=0) {
				day++;
				dis += up;
				if(dis>h) {
					System.out.println("success on day " + day);
					break;
				}
				dis -=down;
				up -= f;
				if(up<0) {
					up = 0;
				}
			}
			if(dis<0) {
				System.out.println("failure on day " + day);
			}
			h=s.nextInt();
		}
		s.close();
	}

}
