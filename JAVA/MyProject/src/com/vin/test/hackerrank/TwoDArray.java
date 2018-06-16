package com.vin.test.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoDArray {

    // Complete the hourglassSum function below.
	// This method will return the maximum hoursglass sum
    static int hourglassSum(int[][] arr) throws Exception{
        
        int i=0;
        int j=0;
        int k=0;
        int max = Integer.MIN_VALUE;
        while( i<4 ){
            int sum = 0;
            sum += arr[i+0][j+0];
            sum += arr[i+0][j+1];
            sum += arr[i+0][j+2];
            
            sum += arr[i+1][j+1];
            
            sum += arr[i+2][j+0];
            sum += arr[i+2][j+1];
            sum += arr[i+2][j+2];

            System.out.println(sum);
            
            if(sum > max){
                max= sum;
            }
            
            j++;
            
            if( j == 4 ){
                i++;
                j=0;
            }
            if( i == 4 ){
                break;
            }
            
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int result=0;
try{
         result= hourglassSum(arr);
}catch(Exception e){
    
}
    
System.out.println(result);

        scanner.close();
    }
}
