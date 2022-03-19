/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.ub8.algorithmpractice.sort;

/**
 * @author wubo05
 * @version 1.0.0
 * @ClassName ArrSorts.java
 * @Description
 * @createTime 2022年03月19日 11:12:00
 */
public class ArrSorts {

    public static void main(String[] args) {
        int [] arr = {0,8,5,3,90,8,5,3,9} ;
        // 极客时间 - 王铮
        quickSort(arr);
        System.out.println(arr);
//        ArrSort2 arrSort2 = new ArrSort2();
//        arrSort2.quickSort(arr , 0 ,arr.length-1);
//        System.out.println(arr);
    }

    private static void quickSort(int[] arr) {
        quickSortDo(arr , 0 , arr.length -1);
    }

    private static void quickSortDo(int[] arr , int left , int right) {
        if (null == arr || arr.length <=1 || left >= right){
            return;
        }

        int pivotIndex = partition(arr , left , right);
        quickSortDo(arr , left , pivotIndex-1);
        quickSortDo(arr , pivotIndex+1 , right);

    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot){
                swap(arr, i , j);
                i++;
            }
        }

        swap(arr , i , right);
        return i;
    }

//    private static int partition(int[] arr, int p, int r) {
//        int pivot = arr[r];
//        int i = p;
//        for (int j = p; j < r; j++) {
//            if (arr[j] <= pivot) {
//                swap(arr, i, j);
//                i++;
//            }
//        }
//
//        swap(arr, i, r);
//        return i;
//    }

    public static void swap(int[] arr , int index1 , int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
