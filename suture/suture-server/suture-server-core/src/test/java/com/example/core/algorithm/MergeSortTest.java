package com.example.core.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {

    private final MergeSort mergeSort = new MergeSort();

    @Test
    void shouldCountReversePairs() {
        assertEquals(5, mergeSort.reversePairs(new int[]{7, 5, 6, 4}));
    }

    @Test
    void shouldReturnZeroForSortedArray() {
        assertEquals(0, mergeSort.reversePairs(new int[]{1, 2, 3, 4}));
    }

    @Test
    void shouldNotModifyInputArray() {
        int[] nums = {7, 5, 6, 4};
        mergeSort.reversePairs(nums);
        assertArrayEquals(new int[]{7, 5, 6, 4}, nums);
    }
}
