import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int[][] board = new int[N+4][M+4];
		
		scan.nextLine();
		for (int i = 1 ;i < N + 1;i ++) {
			for(int j = 1 ;j < M + 1;j ++) {
				board[i][j] = scan.nextInt();
			}
			scan.nextLine();
		}
		int maxNum = findMaxTetromino(N, M, board);
		System.out.println(maxNum);
	}
	public static int findMaxTetromino(int N, int M, int[][] board) {
		int maxValue = 0;
		int tempMaxValue;
		
		ArrayList<Integer> tempValue;
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < M + 1; j++) {
				tempValue = new ArrayList<>();
				//Blue Tetromino
				tempValue.add(board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j]);
				tempValue.add(board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3]);
				//Yellow Tetromino
				tempValue.add(board[i][j] + board[i+1][j] + board[i][j+1] + board[i+1][j+1]);
				//Orange Tetromino
				tempValue.add(board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2]);
				tempValue.add(board[i][j] + board[i+1][j] + board[i][j+1] + board[i][j+2]);
				tempValue.add(board[i][j] + board[i][j+1] + board[i][j+2] + board[i-1][j+2]);
				tempValue.add(board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2]);
				tempValue.add(board[i][j] + board[i+1][j] + board[i+2][j] + board[i][j+1]);
				tempValue.add(board[i][j] + board[i+1][j+1] + board[i+2][j+1] + board[i][j+1]);
				tempValue.add(board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j+1]);
				tempValue.add(board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j-1]);
				//Green Tetromino
				tempValue.add(board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1]);
				tempValue.add(board[i][j] + board[i][j+1] + board[i-1][j+1] + board[i+1][j]);
				tempValue.add(board[i][j] + board[i][j+1] + board[i+1][j] + board[i+1][j-1]);
				tempValue.add(board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2]);
				//Purple Tetromino
				tempValue.add(board[i][j] + board[i][j+1] + board[i-1][j+1] + board[i][j+2]);
				tempValue.add(board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i][j+2]);
				tempValue.add(board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j]);
				tempValue.add(board[i][j] + board[i][j+1] + board[i-1][j+1] + board[i+1][j+1]);
				
				tempMaxValue = Collections.max(tempValue);
				maxValue = (maxValue < tempMaxValue) ? tempMaxValue : maxValue;
			}
		}
		return maxValue;
	}

}
