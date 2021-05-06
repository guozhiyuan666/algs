package chapter1sec3;
//merge是选择错了版本，以后在改进一下
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

}
