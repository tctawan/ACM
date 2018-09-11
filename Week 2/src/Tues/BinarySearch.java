package Tues;


import java.util.Scanner;

public class BinarySearch {
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int nq = sc.nextInt();
		int[] intA = new int[size];
		for(int i =0; i<size;i++) {
			intA[i] = sc.nextInt();
		}
		
		for(int q=0;q<nq;q++) {
			System.out.println(bSearch(intA,sc.nextInt(),0,size));
		}
		sc.close();
		
		
	}
	
	public static int bSearch(int[] a, int searchNum,int lo, int hi) {
		
		if(hi-lo<=0) {
			return -1;
		}else {
			int m = (hi+lo)/2;
			int num = a[m];
			if(num == searchNum) {
				if(m!=0 && num == a[m-1]) {
					return bSearch(a,searchNum,lo,m);
				}
				return m;
			}else if(num < searchNum) {
				return bSearch(a,searchNum,m+1,hi);
			}else {
				return bSearch(a,searchNum,lo,m);
			}
		}
	}

}
