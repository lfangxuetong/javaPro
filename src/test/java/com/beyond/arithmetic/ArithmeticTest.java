package com.beyond.arithmetic;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created by liwucai on 2017/4/8 18:36.
 */
public class ArithmeticTest {

    @Test
    public void arithmeticChooseTest()  throws Exception {
        //无论什么排序，都要先比较。选择排序：比较大小，记录选择一个最大(或最小),经过一轮比较后，交换选择值。
        int[] array1 = new int[]{2,1,7,8,3,9};
        for(int i=0;i<array1.length;i++){
            int max = i;
            for(int j=i;j<array1.length;j++){
                if(array1[max] < array1[j]){
                    max = j;
                }
            }
            if(max != i){
                int temp = array1[i];
                array1[i] = array1[max];//选择最大
                array1[max] = temp;
            }
        }
        System.out.println("=====选择排序："+ JSONObject.toJSONString(array1));
    }
    @Test
    public void arithmeticBubblingTest()  throws Exception {
        //无论什么排序，都要先比较。冒泡排序：比较大小，判断最大(或最小),马上交换选择值。一轮比较后，最大(或最小)在最前。
        int[] array1 = new int[]{2,1,7,8,3,9};
        for(int i=0;i<array1.length;i++){
            for(int j=i;j<array1.length;j++){
                if(array1[i] < array1[j]){
                    int temp = array1[i];
                    array1[i] = array1[j];//交换最大
                    array1[j] = temp;
                }
            }
        }
        System.out.println("=====冒泡排序："+JSONObject.toJSONString(array1));
    }
    @Test
    public void arithmeticRecursionTest()  throws Exception {
        int count = recursion(1);
        System.out.println(count + " ，=====递归(1+2+3+... = X)");
    }

    /**
     * 递归函数
     */
    private int recursion(int count){
        if(count<4){
            System.out.print(count + " + ");
            return count + recursion(++count);
        }else{
            System.out.print(count + " = " );
            return count;
        }
    }
}
