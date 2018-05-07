package com.zys.sort;

/**
 * 快速排序
 * @author zys
 * @date 2018/04/17
 */
public class QuickSort {

    /**
     * 选取一个基准位置，使得数组左右两边相对有序，左边都小于基准位置，右边都大于基准位置
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition (int[] arr, int low, int high) {

        int indexVal = arr[low];
        while (low < high) {

            while (arr[high] >= indexVal && low < high) {
                --high;
            }
            arr[low] = arr[high];

            while (arr[low] <= indexVal && low < high) {
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[high] = indexVal;

        return high;
    }

    /**
     * 递归排序，直到数组只剩一个元素
     * @param arr
     * @param begin
     * @param end
     */
    public static void quickSort(int[] arr, int begin, int end) {

        if (begin >= end) {
            return ;
        }
        int index = partition(arr, begin, end);
        quickSort(arr, begin, index-1);
        quickSort(arr, index + 1, end);
    }

    public static void main (String[] args) {

        int[] arr = {3, 5, 2, 6, 2, 7, 9, 12, 1};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i != arr.length; ++i) {

            System.out.print(arr[i] + " ");
        }
    }
}
