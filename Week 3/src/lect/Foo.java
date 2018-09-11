package lect;

import java.util.Arrays;

public class Foo {
	
	int[][] tree;
	int[] ps;
	
	public Foo(int[] a) {
		ps = new int[a.length+1];
		ps[0] = 0;
		
		double power = Math.ceil(Math.log(a.length)/Math.log(2));
		int treeLen = (int)Math.pow(2, power);
		
		tree = new int[2][treeLen];
		int[] temp = new int[treeLen];
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<ps.length;i++) {
			ps[i] = a[i-1]+ps[i-1];
			tree[0][i-1] = a[i-1];
			temp[i-1] = a[i-1];
			if(a[i-1]<min) {
				min = a[i-1];
			}
		}
		
		for(int i = a.length;i<treeLen;i++) {
			tree[0][i] = min;
			temp[i] = min;
		}
		
		int l = treeLen;
		
		
		while(l != 0) {
			int j =0;
			for(int i = l/2;i<l;i++) {
				tree[1][i] = Math.max(temp[j], temp[j+1]);
				temp[j/2] = tree[1][i];
				j +=2;
			}
			l = l/2;
		}
	}
	
	public int rangeSum(int i, int j) {
		
		return ps[j]-ps[i];	
	}
	
	public void update(int i, int n) {
		
	}
	
	public int rangeMax(int ml, int mr) {
		return rmHelper(1,ml,mr,0,tree[1].length);
	}
	
	public int rmHelper(int i,int ml,int mr,int tl,int tr) {
		if(tr-tl == 1) {
			return tree[0][tl];
		}
		if(ml == tl && mr == tr ) {
			return tree[1][i];
		}else {
			int m = (tl+tr)/2;
			int l = Integer.MIN_VALUE;
			int r = Integer.MIN_VALUE;
			if(ml<m) {
				if(mr>m) {
					l = rmHelper(i*2,ml,m,tl,m);
					r = rmHelper(i*2+1,m,mr,m,tr);
				}else {
					l = rmHelper(i*2,ml,mr,tl,m);
				}
			}else {
				r = rmHelper(i*2+1,ml,mr,m,tr);
			}
			return Math.max(l, r);
		}
	}
	
	public static void main(String[] arg) {
		int[] a = {3,1,5,4,200,7,9,10,20};
		Foo f = new Foo(a);
		System.out.println(Arrays.deepToString(f.tree));
//		System.out.println(f.rangeSum(3,5));
		System.out.print(f.rangeMax(4, 7));
	}

}
