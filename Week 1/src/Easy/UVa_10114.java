//package Easy;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class UVa_10114 {
//
//	static class Data{
//		public int nMonth;
//		public double downPayment;
//		public double price;
//		public int nDep;
//		public Data() {}
//		HashMap<Integer, Double> depreciation;	
//	}
//	
//	public static Data loadData(Scanner s) {
//		Data ret = new Data();
//		ret.nMonth = s.nextInt();
//		if(ret.nMonth < 0) return null;
//		ret.downPayment = s.nextDouble();
//		ret.price = s.nextDouble();
//		ret.nDep = s.nextInt();
//		for(int i=0; i<ret.nDep; i++) {
//			ret.depreciation.put(s.nextInt(), s.nextDouble());
//		}
//		return ret;
//	}
//	
//	public static processData(Data data) {
//		
//	}
//	
//	
//	public static void main(String[] arg) {
//		Scanner s = new Scanner(System.in);
//		Data data=loadData(s);
//		while(data!=null) {
//			processData(data);
//			data = loadData(s);
//		}
//		s.close();
//
//		
////		while(tm>0) {
////			double pay = s.nextDouble();
////			double price =  s.nextDouble();
////			int k = s.nextInt();
////			HashMap<Integer,Double> map = new HashMap<>(); 
////			
////			for(int i=0; i<k;i++) {
////				int dm = s.nextInt();
////				double depre = s.nextDouble();
////				map.put(dm, depre);
////			}
////			
////			double depre = 0;
////			double left = price;
////			double loan = price+pay;
////			for(int m=0;m<tm;m++) {
////				
////				if(map.containsKey(m)) {
////					depre = map.get(m);
////				}
////				loan = loan*(1-depre);
////				if(left<loan) {
////					if(m>1) {
////						System.out.println(m+" months");
////					}else {
////						System.out.println(m+" month");
////					}
////					break;
////				}
////				left = left-pay;
////			
////				
////				
////			}
////			tm= s.nextInt();
////		}
//		
//	}
//
//}
