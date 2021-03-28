package iloveyouboss;

import java.io.*;

public class MyBinarySearch {
   public int binarySearch(int[] inputArr, int key) {
      int start = 0;
      int end = inputArr.length - 1;
      while (start <= end) {
         int mid = (start + end) / 2;
         if (key == inputArr[mid]) {
            return mid;

         } else if (key > inputArr[mid]) {
            start++;

         } else {
            end--;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      MyBinarySearch mbs = new MyBinarySearch();
      int[] arr1 = { 2, 4, 6, 8, 10, 12, 14, 16 };
      System.out.println("Key 14's position: " + mbs.binarySearch(arr1, 14));
      int[] arr2 = { 6, 34, 78, 123, 432, 900 };
      System.out.println("Key 432's position: " + mbs.binarySearch(arr2, 432));
   }
}
