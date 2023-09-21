package com.example.core.algorithm;

/**
 * @author: William.Peng
 * @date: 2023/9/20 11:22
 * @description:
 */
public class mergeSort {
    public int reversePairs(int[] nums){
        int len = nums.length;
        if(len < 2){
            return 0;
        }
        //一般不对原对象进行操作
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        //归并排序需要额外的数组
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left , int right, int[] temp){
        //递归出口
        if(left == right){
            return 0;
        }
        //开始二分数组
        int mid = left + (right - left) / 2;
        //分治的思想，计算小的问题
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        //对已排序的两个部分进行合并
        int corssPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + corssPairs;
    }
    private  int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp){
        //对当前要排序的数据放到临时数组中
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        //分别控制左边第一个和中间的后面一个
        int i = left;
        int j = mid + 1;
        //记录逆序对
        int count = 0;
        for (int k = left; k <= right; k++) {
            //当左边的已经超过中间值
            if(i == mid + 1){
                nums[k] = temp[j];
                j++;
            }
            //当j已经超过最右边，或者左小于右
            if(j == right + 1 || temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            } else if(temp[i] > temp[j]){
                nums[k] = temp[j];
                j++;
                count += mid - i + 1;
            }
        }
        return count;
    }
}
