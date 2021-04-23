package stackexercise;

public class FixedCapacityStack <Item>
{
    int N;
    private Item[] a;
    public FixedCapacityStack(int cap) {
       a = (Item[]) new Object[cap]; //有类型擦除，item就没了，被擦除了
    }
    public void push(Item item){
        a[N++] = item;
    }
    public  Item pop(){
        return a[--N];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
}
