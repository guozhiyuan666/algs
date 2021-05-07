package chapter2sec1;

import chapter1sec2.Transaction;

public class SortTransaction {
    public static void main(String[] args) {
        Transaction a1 = new Transaction("小a 2021/01/03 100");
        Transaction a2 = new Transaction("小h 2021/01/05 123");
        Transaction a3 = new Transaction("小b 2021/01/09 98");
        Transaction a4 = new Transaction("小v 2021/01/09 60");
        Transaction a5 = new Transaction("小n 2021/01/08 139");
        Transaction[] b ={a1, a2, a3, a4, a5};
        showTransaction(b);
        Selection.sort(b);
        showTransaction(b);
    }
    public static void showTransaction(Transaction[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        System.out.println("\n");
    }
}
