/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.ub8.algorithmpractice.sort;

import java.util.Random;

/**
 * @author wubo05
 * @version 1.0.0
 * @ClassName ArrSort2.java
 * @Description
 * @createTime 2022年03月19日 11:40:00
 */
public class ArrSort2 {

    public int[] quickSort(int[] nums, int left,int right){
        //如果左指针大于右指针，怎退出循环
        if(left > right){
            return null;
        }
        //定一个基数，指向数组的最左边的元素
        int base = nums[left];
        //定义一个左指针，指向数组元素的第一个元素
        int i = left;
        //定义一个右指针，指向数组元素的最后一个
        int j = right;
        //当左右指针不相等时，就继续移动左右指针
        while(i != j){
            //从右往左遍历，当右指针指向的元素大于等于基数时，j--。右指针持续向左移动
            while(nums[j]>=base && i < j){
                j--;
            }
            //从左往右遍历，当左指针指向的元素小于等于基数时，i++。左指针持续向右移动
            while(nums[i]<=base && i < j){
                i++;
            }
            //当左右两个指针停下来时，交换两个元素
            swap(nums, i, j);

        }
        //当左右指针相遇时，将左右指针同时指向的元素和基数进行交换。
        swap(nums,i,left);//这个看着可能会变扭，等同于小面两行代码。
        //不过这下面的两行的代码的顺序不能相反，否则导致结果，都为第一个基数。
        //首先把基数要填入的位置空出来，然后在将基数填入。
        // nums[left] = nums[i];
        // nums[i] = base;
        quickSort(nums,left, i-1);
        quickSort(nums,i+1,right);
        return nums;
    }
    public void swap(int[] nums,int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
