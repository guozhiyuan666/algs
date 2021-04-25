package chapter1sec3;

import java.util.Iterator;

/**
 * 实现一个双向队列
 */
public class Deque<Item> implements Iterable<Item>{
    private int N;
    private DoubleNode head;
    private DoubleNode tail;
    private class DoubleNode{
        Item item;
        DoubleNode next;
        DoubleNode before;
    }

    public boolean isEmpty(){return N == 0;}
    public int size(){ return N; }

    //从左端添加一个新元素
    public void pushLeft(Item item) {
        DoubleNode doublenode = new DoubleNode();
        doublenode.item = item;
        if(isEmpty()){
            head = doublenode;
            tail = head;
        }else{
            DoubleNode oldhead = head;
            head = doublenode;
            head.next = oldhead;
            oldhead.before = head;
        }
        N++;
    }

    //从右端添加一个新元素
    public void pushRight(Item item){
        DoubleNode doublenode = new DoubleNode();
        doublenode.item = item;
        if(isEmpty()){
            tail = doublenode;
            head = tail;
        }else{
            DoubleNode oldtail = tail;
            tail = doublenode;
            tail.before = oldtail;
            oldtail.next = tail;
        }
        N++;
    }

    //从左端返回一个元素并删除他
    public Item popLeft(){
        if(isEmpty()){throw new RuntimeException("尝试从左端删除元素时，双向队列为空");}
        Item item;
        if(size() == 1){
            item =head.item;
            head = null;
            tail = null;
        }else{
            item = head.item;
            head = head.next;
            head.before = null;
        }
        N--;
        return item;
    }
    //从右端返回元素并删除该元素
    public Item popRight() {
        if (isEmpty()) {
            throw new RuntimeException("尝试右左端删除元素时，双向队列为空");
        }
        Item item;
        if (size() == 1) {
            item = tail.item;
            head = null;
            tail = null;
        }else{
            item = tail.item;
            tail = tail.before;
            tail.next = null;
        }
        N--;
        return item;
    }

    public Iterator<Item> iterator(){
        return new DequeIterator();
    }
    public class DequeIterator implements Iterator<Item> {
        DoubleNode current = head;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item;
            item = current.item;
            current = current.next;
            return item;
        }
    }



}
