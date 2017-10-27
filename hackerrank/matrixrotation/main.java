package hackerrank.matrixrotation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	/* public static void main(String[] args) {
		MatrixRotate m = new MatrixRotate();
		m.getMatrixValues();
		m.rotateMatrix();
		m.printMatrix(); 

	} */

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = 0;
		int columns = 0;
		int rotate = 0;
		try { 
			rows = in.nextInt();
			columns = in.nextInt();
			rotate = in.nextInt();
		} catch (InputMismatchException e) {
			// System.out.println("Only integer values!");
			in.close();
			return;
		}
		
		//System.out.println("row: " + rows + " coulmns: " + columns + " rotate: " + rotate);
		
		int[][] a = new int[rows][columns];
		//System.out.println("Enter matrix:");
		for(int i = 0; i < rows; i ++){
			for(int j = 0; j < columns; j ++){
				a[i][j] = in.nextInt();
			}
			//in.nextLine();
		}
		in.close();
		while( rotate > 0){
			a = shiftArray(a, 0);
			rotate--;
		}
		
		printArray(a);
    }
	public static int[][] shiftArray(int[][] a, int index) {
		int[][] aCopy = a.clone();
		int initValue = a[index][index];
		int direction = 1;
		
		int row = index;
		int column = index;
		int counter = 0;
		int columns = a[0].length;
		int rows = a.length - index*2;
		
		while((index + 1) * 2 - 1 <= columns && (index + 1) * 2 - 1 <= rows ){
			while( true ) {
				for(int x = index; x < a[0].length - 2*index - 1; x++){
					a[row][column] = aCopy[row][column + 1*direction];
					column = column + 1 * direction;
				} 
				for(int x = index; x < a.length - 2*index - 1; x++){
					a[row][column] = aCopy[row + 1*direction][column];
					row = row + 1 * direction;
				}
				direction = -1;
				counter++;
				
				if( (column == index && row == index) || counter > 1000 ) {
					a[row + 1][column] = initValue;
					break;
				}
			}
			index++;
		}
		return a;
	}
	
	public static void printArray(int[][] a){
		for(int[] x: a){
			for(int xx: x){
				System.out.printf(xx + " ");
			}
			System.out.println("");
		}
	}
}


/*

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = 0;
		int columns = 0;
		int rotate = 0;
		try { 
			rows = in.nextInt();
			columns = in.nextInt();
			rotate = in.nextInt();
		} catch (InputMismatchException e) {
			// System.out.println("Only integer values!");
			in.close();
			return;
		}
		
		//System.out.println("row: " + rows + " coulmns: " + columns + " rotate: " + rotate);
		
		int[][] a = new int[rows][columns];
		//System.out.println("Enter matrix:");
		for(int i = 0; i < rows; i ++){
			for(int j = 0; j < columns; j ++){
				a[i][j] = in.nextInt();
			}
			//in.nextLine();
		}
		in.close();
		while( rotate > 0){
			a = shiftArray(a, 0);
			rotate--;
		}
		
		printArray(a);
    }
	public static int[][] shiftArray(int[][] a, int index) {
		int[][] aCopy = a.clone();
		int initValue = a[index][index];
		int direction = 1;
		
		int row = index;
		int column = index;
		int counter = 0;
		int columns = a[0].length;
		int rows = a.length - index*2;
		
		while((index + 1) * 2 - 1 <= columns && (index + 1) * 2 - 1 <= rows ){
			while( true ) {
				for(int x = index; x < a[0].length - 2*index - 1; x++){
					a[row][column] = aCopy[row][column + 1*direction];
					column = column + 1 * direction;
				} 
				for(int x = index; x < a.length - 2*index - 1; x++){
					a[row][column] = aCopy[row + 1*direction][column];
					row = row + 1 * direction;
				}
				direction = -1;
				counter++;
				
				if( (column == index && row == index) || counter > 1000 ) {
					a[row + 1][column] = initValue;
					break;
				}
			}
			index++;
		}
		return a;
	}
	
	public static void printArray(int[][] a){
		for(int[] x: a){
			for(int xx: x){
				System.out.printf(xx + " ");
			}
			System.out.println("");
		}
	}
}
*/