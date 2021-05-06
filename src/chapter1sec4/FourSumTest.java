package chapter1sec4;

import java.util.Arrays;

public class FourSumTest {
    public static void main(String[] args) {
        int[] array1 = {5, 2, -2, -5, -2};
        int[] array2 = {1, 3,  -4, 2, 4, -1, 5 , 7, 8, -5, -6};
        //快速算法要求数组必须时有序的且不能有重复元素
        //普通算法进要求数组是有序的。
        Arrays.sort(array2);
        Arrays.sort(array1);
        System.out.println(FourSum.count2(array2));
    }
}
