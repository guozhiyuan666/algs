package chapter1sec3;

public class Num20Test {
    public static void main(String[] args) {
        //删除最后一个元素测试用例
        Num20<Integer> linkedList = new Num20<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.deleteLastItem();
        linkedList.deleteLastItem();

        for(Integer i : linkedList ){
            System.out.println(i);
        }

        /* 20题delete方法，测试用例
        Num20<Integer> linkedList = new Num20<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        for(Integer i : linkedList ){
            System.out.println(i);
        }
        linkedList.delete(1);
        linkedList.delete(1);
        for(Integer i : linkedList ){
            System.out.println(i);
        }

         */

        /* 21题测试用例
        Num20<String> linkedList = new Num20<>();
        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("cc");
        linkedList.add("dd");
        System.out.println(Num20.find(linkedList,"EE"));
         */
        /*24题测试用例
        Num20<String> linkedList = new Num20<>();
        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("cc");
        linkedList.add("dd");
        linkedList.removeAfter(linkedList.creatNode("aa"));
        for(String i : linkedList ){
            System.out.println(i);
        }
         */
        /*25题测试用例
        Num20<String> linkedList = new Num20<>();
        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("cc");
        linkedList.add("dd");
        System.out.println(linkedList.size());
        linkedList.insertAfter(linkedList.creatNode("aa"),linkedList.creatNode("22"));
        for (String i : linkedList) {
            System.out.println(i);
        }
        System.out.println(linkedList.size());

         */
        /* 26题测试用例
        Num20<String> linkedList = new Num20<>();
        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("bb");
        linkedList.add("dd");
        System.out.println(linkedList.size());
        linkedList.remove(linkedList,"bb");
        for(String i : linkedList ) System.out.println(i);
        System.out.println(linkedList.size());

         */
       /* 27,28题测试用例
        Num20<Integer> linkedList = new Num20<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.maxRecursive(linkedList.creatNode(1),1 ));
        */


    }

}
