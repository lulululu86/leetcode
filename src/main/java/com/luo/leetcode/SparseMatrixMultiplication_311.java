package com.luo.leetcode;
import java.util.*;
public class SparseMatrixMultiplication_311 {
    /*Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for(int i=0;i<A.length;i++){
            for(int k=0;k<A[0].length;k++){
                if(A[i][k]!=0){
                    for(int j=0;j<B[0].length;j++){
                        if(B[k][j]!=0)res[i][j] += A[i][k]*B[k][j];
                    }
                }
            }
        }
        return res;
    }
}
