package com.practice;

public class MaxPalindrome {

    private static int maxPlaindromSubseq(int[] nums) {

        System.out.println("in max palindrome code");
        int maxSub[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxSub[i][i] = 1;
        }

        for (int len = 2; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                if (nums[i] == nums[j]) {
                    maxSub[i][j] = Math.max(maxSub[i + 1][j - 1] + 2, maxSub[i][j]);
                } else {
                    maxSub[i][j] = Math.max(maxSub[i][j - 1], maxSub[i][j]);
                    maxSub[i][j] = Math.max(maxSub[i + 1][j], maxSub[i][j]);
                }
            }
        }
        return maxSub[0][nums.length - 1];
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3, 2, 1 };
        System.out.println(maxPlaindromSubseq(arr));
    }

}
