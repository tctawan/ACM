package hw3;

import java.util.HashMap;
import java.util.Scanner;

public class Tritile {
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n != -1) {
			HashMap<String,Integer> memo = new HashMap<String,Integer>();
			int ans =tile(memo,n,n,n);
			System.out.println(ans);
			ans =0;
			n = sc.nextInt();
		}
		sc.close();
	}
	
	public static int tile(HashMap<String,Integer> memo,int t, int m , int b) {
		if(t<0 || m<0 || b<0) {
			return 0;
		}
		else if(fullyTiled(t,m,b)) {
			return 1;
		}
		
		String tmb = ""+t+m+b;
		int ans =0;
		if(memo.containsKey(tmb)) {
			return memo.get(tmb);
		}else {
			if(b>t && b>m) {
				ans = tile(memo,t,m,b-2);
			}else if(t>b && t>m) {
				ans = tile(memo,t-2,m,b);
			}else if(b<t && b<m) {
				ans = tile(memo,t-2,m-2,b)+tile(memo,t-1,m-1,b);
			}else if(t<b && t<m){
				ans = tile(memo,t,m-2,b-2)+tile(memo,t,m-1,b-1);
			}else {
			ans = tile(memo,t-1,m-1,b-2) +
			tile(memo,t-2,m-1,b-1) +
			tile(memo,t-2,m-2,b-2);
			}
			memo.put(tmb, ans);
			return ans;
		}
	}
	
	public static boolean fullyTiled(int t, int m , int b) {
		return (t==0 && m==0 && b==0 );
		}
	
	

}
