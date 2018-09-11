package hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Megacity {
	
	public static void main(String[] arg) {
		
		Scanner sc =new Scanner(System.in);
		int nt = sc.nextInt();
		int currP = sc.nextInt();
		int maxP = currP;
		int left = 1000000 - currP;
		double[][] cities = new double[nt][2];
		double ans;
		//check if the total sum reach up to 1mill
		for(int t=0;t<nt;t++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			int pop = sc.nextInt();
			maxP += pop;
			double r = Math.sqrt(x*x+y*y);
			cities[t][0] = r; cities[t][1] = pop;
		}
		if(maxP< 1000000) {
			ans = -1;
		}else {
			//then we sort according to radius
			Arrays.sort(cities, new Comparator<double[]>() {
	
				@Override
				public int compare(double[] o1, double[] o2) {
					Double d1 = o1[0];
					Double d2 = o2[0];
					return d1.compareTo(d2);
				}
				
			});
	//		System.out.println(Arrays.deepToString(cities));
			
			//change all population size to added-pop
			double currRad = 0;
			double rSum = 0;
			for(int i =0;i<cities.length;i++) {
				double nRad = cities[i][0];
				if(nRad != currRad) {
					currRad = nRad;
				}
				rSum += cities[i][1];
				cities[i][1] = rSum;
			}
	//		System.out.println(Arrays.deepToString(cities));
			
			// then do search(binary or linear/?) till sum >= mill
			ans = bSearch(cities,0,cities.length,left,Double.MAX_VALUE);
		}
		System.out.println(ans);
		sc.close();
	}
	
	public static double bSearch(double[][] cities,int lo, int hi,int left,double bR) {
		if(hi-lo<=0) {
			return bR;
		}else {
			int m = lo+(hi-lo)/2;
			double pop = cities[m][1];
			if(left-pop==0) {
				return cities[m][0];
			}else if(left-pop<0) {
				if(cities[m][0]<bR) {
					bR = cities[m][0];
				}
				return bSearch(cities,lo,m,left,bR);
			}else {
				return bSearch(cities,m+1,hi,left,bR);
			}
		}
	}

}
