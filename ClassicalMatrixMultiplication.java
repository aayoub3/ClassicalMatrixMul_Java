// COPYRIGHTS.© ABANOB AYOUB 
//"Classical MM"
//This code takes the matrix size 'r' from the user for example r=4,
//and generates two random matrices of size r x r , and calculate the 
//result of multiplying both time each other. Also it claculates algorithm execution time.

package com.mycompany.classicalmatrixmultiplication;    
import java.util.Scanner;
import java.util.Random;


public class ClassicalMatrixMultiplication {
    
    public static int[][] generateRandomMatrix(int size) { //Creates Random n x n Matrix
        int[][] matrix = new int[size][size]; 
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10); // Generate a random integer between 0 and 9
            }
        }
        return matrix;
    }
    
    
      public static void printMat(int[][] a, int r, int c){
    for(int i=0;i<r;i++){
      for(int j=0;j<c;j++){
        System.out.print(a[i][j]+" ");
      }
      System.out.println("");
    }
    System.out.println("");
  }
   
  
 public static int[][] calcOutput(int a[][], int b[][], int mul[][], int size){
     int r = size;
     int c = size;
     
 for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        mul[i][j] = 0;
        for (int k = 0; k < c; k++) {
          mul[i][j] += a[i][k] * b[k][j];
        }
      }
    }
 return mul;
 } 
 
public static void main(String[] args) 
{
    Scanner input = new Scanner(System.in);


    System.out.print("Enter an int matrix size ex) 2, 4, 8, etc... : ");
    int r = input.nextInt();


    //Generate and print first matrix input
        int[][] matrix_A = generateRandomMatrix(r);
        System.out.println("Array A =>");
        printMat(matrix_A,r,r);
    
    //Generate and print second matrix input
        int[][] matrix_B = generateRandomMatrix(r);
        System.out.println("Array B =>");
        printMat(matrix_B,r,r);
    
   
int[][] mul_M = new int[r][r]; //Empty output matrix to pass to 'calcOutput'

    //Start Timer 
      long startTime = System.nanoTime();

    //Call 'calcOutput' function to Calculate the result matrix multiplication
    int[][] result_matrix = calcOutput(matrix_A, matrix_B, mul_M, r);
    
    //Stop Timer
      long endTime = System.nanoTime();

    //Calculate excution time
      double executionTimeInSeconds = (endTime - startTime) / 1000000000.0;
    
    //print the result matrix multiplication
    System.out.println("The result is:");
        printMat(result_matrix,r,r);
        
    //Print excution time    
      System.out.println("Algorithm Execution Time: " + executionTimeInSeconds + " seconds");
  }

}
