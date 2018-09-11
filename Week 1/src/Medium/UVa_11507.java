package Medium;

import java.util.Scanner;

public class UVa_11507 {
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int l = sc.nextInt();
			String currDir = "+x";
			
			if(l== 0) {
				break;
			}
			for(int i=1;i<l;i++) {
				String nextB = sc.next();
				currDir = bends(currDir,nextB);
			}
			System.out.println(currDir);
		}
		sc.close();
	}
	
	public static String bends(String currDir, String nextB) {
		if(nextB.equals("No")) {
			return currDir;
		}
		else if(currDir.equals("-y")) {
			if(nextB.equals("-y")) {
				return "-x";
			}else if (nextB.equals("+y")) {
				return "+x";
			}
		}else if(currDir.equals("+y")) {
			if(nextB.equals("-y")) {
				return "+x";
			}else if (nextB.equals("+y")) {
				return "-x";
			}
		}else if(currDir.equals("-z")) {
			if(nextB.equals("-z")) {
				return "-x";
			}else if (nextB.equals("+z")) {
				return "+x";
			}
		}else if(currDir.equals("+z")) {
			if(nextB.equals("-z")) {
				return "+x";
			}else if (nextB.equals("+z")) {
				return "-x";
			}
		}else if(currDir.equals("+x")) {
			if(nextB.equals("-y")) {
				return "-y";
			}else if (nextB.equals("+y")) {
				return "+y";
			}else if(nextB.equals("+z")) {
				return "+z";
			}else {
				return "-z";
			}
		}else {
			if(nextB.equals("-y")) {
				return "+y";
			}else if (nextB.equals("+y")) {
				return "-y";
			}else if(nextB.equals("+z")) {
				return "+z";
			}else {
				return "-z";
			}
			
		}
		return currDir ;
	}

}
