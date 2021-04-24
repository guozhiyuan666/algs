package chapter1sec2;

public class SmartDateTest {
    public static void main(String[] args) {
//        int d = 15;
//        int m = 10;
//        int y = 2031;
//        SmartDate a = new SmartDate(d, m, y);
//        System.out.println(a);

        //控制台输入：15/10/2021 15/10/2011 15/10/2001
        SmartDate[] dateArray = SmartDate.readDates();
        for(int i = 0; i < dateArray.length; i++){
            System.out.println(dateArray[i]);
        }

    }
}
