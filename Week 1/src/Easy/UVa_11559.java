package Easy;

import java.util.Scanner;

public class UVa_11559 {
	
	
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int parti = s.nextInt();
			int bud = s.nextInt();
			int hotel = s.nextInt();
			int week = s.nextInt();
			int minPrice = Integer.MAX_VALUE;
			for(int h=0; h<hotel; h++ ) {
				int pricePerP = s.nextInt();
				int price = pricePerP*parti;
				
				for(int w=0; w<week; w++) {
					int bed = s.nextInt();
					if(bed>=parti) {
						if(price<minPrice && price<=bud) {
							minPrice = price;
						}
					}
						
				}
				
			}
			if(minPrice == Integer.MAX_VALUE) {
				System.out.println("stay home");
			}else {
				System.out.println(minPrice);
			}
			
		}
		s.close();
	}

}
