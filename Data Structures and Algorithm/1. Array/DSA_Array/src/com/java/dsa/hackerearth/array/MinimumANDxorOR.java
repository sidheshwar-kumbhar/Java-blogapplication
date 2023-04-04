package com.java.dsa.hackerearth.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class MinimumANDxorOR {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T > 0){
            int N = s.nextInt();
            s.nextLine();
            String[] strArr = s.nextLine().split(" ");
            long[] arr = new long[N];
            for(int i = 0; i < strArr.length; i++){
                arr[i] = Long.parseLong(strArr[i]);
            }
            
            Arrays.sort(arr);
            long min = Long.MAX_VALUE;
            for(int i = 0; i < arr.length - 1; i++){
                long tmp = arr[i] ^ arr[i+1];
                if(tmp < min){
                    min = tmp;
                }
            }
            System.out.println(min);
            T--;
        }
    }
}
