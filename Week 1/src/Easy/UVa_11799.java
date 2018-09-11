package Easy;

import java.util.Scanner;

public class UVa_11799 {
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		int numTc = s.nextInt();
		for(int i =0; i<numTc; i++) {
			int max = -1;
			int numC = s.nextInt();
			for(int c=0; c<numC;c++) {
				int speed = s.nextInt();
				if(speed>max) {
					max = speed;
				}
			}
			System.out.println("Case "+(i+1)+": "+max);
		}
		s.close();
	}

}
