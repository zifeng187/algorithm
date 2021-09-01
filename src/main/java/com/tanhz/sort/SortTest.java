package com.tanhz.sort;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 31, 3, 4, 6, 76, 34, 32, 11, 3, 1, 0};
        opt(arr);
        bubble(arr);
        insert(arr);
    }

    /**
     * 插入排序：假定当前对象是有序的，新来的从右往左，小则交换
     *
     * @param arr
     */
    private static void insert(int[] arr) {
        check(arr);
        int end = arr.length;
        for (int i = 1; i < end; i++) {
            //假定当前只有1个值 = i，新来的则+1 =j, 新来的小于则交换位置，右往左则 j--
            for (int j = i - 1; j >= 0 && arr[j] < arr[i - 1]; j--) {
                swap(arr, i, j);
            }
        }
        System.out.print("插入排序：");
        print(arr);
    }

    /**
     * 冒泡排序：从左到右，每次比较相临二个值的大小，大则往后移
     *
     * @param arr
     */
    private static void bubble(int[] arr) {
        check(arr);
        int end = arr.length;
        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] > arr[j])
                    swap(arr, i, j);
            }
        }
        System.out.print("冒泡排序：");
        print(arr);
    }

    /**
     * 选择排序：从左到右查询最小值下标，每次找到最小下标然后排到最前面
     *
     * @param arr
     */
    private static void opt(int[] arr) {
        check(arr);
        int end = arr.length;
        for (int i = 0; i < end; i++) {
            int minIndex = i;
            //假定第一位是最小的，所以比较从第二位开始
            for (int j = i + 1; j < end; j++) {
                //后面一位 < 当前位 ? 保留后一位下标 ：保留当前位下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
        System.out.print("选择排序：");
        print(arr);
    }

    private static void check(int[] arr) {
        if (arr == null && arr.length == 1)
            return;
    }

    private static void print(int[] arr) {
        if (arr == null && arr.length <= 0)
            return;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                System.out.print(" 【 ");
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(" , ");
            if (i == arr.length - 1)
                System.out.print(" 】 ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int obj = arr[i];
        arr[i] = arr[j];
        arr[j] = obj;
    }
}
