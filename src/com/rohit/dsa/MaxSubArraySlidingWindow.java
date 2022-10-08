package com.rohit.dsa;

import java.util.Arrays;

public class MaxSubArraySlidingWindow {
    public static void main(String[] args) {
        int [] nums = {4,-1,2,-7,3,4};

        int []indexes = findIndexOfLargesSubArray(nums);

        System.out.println("indexes - " + Arrays.toString(indexes));
    }

    // Time Complexity - O(n)
    private static int[] findIndexOfLargesSubArray(int[] nums) {
        int leftPointer = 0;
        int rightPointer = 0;
        int maxSum = nums[0];
        int curSum = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        for(;rightPointer < nums.length;rightPointer++) {

            if (curSum < 0) {
                curSum = 0;
                leftPointer = rightPointer;
            }

            curSum += nums[rightPointer];

            if (curSum > maxSum) {
                maxSum = curSum;
                leftIndex = leftPointer;
                rightIndex = rightPointer;
            }
        }
        return new int[] {leftIndex, rightIndex};
    }
}
