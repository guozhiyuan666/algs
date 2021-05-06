package chapter2sec1;

public class Shell {
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
                for(int j = i; j >= h && less(a[j],a[j - h]); j-=h){
                    exch(a,j,j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5,5,9,8,7,-10,6,9,6,1,5,6,1,8,2,8,9,3,-8,20,-9,41,-5,-31,4};
        //show(a);
        Shell.sort(a);
        show(a);
    }
}
