package chapter1sec3;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();

        dll.insertAtHead(1);
        dll.insertAtTail(2);

        dll.insetBeforeNode(1,0);
        dll.insetAfterNode(2,0);
        dll.deleteDouleNode(1);
        //dll.insetAfterNode(3,0);//抛出未找到节点的异常
        for(Integer i : dll) {
            System.out.println(i);
        }

        //System.out.println(dll.size());
    }
}
