package hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VertHist {
	
	public static void main(String[] arg) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int[] count 	= new int[26];
		int max =0;
		for(int r =0;r<4;r++) {
			String[] a = sc.readLine().split(" ");
			for(String w: a) {
				for(int i =0;i<w.length();i++) {
					char c = w.charAt(i);
					int uniC = (int)c;
					int x = uniC-65;
					if(x>=0 && x<=26) {
						count[x]++;
						if(count[x]>max) {
							max = count[x];
						}
					}
				}
			}
			
		}
		while(max != 0) {
			for(int i=0;i<26;i++) {
				if(count[i] == max) {
					System.out.print("*");
					count[i]--;
				}else {
					System.out.print(" ");
				}
				if(i<25) {
					System.out.print(" ");
				}else {
					System.out.println();
				}
			}
			max--;
		}
		for(int n=0;n<26;n++) {
			char c = (char)(n+65);
			System.out.print(Character.toString(c));
			if(n<25) {
				System.out.print(" ");
			}
		}
		
		sc.close();
	}

}
