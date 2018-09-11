package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Fence {
	
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
		int n = sc.nextInt();
		int[] fences = new int[n];

		
		for(int i =0; i<n;i++) {
			int h = sc.nextInt();
			fences[i] = h;
		}
		
		
		int q = sc.nextInt();
		for(int x=0; x<q;x++) {
			int lo = Integer.MAX_VALUE;
			int hi = Integer.MIN_VALUE;
			int f = sc.nextInt();
			int t = sc.nextInt();
			for(int i=f-1;i<t;i++) {
				int h = fences[i];
				if(h > hi) {
					hi =h;
				}
				if(h<lo) {
					lo = h;
				}
			}
			int w =sc.nextInt();
			System.out.println(bSearch(fences,lo,hi,w,f-1,t-1,0));
		}
	}
	
	public static int bSearch(int[] fences, int lo, int hi, int w,int f,int t,int best ) {
		if(hi-lo<0) {
			return best;
		}else {
			int rh = lo+(hi-lo)/2;
			boolean pass = check(fences,rh,w,f,t);
			if(pass) {
				if(rh > best) {
					best = rh;
				}
				return bSearch(fences,rh+1,hi,w,f,t,best);
				
			}else {
				return bSearch(fences,lo,rh-1,w,f,t,best);
			}
		}
	}
	
	public static boolean check(int[] fences,int rh,int w, int from , int to) {
		int c = 0;
		for(int i=from; i<=to;i++) {
			int h = fences[i];
			if(h>=rh) {
				c++;
			}else {
				c=0;
			}
			if(c>=w) {
				return true;
			}
		}
		return false;
	}

}
