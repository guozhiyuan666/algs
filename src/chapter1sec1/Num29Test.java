package chapter1sec1;

public class Num29Test {
    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,4,6};
        int b = BinarySearch.rank2(3,a);
        System.out.println(b);

        int c = BinarySearch.count(3,a);
        System.out.println(c);

        for(int i = b; i < b + c ; i++)  //a[b]到a[b+c-1]就是和key相等的元素
        {
            System.out.println(a[i]);
        }
    }
}
