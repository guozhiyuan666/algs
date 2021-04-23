package chapter1sec3;

import java.util.Iterator;

public class LinkedBag <Item> implements Iterable<Item>
{
    private int N;
    private Node first;
    class Node
    {
           Item item;
           Node next;
    }
    public void add(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Iterator<Item> iterator()
    {
        return new BagIterator();
    }
    private class BagIterator implements Iterator<Item>
    {
        Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
           Item item = current.item;
           current = current.next;
           return item;
        }
    }


}
