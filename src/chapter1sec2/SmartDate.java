package chapter1sec2;
//Num11-14
public class SmartDate {
    private int day;
    private int month;
    private int year;
    public SmartDate(String dmy){
        String[] result;
        result= dmy.split("/");
        this.day = Integer.parseInt(result[0]);
        this.month = Integer.parseInt(result[1]);
        this.year = Integer.parseInt(result[2]);
    }
    public SmartDate(int day, int month, int year)
    {
        if(isValied(day, month, year)) throw new RuntimeException("无效日期");

        this.day = day;
        this.month = month;
        this.year = year;
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
    private boolean isValied(int day, int month, int year){
        boolean valid = false;
        if(month > 12) return true;

        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//忽略闰年
        if(day < 1 || year < 1 || month < 1 || day > days[month - 1] ) valid = true;
        return valid;
    }

    public String toString(){
        return " " + this.year + "/" + this.month + "/" + this.day;
    }

}
