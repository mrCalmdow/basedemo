package com.flchen.basedemo.algorithm;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author fl.chen
 * Date 2019-10-25
 * Time 16:08
 * Desc:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SortDemosTest {

    @Test
    public void testBubblingSort() {

        int[] arr = {5,3,4,1,2};
        SortDemos sd = new SortDemos();

        sd.bubbling(arr);
        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(5, arr[4]);
    }


    @Test
    public void testInsertSort() {

        int[] arr = {5,3,4,1,2};
        SortDemos sd = new SortDemos();

        sd.insertSort(arr);
        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(5, arr[4]);
    }

    @Test
    public void testChoiceSort() {
        int[] arr = {5,3,4,1,2};
        SortDemos sd = new SortDemos();

        sd.choiceSort(arr);
        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(4, arr[3]);
        Assert.assertEquals(5, arr[4]);
    }

    @Test
    public void testMergeSort() {
        int[] arr = {5,3,4,1,2};
        SortDemos sd = new SortDemos();

        sd.mergeSort(arr);
        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(4, arr[3]);
        Assert.assertEquals(5, arr[4]);
    }
}
