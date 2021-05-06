package chapter2sec1;

public class Num8 {
    public static boolean less(Comparable v, Comparable w)  { return v.compareTo(w) < 0; }
    public static void exch(Comparable[] a, int i, int j)   { Comparable temp = a[i]; a[i] = a[j]; a[j] = temp; }
    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
    public boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length - 1; i++){
            if(!less(a[i],a[i+1])) return false;
        }
        return true;
    }

    public static void sort(Comparable[] a){
        int h = 1;
        int N = a.length;
        while(h < N / 3) { h = h * 3 + 1;} //1 4 13 40
        while(h >= 1){

            for(int i = h; i < N; i++){
                int q = i;
                for(int j = i; j >= h && less(a[j],a[j - h]); j-=h){
                   q = j - h;
                    exch(a,j,j - h);
                }
                System.out.print("\n" + h + "sort  " + i + " " + q + "     ");
                show(a);
            }

            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Character[] a = {'E', 'A', 'S', 'Y', 'S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        Num8.sort(a);

    }
}
