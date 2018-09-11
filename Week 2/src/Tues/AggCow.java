package Tues;
import java.util.Arrays;
import java.util.Scanner;

public class AggCow {
	
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tx=0;tx<t;tx++) {
			int l = sc.nextInt();
			int c = sc.nextInt();
			int[] pos = new int[l];
			
			for(int i=0;i<l;i++) {
				pos[i] = sc.nextInt();
			}
			Arrays.sort(pos);
			
			int[] dis = new int[l-1];
			
			for(int i=0;i<l-1; i++) {
				dis[i] = pos[i+1]-pos[i];
			}
			System.out.println(bSearchDis(dis,0,(pos[l-1]-pos[0])/(c-1),c-1));
			
		}
		sc.close();
		
	}
	
	public static int bSearchDis(int[] dist,int lo, int hi,int c) {
		
		if(hi-lo<0) {
			return 0;
		}else {
			int m = (hi+lo)/2;
			int count = count(dist,m);
			if(count < c) {
				return bSearchDis(dist,lo,m-1,c);
			}else if (count == c) {
				if(count(dist,m+1) == c) {
					return bSearchDis(dist,m+1,hi,c);
				}else {
					return m;
				}
			}else {
				return bSearchDis(dist,m+1,hi,c);
			}
			
		}
		
	}
	
	public static int count(int[] dist,int reset) {
		
		int count = 0;
		int sum =0;
		for(int d: dist) {
			sum +=d;
			if(sum>= reset) {
				count++;
				sum =0;
			}
		}
		return count;
		
	}
	
	

}
