package Thurs;

import java.util.Scanner;

public class TileL {
	
	static int count = 0;
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tile(0,0,n);
		System.out.println(count);
		sc.close();
		
	}
	
	public static void tile(int top, int bot, int n) {
		if(top>n || bot >n) {
			return;
		}
		if(finished(top,bot,n)) {
			count++;
			return;
		}else if(top>bot) {
			tile(top+1,bot+2,n);
			tile(top,bot+2,n);
		}else if(bot>top) {
			tile(top+2,bot+1,n);
			tile(top+2,bot,n);
		}
		else {
			tile(top+1,bot+1,n);
			tile(top+2,bot+2,n);
			tile(top+2,bot+2,n);
			tile(top+1,bot+2,n);
			tile(top+2,bot+1,n);
			
			
		}
	}
	
	public static boolean finished(int top, int bot,int n) {
		return(top == n && bot == n);
	}
}
