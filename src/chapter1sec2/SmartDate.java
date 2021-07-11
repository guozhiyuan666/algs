package chapter1sec2;

import chapter1sec3.Queue;
import edu.princeton.cs.algs4.In;

import java.util.Scanner;

//Num11-14
public class SmartDate {
    private int day;
    private int month;
    private int year;
    public SmartDate(String dmy){ //构造函数，参数为字符串
        String[] result;
        result= dmy.split("/");
        this.day = Integer.parseInt(result[0]);
        this.month = Integer.parseInt(result[1]);
        this.year = Integer.parseInt(result[2]);
    }
    public SmartDate(int day, int month, int year)//构造函数，参数为整数
    {
        if(isValied(day, month, year)) throw new RuntimeException("无效日期");

        this.day = day;
        this.month = month;
        this.year = year;
    }
    //用readInts的模板写一个readDates
    public static SmartDate[] readDates(){
        Scanner in = new Scanner(System.in);
        //In in = new In(string);
        Queue<SmartDate> dateQueue = new Queue<>();
        while(in.hasNext()){
            SmartDate s = new SmartDate(in.next());
            dateQueue.enqueue(s);
        }

        int size = dateQueue.size();
        SmartDate[] datesArray = new SmartDate[size];
        for(int i = 0; i < size; i++){
            datesArray[i] = dateQueue.dequeue();
        }
        return datesArray;
    }

    public int day(){
        return day;
    }
    public int month(){
        return month;
    }
    public int year(){
        return year;
    }

    private boolean isValied(int day, int month, int year){//检查是否是无效日期
        boolean valid = false;
        if(month > 12) return true;

        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//忽略闰年
        if(day < 1 || year < 1 || month < 1 || day > days[month - 1] ) valid = true;
        return valid;
    }

    public String toString(){
        return " " + this.year + "/" + this.month + "/" + this.day;
    }

    public boolean equals(Object x){
        if(this == x)                       return true;                          //内存地址相同             true
        if(x == null)                       return false;                         //x为null                false
        if(x.getClass() != this.getClass()) return false;                         //x和this不是一个类的对象   false
        SmartDate that = (SmartDate) x;                                           //x和this都是SmartDate的对象
        if(this.year != that.year)          return false;                         //检查x和this这两个对象的状态是否相同
        if(this.month != this.month)        return false;
        if(this.day != this.day)            return false;
        return true;
    }

}
