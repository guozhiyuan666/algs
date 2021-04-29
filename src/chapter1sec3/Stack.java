package chapter1sec3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private int N = 0;
    private Node first;
    private int popPushTimes;
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
        popPushTimes++;
    }
 //弹出元素
    public Item pop(){
        if(!isEmpty()){
            Item item = first.item;
            first = first.next;
            N--;
            popPushTimes++;
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

    //练习1.3.47 可连接的栈，连接两个同类对象，catenation
    public void catenation(Stack<Item> a) {
        while(!a.isEmpty()){
            this.push(a.pop());
        }
    }
    //快速出错迭代器，当在迭代中pop()或push()时，会抛出异常

    public Iterator<Item> iterator(){
        return new StackIterator();
    }
    public class StackIterator implements Iterator<Item>{
        int jugePopPush  = popPushTimes;
        Node current = first;
        public boolean hasNext(){
            if(jugePopPush !=  popPushTimes){
                throw new ConcurrentModificationException("迭代时尝试删除元素");
            }
            else{
                return current != null;
            }
        }
        public Item next(){
            Item item;
            item = current.item;
            current = current.next;
            return item;
        }
    }
}
