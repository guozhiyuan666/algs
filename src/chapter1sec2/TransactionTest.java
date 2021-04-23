package chapter1sec2;

import edu.princeton.cs.algs4.Date;

public class TransactionTest {
    public static void main(String[] args) {
        String name = "小明";
        SmartDate when = new SmartDate(12,12,2021);
        double amount = 200.3;

        Transaction atran1 = new Transaction(name, when, amount);
        Transaction atran2 = new Transaction("大明", when, amount);
        Transaction atran3 = atran2;
        Transaction atran4 = new Transaction("大明 11/12/2021 22.3");

        System.out.println(atran1);
        System.out.println(atran4);
        if(atran2.equals(atran1)) System.out.println("值相等");
        else System.out.println("值不相等");

    }
}
