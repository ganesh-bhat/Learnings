package com.puzzles;

public class powerOfX {

     public static void main(String[] args) {

         System.out.println(pow(2,4));


      }

      private static int pow(int x, int p) {
         if(p == 0) {
             return 1;
         }
         if(p == 1) {
              return x;
         }
         return x * pow(x,p-1);
      }
}
