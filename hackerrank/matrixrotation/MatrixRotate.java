package dummy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixRotate {
	private int[][] matrix;
	private int rotate;
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public int getRotate(){
		return this.rotate; 
	}
	
	public void setRotate(int r) {
		this.rotate = r;
	}

	public void getMatrixValues(){
		System.out.println("Enter row coumn rotate:");
		Scanner in = new Scanner(System.in);
		int rows = 0;
		int columns = 0;

		try { 
			rows = in.nextInt();
			columns = in.nextInt();
			rotate = in.nextInt();
		} catch (InputMismatchException e) {
			// System.out.println("Only integer values!");
			in.close();
			return;
		}

		System.out.println("row: " + rows + " coulmns: " + columns + " rotate: " + rotate);
		
		matrix = new int[rows][columns];
		System.out.println("Enter matrix:");
		for(int i = 0; i < rows; i ++){
			for(int j = 0; j < columns; j ++){
				matrix[i][j] = in.nextInt();
			}
			in.nextLine();
		}
		in.close();
	}
	
	public void rotateMatrix(){
		int index = 0;
		int[][] aCopy = matrix.clone();
		int initValue = matrix[index][index];
		int direction = 1;
		
		int row = index;
		int column = index;
		int counter = 0;
		int columns = matrix[0].length;
		int rows = matrix.length - index*2;
		
		while((index + 1) * 2 - 1 <= columns && (index + 1) * 2 - 1 <= rows ){
			while( true ) {
				for(int x = index; x < matrix[0].length - 2*index - 1; x++){
					matrix[row][column] = aCopy[row][column + 1*direction];
					column = column + 1 * direction;
				} 
				for(int x = index; x < matrix.length - 2*index - 1; x++){
					matrix[row][column] = aCopy[row + 1*direction][column];
					row = row + 1 * direction;
				}
				direction = -1;
				counter++;
				
				if( (column == index && row == index) || counter > 1000 ) {
					matrix[row + 1][column] = initValue;
					break;
				}
			}
			index++;
		}
	}
	
	public void printMatrix(){
		for(int[] x: matrix){
			for(int xx: x){
				System.out.printf(xx + " ");
			}
			System.out.println("");
		}
	}
}
