package com.dsalgo.arrays.twoD;

// https://www.geeksforgeeks.org/determinant-of-a-matrix/?ref=gcse
public class DeterminantOfMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 2, -1}, {3, 0, 0, 5}, {2, 1, 4, -3}, {1, 0, 5, 0}};
        System.out.println("Determinant of the matrix is " + determinantOfMatrix(arr));
    }

    /**
     * Determinant of matrix: The value of determinant is calculated by following below steps:
     * 1. For each element of the first row or first column get the cofactor of those elements.
     * 2. Then multiply the element with the determinant of the corresponding cofactor.
     * 3. Finally, add them with alternate signs. As a base case, the value of the determinant of
     * a 1*1 matrix is the single value itself.
     *
     * The cofactor of an element is a matrix that we can get by removing the row and column of that
     * element from that matrix.
     *
     * In this method, we are using the properties of Determinant.
     * 1. Converting the given matrix into an upper triangular matrix using determinant properties
     * 2. The determinant of the upper triangular matrix is the product of all diagonal elements.
     * 3. Iterating every diagonal element and making all the elements down the diagonal as zero using
     * determinant properties
     * 4. If the diagonal element is zero then search for the next non-zero element in the same
     * column.
     *
     * There exists two cases:
     * Case 1: If there is no non-zero element. In this case, the determinant of a matrix is zero
     * Case 2: If there exists a non-zero element there exist two cases
     *      Case A: If the index is with a respective diagonal row element. Using the determinant
     *      properties make all the column elements down to it zero
     *      Case B: Swap the row with respect to the diagonal element column and continue the Case A
     *      operation.
     *
     * TC: O(n ^ 4)
     * SC: O(n ^ 2), for storing cofactors
     *
     *
     * @param arr
     * @return
     */
    private static int determinantOfMatrix(int[][] arr) {
        int n = arr.length;
        int num1, num2, determinant = 1, index, total = 1;

        // temporary array for storing row
        int[] temp = new int[n + 1];

        // loop for traversing the diagonal elements
        for(int i = 0; i < n; i++) {
            index = i;

            // finding the index which has non-zero value
            while (index < n && arr[index][i] == 0) {
                index++;
            }
            // if there is no non-zero elements
            if(index == n) {
                // the determinant of the matrix is zero
                continue;
            }

            if(index != i) {

                // loop for swapping the diagonal element row and index row
                for(int j = 0; j < n; j++) {
                    swap(arr, index, j, i, j);
                }
                // determinant sign changes when we shift rows
                determinant = (int) (determinant * Math.pow(-1, index - i));
            }

            // storing the values of diagonal row elements
            for(int j = 0; j < n; j++) {
                temp[j] = arr[i][j];
            }

            // traversing every row below the diagonal element
            for(int j = i + 1; j < n; j++) {
                // the value of diagonal element
                num1 = temp[i];

                // value of next row element
                num2 = arr[j][i];

                // traversing every column of row and multiplying to every row
                for(int k = 0; k < n; k++) {
                    arr[j][k] = (num1 * arr[j][k] - num2 * temp[k]);
                }
                // Det(kA)=kDet(A);
                total = total * num1;
            }
        }

        // multiplying the diagonal elements to get determinant
        for(int i = 0; i < n; i++) {
            determinant *= arr[i][i];
        }

        // Det(kA)/k=Det(A);
        return (determinant / total);
    }

    static int[][] swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
        return arr;
    }
}
