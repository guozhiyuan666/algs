package chapter2sec2;

import chapter1sec2.Transaction;

//打印任何类型的数组
public class PrintArray<Item>{
    public void print(Item[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }


}
