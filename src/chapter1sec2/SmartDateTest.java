package chapter1sec2;

public class SmartDateTest {
    public static void main(String[] args) {
//        int d = 15;
//        int m = 10;
//        int y = 2031;
//        SmartDate a = new SmartDate(d, m, y);
//        System.out.println(a);

        //启动程序后用户在控制台输入：15/10/2021 15/10/2001 15/10/2001
        SmartDate[] dateArray = SmartDate.readDates();
        for(int i = 0; i < dateArray.length; i++){
            System.out.println(dateArray[i]);
        }

        System.out.println("两个对象状态是否相等："+ dateArray[1].equals(dateArray[2]) );

    }
}
