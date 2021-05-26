package chapter2sec2;

public class Num2 {
    private static Comparable[] aux;
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++){
            if      (i > mid)                         a[k] = aux[j++];
            else if (j > hi)                          a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0)    a[k] = aux[j++];
            else                                      a[k] = aux[i++];
        }
        show(a, lo, mid, hi);
    }
    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        sort(a, 0, N - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if( lo >= hi) return;
        int mid = (hi + lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a,lo, mid, hi);
    }

    public static void show(Comparable[] a, int lo, int mid, int hi){
        System.out.print(lo + " " + mid + " " + hi + " ");
        for(int i = 0; i < a.length; i++){
            System.out.print( a[i] + " ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        Character[] a = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};
        Num2.sort(a);
        PrintArray<Character> show = new PrintArray<>();
        show.print(a);
    }
}
