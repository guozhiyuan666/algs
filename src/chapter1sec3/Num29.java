package chapter1sec3;

/**
 * 29题，用环形链表实现Queue
 */
public class Num29<Item> {
    private int N;
    private Node last;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    public void enqueue(Item item){
        Node node = new Node();
        node.item = item;
        if(isEmpty()){
            last = node;
            last.next = last; //指向自身
        }else {
            node.next = last.next;
            last.next = node;
            last = node;
        }
        N++;
    }
    public Item dequeue(){
        Item item;
        if(isEmpty()){throw new RuntimeException("队列为空");}
        else if(size() == 1){
            item = last.item;
            last = null;
        }
        else {
            item = last.next.item;
            last.next = last.next.next;
        }
        N--;
        return item;
    }

}
