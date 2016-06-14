package ujjwal.core;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class PayPal {

    /**
     * Replace element of an Array with nearest bigger number at right side of
     * the Array in O(n) For example if the input Array is 7, 5, 6, 3, 4, 1, 2,
     * 9, 11 output array should be 9, 6, 9, 4, 9, 2, 9, 11, 11
     * 
     * 
     */

    public int[] reArrangedNumbers(int[] input) {
        
        Stack<Integer> S = new Stack<>();

        int[] output = new int[input.length];
        int temp;
        for (int i = input.length - 1; i >= 1; i--) {
            temp = input[i - 1];
            // check last index before -1
            if (input[i] >= input[i - 1]) {
                input[i - 1] = input[i];
            }


        }

        return output;
    }

    public class TreeNode {
        private int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }

    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
