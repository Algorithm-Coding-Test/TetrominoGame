import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static class Tetromino{
		ArrayList<Integer> value;
		boolean isFull;
		int sumOfValue;
		ArrayList<String> points;
		
		public Tetromino(int x, int y) {
			this.value = new ArrayList<>();
			this.points = new ArrayList<>();
			this.points.add(x+"/"+y);

			isFull = false;
			sumOfValue = 0;
		}
		public Tetromino(int x, int y, int newValue) {
			this.value = new ArrayList<>();
			this.value.add(newValue);
			this.points = new ArrayList<>();
			this.points.add(x+"/"+y);
			
			isFull = false;
			sumOfValue = newValue;
		}
		public Tetromino(Tetromino oldTetromino) {
			this.value = new ArrayList<>();
			for(int i= 0;i<oldTetromino.value.size();i++) {
				value.add(oldTetromino.value.get(i));
			}
			this.points = new ArrayList<>();
			for(int i= 0;i<oldTetromino.points.size();i++) {
				points.add(oldTetromino.points.get(i));
			}
			this.sumOfValue = oldTetromino.sumOfValue;
			this.isFull = oldTetromino.isFull;
		}
		public Tetromino addValue(int newValue, int x, int y) {
			if(value.size() < 3) {
				value.add(newValue);
			}else {
				value.add(newValue);
				isFull = true;
			}
			points.add(x+"/"+y);
			sumOfValue += newValue;
			return this;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int[][] board = new int[N][M];
		
		scan.nextLine();
		for (int i = 0 ;i < N;i ++) {
			for(int j = 0 ;j < M;j ++) {
				board[i][j] = scan.nextInt();
			}
			scan.nextLine();
		}
		int maxNum = findMaxTetromino(N, M, board);
		System.out.println(maxNum);
	}
	public static int findMaxTetromino(int N, int M, int[][] board) {
		int maxValue = 0;
		Tetromino newTetromino;
		Tetromino tetromino;
		
		ArrayList<Tetromino> possibleTetromino;
		int tempX; int tempY;
		for(int i = 0;i < N;i ++) {
			for(int j = 0; j < M; j++) {
				
				possibleTetromino = new ArrayList<>();
				possibleTetromino.add(new Tetromino(i, j, board[i][j]));
				
				while(!possibleTetromino.isEmpty()) {
					
					tetromino = possibleTetromino.get(0);
					if(!tetromino.isFull) {
						
						for(int k = 0;k<tetromino.points.size();k++) {
							
							tempX = Integer.parseInt(tetromino.points.get(k).split("/")[0]);
							tempY = Integer.parseInt(tetromino.points.get(k).split("/")[1]);
							
							newTetromino = new Tetromino(tetromino);
							if(tempX+1 < N && !newTetromino.points.contains((tempX+1)+"/"+tempY)) {
								newTetromino.addValue(board[tempX+1][tempY], tempX+1, tempY);							
								possibleTetromino.add(newTetromino);
							}
							newTetromino = new Tetromino(tetromino);
							if(tempX-1 >= 0 && !newTetromino.points.contains((tempX-1)+"/"+tempY)) {
								newTetromino.addValue(board[tempX-1][tempY],tempX-1,tempY);
								possibleTetromino.add(newTetromino);
							}
							newTetromino = new Tetromino(tetromino);
							if(tempY+1 < M && !newTetromino.points.contains(tempX+"/"+(tempY+1))) {
								newTetromino.addValue(board[tempX][tempY+1],tempX,tempY+1);
								possibleTetromino.add(newTetromino);
							}
							newTetromino = new Tetromino(tetromino);
							if(tempY-1 >= 0 && !newTetromino.points.contains(tempX+"/"+(tempY-1))) {
								newTetromino.addValue(board[tempX][tempY-1], tempX, tempY-1);
								possibleTetromino.add(newTetromino);
							}

						}
					}else if(tetromino.sumOfValue > maxValue) maxValue = tetromino.sumOfValue;

					possibleTetromino.remove(0);
				}
				
			}
		}
		return maxValue;
	}

}
