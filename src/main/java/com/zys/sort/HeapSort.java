package com.zys.sort;

/**
 * 堆排序
 * @author zys
 * @date 2018/04/15
 */
public class HeapSort {

    /**
     * 堆排序，从第一个非叶子节点开始调整
     * @param arr
     */
    public static void heapSort(int[] arr) {

        if (arr == null || arr.length < 1) {
            return;
        }

        int len = arr.length;
        int firstIndex = (len - 2) >> 1;
        for (int i = firstIndex; i >= 0; --i) {

            adjustHeap(arr, i, len);
        }

        for (int i = 0; i != len; ++i) {

            swap(arr, 0, len-1-i);
            adjustHeap(arr, 0, len-2-i);
        }
    }

    /**
     * 调整下标index，保证它的孩子节点小于它自身
     * 同时递归调用，保证交换过元素的节点满足最大最小堆的定义
     * @param arr 数组
     * @param index 待调整下标
     * @param len 最大（小）堆的长度
     */
    public static void adjustHeap(int[] arr, int index, int len) {

        int li = (index<<1) + 1;
        int ri = li + 1;
        int maxi = li;
        if (li >= len) {
            return ;
        }

        if (ri < len && arr[li] < arr[ri]) {

            maxi = ri;
        }
        if (arr[maxi] > arr[index]) {

            swap(arr, maxi, index);
            adjustHeap(arr, maxi, len);
        }
    }

    /**
     * 交换数组元素下标
     * @param arr
     * @param i
     * @param j
     */
    public static void swap (int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main (String[] args) {

        int[] arr = {20,50,20,40,70,10,80,30,60};
        heapSort(arr);
        for (int i = 0; i != arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
