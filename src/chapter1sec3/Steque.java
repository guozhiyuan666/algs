package chapter1sec3;

/**
 * 练习1.3.32
 * @param <Item>
 */
public class Steque<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() { return N == 0; }
    public int size(){ return N; }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = first;
        } else {
            Node oldfirst;
            oldfirst = first;
            first = node;
            first.next = oldfirst;
        }
        N++;
    }
    public Item pop(){
        if(isEmpty()){throw new RuntimeException("尝试删除元素时队列为空");}
        Item item;
        Node current = first;
        item = current.item;
        first = first.next;
        N--;
        return item;
    }

    public void enqueue(Item item){
        Node node = new Node();
        node.item = item;
        if(isEmpty()){last = node;}
        else{
            Node oldlast;
            oldlast = last;
            last = node;
            oldlast.next = last;
        }
        N++;
    }
    //练习1.3.47 可连接的steque
    public void catenation(Steque<Item> a){
        while(!a.isEmpty())
            this.enqueue(a.pop());
    }


}
