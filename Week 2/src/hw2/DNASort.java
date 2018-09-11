package hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class DNASort {
	
	public static void main(String[] arg) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l_tc = bf.readLine().split(" ");
		int tc= Integer.parseInt(l_tc[1]);
		String[][] sorted = new String[tc][2];
		for(int t=0;t<tc;t++) {
			String dna = bf.readLine();
			String[] a = dna.split("");
			int ooo = 0;
			for(int c= 0;c<dna.length();c++) {
				String s = a[c];
				String checker = "X";
				if(s.equals("T")) {
					checker = "CGA";
				}else if(s.equals("G")) {
					checker = "CA";
				}else if(s.equals("C")) {
					checker = "A";
				}
				for(int i = c+1; i<a.length;i++) {
					String s2 = a[i];
					if(checker.contains(s2)){
						ooo++;
					}
				}
			}
			sorted[t][0] = Integer.toString(ooo); sorted[t][1] = dna;
		}
		
		Arrays.sort(sorted, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				int o1Num = Integer.parseInt(o1[0]);
				int o2Num = Integer.parseInt(o2[0]);
				return o1Num-o2Num;
			}
			
		});
		
		for(String[] sa : sorted) {
			System.out.println(sa[1]);
		}
		bf.close();
	}

}
