package chapter1sec3;

import java.awt.event.ItemEvent;
import java.util.Iterator;

/**
 * 练习1.3.33第二问 用动态数组实现Deque
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {
    Item[] a = (Item[]) new Object[5];
    private int size;
    private int head = 5 / 2;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int cap) {
        int start = cap / 2 - size / 2;
        Item[] temp = (Item[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            temp[i + start] = a[head + 1 + i];
        }
        head = start - 1;
        a = temp;
    }

    public void pushLeft(Item item) {
        a[head] = item;
        head--;
        size++;
        if (head < 0) {
            if (size > a.length / 2) {
                resize(a.length * 2);
            } else {
                resize(a.length);
            }
        }

    }

    public void pushRight(Item item) {
        a[head + size + 1] = item;
        size++;
        if (head + size + 1 == a.length - 1) {//!!!!!!!!!!!!!!!!!
            if (size > a.length / 2) {
                resize(a.length * 2);
            } else {
                resize(a.length);
            }
        }

    }

    public Item popLeft() {
        if (isEmpty()) {
            throw new RuntimeException("尝试从左端删除元素时，队列为空");
        }
        Item item;
        item = a[head + 1];
        a[head + 1] = null;
        head++;
        size--;
        if (size == a.length / 4) {
            resize(a.length / 2);
        } 
        return item;
    }

    public Item popRight() {
        if (isEmpty()) {
            throw new RuntimeException("尝试从右端删除元素时，队列为空");
        }
        Item item;
        item = a[head + size];
        a[head + size] = null;
        size--;
        if (size == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * 实现迭代器,数组类型用索引即可
     */
    public Iterator<Item> iterator(){
        return new ResizingArrayDequeIterator();
    }
    public class ResizingArrayDequeIterator implements Iterator<Item>{
        int current = head + 1;
        int last = head + size;
        public boolean hasNext(){
            return current <= last;
        }
        public Item next(){
            Item item = a[current];
            current++;
            return item;
        }
    }
}


