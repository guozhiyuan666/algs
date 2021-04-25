package chapter1sec3;

import java.util.Iterator;

/**
 * 练习1.3.31 实现一个双向链表及若干方法
 */
public class DoubleLinkedList<Item> implements Iterable<Item> {
    private int N;
    private DoubleNode head;
    private DoubleNode tail;

    private class DoubleNode {
        Item item;
        DoubleNode next;
        DoubleNode before;
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }

    //表头添加节点
    public void insertAtHead(Item item) {
        DoubleNode doubleNode = new DoubleNode();
        doubleNode.item = item;
        if (isEmpty()) {
            head = doubleNode;
            tail = head;
        } else {
            DoubleNode oldhead;
            oldhead = head;
            head = doubleNode;
            head.next = oldhead;
            oldhead.before = head;
        }
        N++;
    }

    //表尾添加节点
    public void insertAtTail(Item item) {
        DoubleNode doubleNode = new DoubleNode();
        doubleNode.item = item;
        if (isEmpty()) {
            tail = doubleNode;
            head = tail;
        } else {
            DoubleNode oldtail;
            oldtail = tail;
            tail = doubleNode;
            oldtail.next = tail;
            tail.before = oldtail;
        }
        N++;
    }

    //表头删除节点
    public void deleteAtHead() {
        if (isEmpty()) {
            throw new RuntimeException("尝试在表头删除元素时，表为空");
        }
        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.before = null;
        }
        N--;
    }

    //表尾删除节点
    public void deleteAtTail() {
        if (isEmpty()) {
            throw new RuntimeException("尝试在表尾删除元素时，表为空");
        }
        if (size() == 1) {
            tail = null;
            head = null;
        } else {
            tail = tail.before;
            tail.next = null;
        }
        N--;
    }

    //找到指定item的节点,并返回该节点。若找不到则返回 current = null
    private DoubleNode findItem(Item item) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空");
        }
        DoubleNode current;
        for (current = head; current != null; current = current.next) {
            if (current.item.equals(item)) {
                break;
            }
        }
        return current;
    }

    //在指定节点前插入节点，根据item找到链表的节点（有重复元素怎么办）
    public void insetBeforeNode(Item doubleNodeitem, Item newDoubleNodeItem) {
        //调用findItem()方法,找到由item指定的节点，若找不到则返回null
        DoubleNode current = findItem(doubleNodeitem);

        DoubleNode newDoubleNode = new DoubleNode();
        newDoubleNode.item = newDoubleNodeItem;

        if (current == head) { //首节点.before为null所以单独添加
            insertAtHead(newDoubleNodeItem);
        }
        else if (current != null) {
            DoubleNode beforecurrent = current.before;
            beforecurrent.next = newDoubleNode;
            newDoubleNode.next = current;
            current.before = newDoubleNode;
            newDoubleNode.before = beforecurrent;
        } else{
            throw new RuntimeException("未找到指定节点");
        }
        N++;
    }

    //在指定节点后删除节点,根据item找到链表的节点（有重复元素怎么办）
    public void insetAfterNode(Item doubleNodeitem,Item newDoubleNodeItem){
        DoubleNode current = findItem(doubleNodeitem);

        DoubleNode newDoubleNode = new DoubleNode();
        newDoubleNode.item = newDoubleNodeItem;
        if(current == tail){
            insertAtTail(newDoubleNodeItem);
        }
        else if(current != null){
            DoubleNode aftercurrent = current.next;
            aftercurrent.before = newDoubleNode;
            newDoubleNode.before = current;
            current.next = newDoubleNode;
            newDoubleNode.next = aftercurrent;
        } else{
            throw new RuntimeException("未找到指定节点");
        }
        N--;
    }

    //删除指定节点
    public void deleteDouleNode(Item item){
        DoubleNode current = findItem(item);
        if(current == head){
            deleteAtHead();
        }
        else if(current == tail){
            deleteAtTail();
        }
        else{
            current.before.next = current.next;
            current.next.before = current.before;
        }
        N--;
    }

    //实现迭代器
    public Iterator<Item> iterator(){
        return new DoubleLinkedListIterator();
    }
    public class DoubleLinkedListIterator implements Iterator<Item>{
        DoubleNode current = head;

        public boolean hasNext(){return current != null;}
        public Item next(){
            Item item;
            item = current.item;
            current = current.next;
            return item;
        }
    }
}

