package Thurs;

public class Ticktacto {
	static int endings = 0;
	
	public static void main(String[] arg) {
		char[][] checkBoard = new char[3][3];
		
	}
	
	public static void count(char[][] checkBoard) {
		
	if(isDone(checkBoard)) {
		endings++;
		return;
		
	}else {
		
		
	}
		
	}
	
	public static boolean isFilled(char[][] checkBoard) {
		
		for(char[] row: checkBoard) {
			for(char box : row) {
				if(box != 'x' || box!= 'o') {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static boolean isDone(char[][] checkBoard) {
		
		if(checkHorizon(checkBoard)== true) {
			return true;
		}else if(checkVert(checkBoard) == true) {
			return true;
		}else if(checkDiagTL(checkBoard) == true) {
			return true;
		}else if(checkDiagTR(checkBoard) == true) {
			return true;
		}else if(isFilled(checkBoard) == true) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean checkHorizon(char[][] checkBoard) {
		for(int row =0;row<3;row++) {
			char player = checkBoard[row][0];
			if(player != 'o' || player != 'x') {
				continue;
			}
			for(int col =1;col<3;col++) {
				if(checkBoard[row][col] != player ) {
					break;
				}else {
					if(col == 2) {
						return true;
					}
				}
				
			}
		}
		return false;
	}
	
	public static boolean checkVert(char[][] checkBoard) {
		for(int col =0;col<3;col++) {
			char player = checkBoard[0][col];
			if(player != 'o' || player != 'x') {
				continue;
			}
			for(int row =1;row<3;row++) {
				if(checkBoard[row][col] != player ) {
					break;
				}else {
					if(row == 2) {
						return true;
					}
				}
				
			}
		}
		return false;
	}
	
	public static boolean checkDiagTL(char[][] checkBoard) {
		char player = checkBoard[0][0];
		if(player != 'o' || player != 'x') {
			return false;
		}
		for(int i =1;i<=2;i++) {
			if(player != checkBoard[i][i]) {
				return false;
			}
			
		}
		return true;
	}
	
	public static boolean checkDiagTR(char[][] checkBoard) {
		char player = checkBoard[2][2];
		if(player != 'o' || player != 'x') {
			return false;
		}
		for(int i =1;i>=0;i--) {
			if(player != checkBoard[i][i]) {
				return false;
			}
			
		}
		return true;
	}

}
