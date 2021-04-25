package chapter1sec3;

import java.util.Iterator;

/**
 * Created by Rene kuo
 * 实现一个链表，练习20题，给链表添加一个delete()方法,接收参数k,删除链表第k个元素
 */
public class Num20<Item> implements Iterable<Item>{

    private int N = 0;
    private Node first;
    private Node last;
    private class Node{
        Item item;
        Node next;
    }
    //创建一个节点方法，Node为私有类，无法直接在类的为外部创建,该方法提供给24,25题使用
    public Node creatNode(Item item){
        Node node = new Node();
        node.item = item;
        return node;
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    //添加一个元素
    public void add(Item item){
        if(isEmpty()){
            last = new Node();
            last.item = item;
            last.next = null;
            first = last;
        }else{
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            oldlast.next = last;
        }
        N++;
    }
    //删除最后一个元素
    public void deleteLastItem(){
        if(size() == 1) {first = null;}
        else{
            Node current = first;
            while(current.next.next != null){
                current = current.next;
            }
            current.next = null;
        }
        N--;
    }
    //20题，删除第k个元素
    public void delete(int k){
        if(k > size() || k < 0 || isEmpty()) {throw new RuntimeException("超出索引范围");}
        else if(k == 1){first = first.next;}
        else{
            int count = 1;
            for(current = first; current != null; current = current.next){
                if(count == k - 1 && current.next != null){
                    current.next = current.next.next;
                    break;
                }
                count++;
            }
            }
        N--;
    }
    //21题，编写一个find()方法，参数：一个链表，一个字符串key，若该链表某结点的item值为key则返回true
    public static boolean find(Num20<String> linkedList, String key){
        for(String i : linkedList ){
            if(i.equals(key)){return true;}
        }
        return false;
    }
    //24题，removeAfter()方法,???没读懂题目，什么是删除后续节点。。。
    //原来后续节点指的是后面一个节点，此题优点小bug，当多节点的item相同时，无法辨别要删除那个节点后面的元素
    //这个练习感觉真没啥意思。
    public void removeAfter(Node node) {
        if(node == null || isEmpty() ){ return;}
            Node current;
            for( current = first; current != null; current = current.next){
                if(current.item == node.item){
                    if(current.next != null)
                    current.next = current.next.next;
                    N--;
                    break;
                }
            }
        }
    //25题，接受两个节点做参数，将第二个节点插入第一个节点之后（我理解的：第一个节点在链表中，第二个节点不在链表中）
    public void insertAfter(Node node1, Node node2){
        if(node1 == null || node2 == null) {return;}
        Node current;
        for(current = first; current != null; current = current.next){
            if(current.item == node1.item ){
                node2.next = current.next;
                current.next = node2;
                N++;
            }
        }
    }
    //26题，remove()方法，参数：一个链表，字符串key，删除所有item为key的节点
    public void remove(Num20<String> linkedList, String key){
        if(isEmpty()) {throw new RuntimeException("链表为空");}
        Node current;
        while(first.item == key){
            first = first.next;
            N--;
        }
        current = first;
        while(current != null){
            if(current.next != null && current.next.item == key){
                current.next = current.next.next;
                N--;
                continue;
            }
            current = current.next;
        }
    }
    //27题，返回链表中的最大值，链表件均为整数
    public int max(){
        if(isEmpty()){return 0;}
        if(size() == 1) {return (Integer) first.item;}
        Node current = first;
        int temp;
        temp = (Integer)current.item;
        for(current = first; current.next != null; current = current.next){
            if(temp < (Integer)current.next.item){
                temp = (Integer)current.next.item;
            }
        }
        return temp;
    }
    //递归解27题,无语。。用这个方法之前还得自己用Node写一个链表，把头节点放进去。。没啥意思
    Node current = first;
    public int maxRecursive(Node node,int currentMax){
        if(current == null) {return currentMax;}

        int cuurentValue = (Integer) current.item;

        if(cuurentValue > currentMax){
            currentMax = cuurentValue;
        }
        return maxRecursive(current.next, currentMax);
    }

    //实现可迭代接口的iterator方法，该方法返回一个迭代器对象
    public Iterator<Item> iterator() {
        return new linkedListIterator();
    }
    //写一个迭代器类,实现Iterator接口里的hasNext()和next()方法
    public class linkedListIterator implements Iterator<Item> {
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
