package chapter1sec3;

public class LinkedQueue <Item>
{
    private Node first;
    private Node last;
    private int N;
    class Node{
        private Item item;
        private Node next;
    }
    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(N == 0)
        {
            first = last;
        }
        else
        {
            oldlast.next = last;
        }
        N++;
    }
    public Item dequeue()
    {
        if(N == 0)
        {
            first = null;
            last = null;
            return null;
        }else{
            Item item = first.item;
            first = first.next;
            return item;
        }
    }
}
