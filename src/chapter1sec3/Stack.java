package chapter1sec3;

public class Stack<Item> {
    private int N = 0;
    private Node first;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty() { return N == 0; }
    public int size(){ return N;}
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop(){
        if(!isEmpty()){
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }else{
            throw new RuntimeException("栈为空");
        }
    }

}
