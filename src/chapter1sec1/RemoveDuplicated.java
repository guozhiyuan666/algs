package chapter1sec1;

public class RemoveDuplicated {
    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,4,6};
        int[] b = BinarySearch.removeduplicated(a);
        for(int i = 0; i < b.length; i ++)
        {
            System.out.println(b[i]);
        }
    }
}
