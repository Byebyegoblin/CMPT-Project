/*Matrix Addition and Subtration
 * http://www.programmingsimplified.com/java/source-code/java-program-add-matrices 
 * 
 * Matrix Multiplication
 * https://rosettacode.org/wiki/Matrix_multiplication#Java
 * 
 * RREF
 * https://github.com/tehgao/IB-Math-IA-Year-1/blob/master/src/RREF.java
 * 
 * 
 */

import java.util.Scanner;

public class MainProject {
	
	public static void toReducedRowEchelonForm(double[][] matrix) {
	        int rowCount = matrix.length;
	        if (rowCount == 0)
	            return;

	        int columnCount = matrix[0].length;

	        int lead = 0;
	        for (int r = 0; r < rowCount; r++) {
	            if (lead >= columnCount)
	                break;
	            {
	                int i = r;
	                while (matrix[i][lead] == 0) {
	                    i++;
	                    if (i == rowCount) {
	                        i = r;
	                        lead++;
	                        if (lead == columnCount)
	                            return;
	                    }
	                }
	                double[] temp = matrix[r];
	                matrix[r] = matrix[i];
	                matrix[i] = temp;
	            }

	            {
	                double lv = matrix[r][lead];
	                for (int j = 0; j < columnCount; j++)
	                    matrix[r][j] /= lv;
	            }

	            for (int i = 0; i < rowCount; i++) {
	                if (i != r) {
	                    double lv = matrix[i][lead];
	                    for (int j = 0; j < columnCount; j++)
	                        matrix[i][j] -= lv * matrix[r][j];
	                }
	            }
	            lead++;
	     }
	}
	
	public static void matrixAddition(){
		int m, n, c, d;
		Scanner in = new Scanner(System.in);
			 
		System.out.println("Enter the number of rows and columns of matrix");
		m = in.nextInt();
		n  = in.nextInt();
		 
		int first[][] = new int[m][n];
		int second[][] = new int[m][n];
		int sum[][] = new int[m][n];
			 
		System.out.println("Enter the elements of first matrix");
			 
		for (  c = 0 ; c < m ; c++ )
		    for ( d = 0 ; d < n ; d++ )
		       first[c][d] = in.nextInt();
			 
		System.out.println("Enter the elements of second matrix");
			 
		    for ( c = 0 ; c < m ; c++ )
		        for ( d = 0 ; d < n ; d++ )
			        second[c][d] = in.nextInt();
			 
		    for ( c = 0 ; c < m ; c++ )
		        for ( d = 0 ; d < n ; d++ )
		            sum[c][d] = first[c][d] + second[c][d];  //replace '+' with '-' to subtract matrices
			 
		 System.out.println("Sum of entered matrices:");
			 
		for ( c = 0 ; c < m ; c++ )
			      {
		    for ( d = 0 ; d < n ; d++ )
		        System.out.print(sum[c][d]+"\t");
			 
		 System.out.println();
		 }
		in.close();
	}
	
	public static void matrixMultiplication(int[][] matrix1, int[][] matrix2){
	
		int n = matrix1[0].length;
		int m = matrix1.length;
		int p = matrix2[0].length;
	 
		int ans[][] = new int[m][p];
	 
	
		for(int i = 0;i < m;i++){
			for(int j = 0;j < p;j++){
				for(int k = 0;k < n;k++){
					ans[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		
		for (int index = 0; index < ans.length; index++){
			System.out.println();
			for (int index1 = 0; index1 < ans[index].length; index1++)
				System.out.print(ans[index][index1] + ",");
		}
	}
	
	public static void matrixSubtraction(){
		int m, n, c, d;
		Scanner in = new Scanner(System.in);
			 
		System.out.println("Enter the number of rows and columns of matrix");
		m = in.nextInt();
		n  = in.nextInt();
		 
		int first[][] = new int[m][n];
		int second[][] = new int[m][n];
		int sum[][] = new int[m][n];
			 
		System.out.println("Enter the elements of first matrix");
			 
		for (  c = 0 ; c < m ; c++ )
		    for ( d = 0 ; d < n ; d++ )
		       first[c][d] = in.nextInt();
			 
		System.out.println("Enter the elements of second matrix");
			 
		    for ( c = 0 ; c < m ; c++ )
		        for ( d = 0 ; d < n ; d++ )
			        second[c][d] = in.nextInt();
			 
		    for ( c = 0 ; c < m ; c++ )
		        for ( d = 0 ; d < n ; d++ )
		            sum[c][d] = first[c][d] - second[c][d];  //replace '+' with '-' to subtract matrices
			 
		 System.out.println("Sum of entered matrices:-");
			 
		for ( c = 0 ; c < m ; c++ )
			      {
		    for ( d = 0 ; d < n ; d++ )
		        System.out.print(sum[c][d]+"\t");
			 
		 System.out.println();
		 }
		in.close();
	}
	
	public static void main(String[] args){

		
		int array1[][] = { {1,2,3}, {2,3,4}, {4,5,6}};
		int array2[][] = { {1,2,3}, {2,3,4}, {4,5,6}};
		
		double[][] mtx = {
		            { 1, 2, -1, -4},
		            { 2, 3, -1,-11},
		            {-2, 0, -3, 22}};

		toReducedRowEchelonForm(mtx);
		matrixMultiplication(array1, array2);
		
		for (int index = 0; index < mtx.length; index++){
			System.out.println();
			for (int index1 = 0; index1 < mtx[index].length; index1++)
				System.out.print(mtx[index][index1] + ",");
		}

		matrixAddition();
		matrixSubtraction();
	}
}

