package stackexercise;

public class LinkedStack <Item>
{
    private int N;
    private Node first;
    class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop()
    {
        if(N == 0)
        {
            return null;
        }else {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }
    }
    public Item peek()    //练习1.3.7
    {
        return first.item;
    }
}
