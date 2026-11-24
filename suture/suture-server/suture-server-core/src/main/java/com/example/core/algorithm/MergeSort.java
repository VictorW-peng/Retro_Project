package com.example.core.algorithm;

/**
 * 归并排序实现，同时统计数组中的逆序对数量。
 *
 * @author William.Peng
 */
public class MergeSort {

    /**
     * 统计逆序对数量，不修改入参数组。
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] copy = nums.clone();
        int[] temp = new int[nums.length];
        return reversePairs(copy, 0, nums.length - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // 左半部分已耗尽，直接拷贝右半部分剩余元素
                nums[k] = temp[j++];
            } else if (j > right) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += mid - i + 1;
            }
        }
        return count;
    }
}
