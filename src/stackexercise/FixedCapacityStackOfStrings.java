package stackexercise;

public class FixedCapacityStackOfStrings
{
    private String[] str;
    private int N;
    private int FULL;
    public FixedCapacityStackOfStrings(int cap) { str = new String[cap]; FULL = cap; }
    public void push(String item)               { str[N++] = item; }
    public String pop()                         { return str[--N]; }
    boolean isEmpty()                           { return N == 0; } //N=0,返回真
    public int size()                           { return N; }
    public boolean isFull()                     {return  N == FULL;}
}
