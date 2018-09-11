package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10141 {
	
	public static void main(String[] arg) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] rp = bf.readLine().split(" ");
		int nr= Integer.parseInt(rp[0]); int np = Integer.parseInt(rp[1]);
		int RFP = 1;
		
		while(nr != 0) {
			String currB = null;
			double currPrice = Double.MAX_VALUE;
			int currRMet = 0;
			
			for(int r=0; r<nr;r++) {
				 bf.readLine();
			}
			
			for(int p =0;p<np;p++) {
				
				String brand = bf.readLine();
				String[] price_rMet = bf.readLine().split(" ");
				double price = Double.parseDouble(price_rMet[0]);
				int nrMet = Integer.parseInt(price_rMet[1]);
				if(nrMet == currRMet) {
					if(price < currPrice) {
						currB = brand;
						currPrice = price;
					}
				}else if(nrMet> currRMet){
					currB = brand;
					currPrice = price;
					currRMet = nrMet;
				}
				
				for(int rm =0;rm<nrMet;rm++) {
					bf.readLine();
				}
				
			}
			
			System.out.println("RFP #"+ RFP);
			System.out.println(currB);
			
			rp = bf.readLine().split(" ");
			nr= Integer.parseInt(rp[0]);np = Integer.parseInt(rp[1]);
			if(nr != 0) {
				System.out.println();
				RFP++;
			}
		}
	}

}
