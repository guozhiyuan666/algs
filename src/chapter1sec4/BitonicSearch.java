package chapter1sec4;

import chapter1sec1.BinarySearch;

import java.util.Arrays;

public class BitonicSearch {
    //找出双调数组最大值的索引
    public static int max(int[] a, int lo, int hi) {
        if (lo == hi) return hi;
        int mid = (lo + hi) / 2;
        if (a[mid] < a[mid + 1]) {
            return max(a, mid + 1, hi);
        } else if (a[mid] > a[mid + 1]) {
            return max(a, lo, mid);
        } else{
            return mid;
        }
    }
    //将数组分成两个，分别进行二分查找
    public static boolean bitoncSearch(int[] nums,int key){
        int max = max(nums,0,nums.length);
        int [] nums1 = new int[max];
        int [] nums2 = new int[nums.length - max];
        for(int i = 0; i < max; i++){
            nums1[i] = nums[i];
        }
        for(int j = 0; j < nums.length - max; j++){
            nums2[j] = nums[j + max];
        }
        Arrays.sort(nums2);
        boolean a = rank(nums1,0,nums1.length - 1,key);
        boolean b = rank(nums2,0,nums2.length - 1,key);
        if(a || b){
            return true;
        }else{
            return false;
        }
    }
    //二分查找
    public  static boolean rank(int[] nums,int lo, int hi, int key){
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == key){
                return true;
            }
            if(nums[mid] > key){
                hi = mid - 1;
            }
            if(nums[mid] < key){
                lo = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,7,9,5,3,-2,-1,-10};
        System.out.println(bitoncSearch(a,-10));
    }
}
