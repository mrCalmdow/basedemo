package com.flchen.basedemo.algorithm;

/**
 * author fl.chen
 * Date 2019-10-25
 * Time 15:48
 * Desc: 经典排序算法：学习目标--算法原理，分析算法时间复杂度
 * 第一批：插入排序、冒泡排序、选择排序
 * 第二批：快速排序、归并排序
 * 第三批：桶排序、计数、基数
 **/
public class SortDemos {

    /**
     * 归并排序：分治思想用递归来实现
     *
     * @param arr
     */
    public void mergeSort(int[] arr) {

        if (!validArrayLegal(arr)) {
            return;
        }
        int size = arr.length;
        sorting(arr, 0, size - 1);

    }

    public void sorting(int[] arr, int p, int r) {

        if (p >= r) {
            return;
        }
        int q = (p + r) >> 1;
        sorting(arr, p, q);
        sorting(arr, q + 1, r);

        merging(arr, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }

    public void merging(int[] arr, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        /**
         * 合并过程
         */
        while (i <= q && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }


        /**
         * 处理剩余的数据
         */
        int start = i, end = q; // 默认第一个数组有剩余
        if (j <= r) {   //
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        System.arraycopy(tmp, 0, arr, p, r - p);
    }

    /**
     * 快速排序（quick sort）
     */
    public void quickSort() {


    }

    /**
     * 冒泡排序：
     * 复杂度：  最优时间复杂度O(1)，最差时间复杂度O(n*n)
     * 原地排序：未借助其他数组
     * 稳定排序：元素相同时，不交换
     *
     * @param arr
     */
    public void bubbling(int[] arr) {
        if (!validArrayLegal(arr)) {
            return;
        }
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            /**
             * 优化：增加冒泡标志，如果标志为false表示已经是有序
             */
            boolean flag = false;
            // 排好的元素已经在数组尾部
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    /**
                     * 如果有交换动作，就设置flag=true
                     */
                    flag = true;
                }
            }
            /**
             * 判断无交换，则提前退出
             */
            if (!flag) break;
        }
    }


    /**
     * 插入排序法：将数组分类已排序和示排序两部分；
     * 从未排序的部分中逐个取出元素，到已排序的部分中，找到对应位置进行插入
     *
     * @param arr
     */
    public void insertSort(int[] arr) {

        if (!validArrayLegal(arr)) {
            return;
        }

        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int v = arr[i];
            int j = i - 1;
            boolean flag = false;   //是否需要插入

            for (; j >= 0; j--) {
                if (arr[j] > v) {
                    arr[j + 1] = arr[j];
                    flag = true;
                } else {
                    /**
                     * 优化：最近的元素都不能大于当前元素，则再往前的也不可能满足条件； 因为数组首部是已排好序的元素
                     */
                    break;
                }
            }
            if (flag) {
                //当发生挪动位置时，才需要插入；否则是同一个元素
                arr[j + 1] = v;
            }
        }
    }


    /**
     * 最常用的选择排序
     */
    public void choiceSort(int[] arr) {

        if (!validArrayLegal(arr)) {
            return;
        }
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int min = arr[i];
            int t = -1;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    t = j;
                }
            }
            if (t >= i) {
                arr[t] = arr[i];
                arr[i] = min;
            }
        }
    }

    public boolean validArrayLegal(int[] arr) {
        if (null == arr || 1 >= arr.length) {
            return false;
        }
        return true;
    }
}
