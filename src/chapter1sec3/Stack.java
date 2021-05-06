package chapter1sec3;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private int N = 0;
    private Node first;

    private class Node{
        Item item;
        Node next;
        Node(){}
        Node(Node x){//构造方法，复制一个节点
            this.item = x.item;
            this.next = x.next;
        }
    }

    Stack(){}
//构造函数，传入参数s，得到s的一个个副本,第一种解法。
    public Stack(Stack<Item> s){
        Stack<Item> t1 = new Stack<>();
        for(Item i : s){
            t1.push(i);
        }
        for(Item j : t1){
            this.push(j);
        }
    }


/*
    public Stack(Stack<Item> s){
        if(s.first != null){
            this.first = new Node(s.first);
            for(Node x = this.first; x.next != null; x = x.next){
                x.next = new Node(x.next);
            }
        }
    }
*/

    public boolean isEmpty() { return N == 0; }
    public int size(){ return N;}

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
 //弹出元素
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
    //返回栈顶元素的值，但不删除
    public Item peek(){
        if(!isEmpty()){
            return first.item;
        }else{
            throw new RuntimeException("栈为空");
        }
    }

    public Iterator<Item> iterator(){
        return new StackIterator();
    }
    public class StackIterator implements Iterator<Item>{
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item;
            item = current.item;
            current = current.next;
            return item;
        }
    }


}
