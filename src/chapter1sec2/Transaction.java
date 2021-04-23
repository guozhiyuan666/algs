package chapter1sec2;

import edu.princeton.cs.algs4.Date;

public class Transaction {
    private String name;
    private SmartDate when;
    private double amount;
    public Transaction(String trans){
        String[] result;
        result= trans.split(" ");
        this.name = result[0];
        this.when = new SmartDate(result[1]);
        this.amount = Double.parseDouble(result[2]);
    }
    public Transaction(String name, SmartDate when, double amount){
        this.name = name;
        this.when = when;
        this.amount = amount;
    }
    public String who(){
    return name;
    }
    public SmartDate when()
    {
        return when;
    }
    public double amount(){
        return amount;
    }
    public String toString(){
        return " " + name + " " + when + " " + amount;
    }
    public boolean equals(Object x){
        if(this == x) return true;
        if(x == null) return false;
        if(this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction)x;
        if(this.name != that.name) return false;
        if(this.when != that.when) return false;
        if(this.amount != that.amount) return false;
        return true;

    }

}
