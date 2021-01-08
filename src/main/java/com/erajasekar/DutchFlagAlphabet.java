package com.erajasekar;

class Solution {

    public static void sort(int[] arr) {
        //Implement

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        /**
         Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
         */
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        Solution.sort(arr);
        // Expected Output: [0 0 1 1 2]
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        // Expected Output: [0 0 1 2 2 2 ]
        Solution.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }


}

/* EMPLOYEE (name, deptId) DEPARTMENT (deptid, dept_name) – how would you return rows from DEPARTMENT NO Employees */

