package Thurs;

import java.util.Scanner;

public class TileNorm {
	
	static int count = 0;
	
	public static void main(String[] arg) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[][] grid = new int[2][n];
		tile(grid,0);
		System.out.println(count);
		sc.close();
	}
	
	public static void tile(int[][] grid,int col) {
		
		if(finished(grid)) {
			count++;
			return;
		}
		if(col>=grid[0].length) {
			return;
		}
		else {
			fill(grid,col,1);
			tile(grid,col+1);
			remove(grid,col,1);
			
			if(col+1<grid[0].length) {
				fill(grid,col,2);
				tile(grid,col+2);
				remove(grid,col,2);
				fill(grid,col,2);
				tile(grid,col+2);
				remove(grid,col,2);
			}
		}
	}
	
	public static boolean finished(int[][] grid) {
	
		for(int[] r:grid) {
			for(int box: r) {
				if(box == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void fill(int[][] grid,int col,int nCol) {
		for(int n=0;n<nCol;n++) {
			grid[0][col+n] = 1; grid[1][col+n] = 1;
		}
	}
	
	public static void remove(int[][] grid, int col,int nCol) {
		for(int n=0;n<nCol;n++) {
			grid[0][col+n] = 0; grid[1][col+n] = 0;
		}
	}

}
