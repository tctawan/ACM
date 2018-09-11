package SuperEasy;
import java.util.Scanner;

public class UVa_11498 {
	
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		while(tc != 0) {
			int dx = s.nextInt();
			int dy = s.nextInt();
			for(int q = 0; q<tc; q++) {
				int hx = s.nextInt();
				int hy = s.nextInt();
				if(hx>dx && hy>dy) {
					System.out.println("NE");
				}else if(hx> dx && hy<dy) {
					System.out.println("SE");
				}else if(hx<dx && hy<dy) {
					System.out.println("SO");
				}else if(hx<dx && hy>dy) {
					System.out.println("NO");
				}else {
					System.out.println("divisa");
				}
			}
			tc = s.nextInt();
			
		}
		s.close();
		
	}

}
