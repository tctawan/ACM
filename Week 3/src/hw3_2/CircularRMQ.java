package hw3_2;

import java.io.*;
import java.util.*;

public class CircularRMQ {
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	
	public static void main(String[] arg) {
		FastReader sc = new FastReader();
		int len = sc.nextInt();
		int[] a = new int[len];
		int pow = (int)Math.ceil(Math.log(len)/Math.log(2));
		int size = (int)Math.pow(2, pow);
		
		for(int i =0; i<len; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] segTree = crtSegTree(a,len,size);
//		System.out.print(Arrays.toString(segTree));
		
		int numInst = sc.nextInt();
		
		for(int x = 0; x<numInst; x++) {
			String[] inst = sc.nextLine().split(" ");
			int ml = Integer.parseInt(inst[0]);
			int mr = Integer.parseInt(inst[1]);
			if(inst.length == 3) {
				int inc = Integer.parseInt(inst[2]);
				if(ml> mr) {
					for(int i =ml; i<len; i++) {
						a[i]  += inc;
					}
					for(int i =0 ; i<=mr; i++) {
						a[i] += inc;
					}
				}else {
					for(int i = ml ; i<=mr ; i++) {
						a[i] += inc;
					}
				}
				segTree = crtSegTree(a,len,size);
			}else {
				int min;
				if(mr < ml) {
					min = Math.min(rmq(segTree,1,ml,len,0,size)
							,rmq(segTree,1,0,mr+1,0,size));
				}else {
					min = rmq(segTree,1,ml,mr+1,0,size);
				}
				System.out.println(min);
			}
		}
		
		
		
		
		
	}
	
	public static int rmq(int[] segT,int i,int ml,int mr, int tl, int tr) {
		if(ml == tl && mr == tr) {
			return segT[i];
		}else {
			int m =(tl+tr)/2;
			int left = Integer.MAX_VALUE;
			int right = Integer.MAX_VALUE;
			if(ml<m) {
				left = rmq(segT,i*2,ml,Math.min(mr, m),tl,m);
			}
			if(mr>m) {
				right = rmq(segT, i*2+1,Math.max(ml, m),mr,m,tr);
			}
			return Math.min(left, right);
		}
	}
	
	public static void update(int[] segT, int ml, int mr)
	
	public static int[] crtSegTree(int[] a, int len, int size) {
		int[] segTree = new int[size*2];
		int max = Integer.MIN_VALUE;
		
		for(int i =0; i<len; i++) {
			int n = a[i];
			segTree[i+size] = n;
			max = (n>max) ? n : max;
		}
		
		for(int i=size+len; i<size*2; i++) {
			segTree[i] = max;
		}
		
		for(int i = size*2-1; i>0 ; i -= 2) {
			segTree[i/2] = Math.min(segTree[i], segTree[i-1]);
		}
		
		return segTree;
	}

}
