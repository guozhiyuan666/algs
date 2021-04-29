package chapter1sec3;

public class Queue<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){return N == 0;}
    public int size() {return N;}

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }
    public Item dequeue(){
        if(!isEmpty()){
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }else{
            throw new RuntimeException("队列为空");
        }
    }
    //练习1.3.47 可连接的队列
    public void catenation(Queue<Item> a){
        while(!a.isEmpty())
            this.enqueue(a.dequeue());
    }
}
