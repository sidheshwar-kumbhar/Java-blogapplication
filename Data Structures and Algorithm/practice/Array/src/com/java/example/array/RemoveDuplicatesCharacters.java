package com.java.example.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RemoveDuplicatesCharacters {

  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int tc = Integer.parseInt(br.readLine());
      while (tc-- > 0) {
          String str = br.readLine().trim();

          String ans = removeDuplicates(str);
          System.out.println(ans);
      }
  }
  static String removeDuplicates(String str) {
     if(str == null){
         return str;
     }
     List<Character> list = new ArrayList<Character>();
     char[] charArray = str.toCharArray();
     for(char ch : charArray){
         if(!list.contains(ch)){
             list.add(ch);
         }
     }
     
     return list.toString().replaceAll("\\,|\\[|\\]|\\s", "");
     
  }
}

