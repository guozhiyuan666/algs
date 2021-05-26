package chapter2sec3;

import chapter2sec2.PrintArray;

/*
有大量重复元素时，三向切分的快速排序
 */
public class Quick3way {
    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int flag = v.compareTo(a[i]);
            if(flag > 0) exch(a, i, lt++);
            else if(flag < 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /*测试主函数*/
    public static void main(String[] args) {
        Character[] a = {'T','A','A','T','E','E','E','P','T','I','M','T','T','X','O','A'};
        Quick3way.sort(a);
        PrintArray<Character> show = new PrintArray<>();
        show.print(a);
    }

}
