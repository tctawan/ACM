package SuperEasy;
import java.util.Arrays;
import java.util.Scanner;

public class UVa_11727 {
	
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int c = 1;
		for(int q=0; q<t; q++) {
			int[] a = new int[3];
			for(int i=0;i<3; i++) {
				a[i] = s.nextInt();
			}
			Arrays.sort(a);
			System.out.println("Case " + c +": " + a[1]);
			c++;
		}
		
		s.close();
	}

}
