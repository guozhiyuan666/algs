package chapter1sec3;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private int N;
    private Node first;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){ return N == 0;}
    public int size() {return N;}

    //添加一个元素
    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Iterator<Item> iterator(){
        return new iteratorOfBag();
    }
    public class iteratorOfBag implements Iterator<Item>{
        Node current = first;
        public boolean hasNext(){return current != null;}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
