package SuperEasy;
import java.util.Scanner;

public class UVa_11172 {
	
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i =0 ; i<n; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			if(x>y) {
				System.out.println('>');
			}else if (x<y) {
				System.out.println('<');
			}else {
				System.out.println('=');
			}
		}
		s.close();
		
	}
}
