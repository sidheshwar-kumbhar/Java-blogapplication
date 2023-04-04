package com.java.example.array;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class RemoveDuplicateStrings
{
  public static void main(String args[])throws IOException
  {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-- > 0)
      {
          int n = sc.nextInt();
          String arr[] = new String[n];
          for(int i = 0;i<n;i++)
              arr[i] = sc.next();
          
          
          System.out.println(secFrequent(arr, n));
      }
  }
  
  static String secFrequent(String arr[], int N)
  {
    Map<String, Integer> map = new HashMap<String,Integer>();
    if(N == 0){
        return"";
    }
    for(String str : arr){
        if(map.containsKey(str)){
            map.put(str, map.get(str) + 1);
        } else {
            map.put(str, 1);
        }
    }
    int maxCount = 0;
    int secondMaxCount = 0;
    String maxString = "";
    String secondMaxString = "";
    
    Set<String> keys = map.keySet();
    for(String key : keys){
        int  count = map.get(key);
        if(count > maxCount) {
        	secondMaxCount = maxCount;
            secondMaxString = maxString;
            maxCount = count;
            maxString = key;            
        } else if((count < maxCount) && (count > secondMaxCount)){
            secondMaxCount = count;
            secondMaxString = key;
        }
    }
    return secondMaxString;
    
  }
}