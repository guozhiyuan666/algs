package chapter2sec3;

import chapter2sec2.PrintArray;
/*
将只有两种主键的数组排序
 */
public class Num5 {
    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int i, int j){
        int lt = i, gt = j;
        int r = i + 1;
        while(r <= gt){
            int cmp = a[j].compareTo(a[lt]);
            if(cmp > 0){
                exch(a, r, gt--);
            }else if(cmp < 0){
                exch(a, r++, lt++);
            }else{
                r++;
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*测试主函数*/
    public static void main(String[] args) {
        Character[] a = {'a','b','a','a','a','b','b'};
        Num5.sort(a);
        PrintArray<Character> show = new PrintArray<>();
        show.print(a);
    }

}
