package hw;

import java.util.Arrays;
import java.util.Scanner;

public class VanyaNLan {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int nl = sc.nextInt();
		int len = sc.nextInt();
		int[] pos = new int[nl];
		
		for(int l = 0;l<nl;l++) {
			pos[l] = sc.nextInt(); 
		}
		Arrays.sort(pos);
		int gaps = nl-1;
		
		if(pos[0] != 0) {
			gaps++;
		}
		if(pos[nl-1] != len) {
			gaps++;
		}
		
		double[] dist = new double[gaps];
		int posI = 0;
		
		for(int i=0; i<gaps; i++) {
			if(i == 0 && pos[0] != 0) {
				dist[i] = pos[0]; 
				continue;
			}
			if(i == gaps-1 && pos[nl-1] != len) {
				dist[i] = len-pos[nl-1];
				continue;
			}
			dist[i] = (pos[posI+1]-pos[posI])/2.0;
			posI++;
		}
		
		Arrays.sort(dist);
		System.out.print(dist[gaps-1]);
		sc.close();
		
	}

}
