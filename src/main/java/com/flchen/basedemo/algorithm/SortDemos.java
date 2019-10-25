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
     * 冒泡排序：
     * 复杂度：  最优时间复杂度O(1)，最差时间复杂度O(n*n)
     * 原地排序：未借助其他数组
     * 稳定排序：元素相同时，不交换
     * @param arr
     */
    public void bubbling(int[] arr) {
        if(!validArrayLegal(arr)) {
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
            if(!flag) break;
        }
    }


    /**
     * 插入排序法：将数组分类已排序和示排序两部分；
     * 从未排序的部分中逐个取出元素，到已排序的部分中，找到对应位置进行插入
     * @param arr
     */
    public void insertSort(int[] arr) {

        if (!validArrayLegal(arr)) {
            return ;
        }

        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int v = arr[i];
            int j = i - 1;
            boolean flag = false;   //是否需要插入

            for (; j >= 0 ; j--) {
                if(arr[j] > v) {
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
                if(arr[j] < min) {
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
