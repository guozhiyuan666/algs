package Chapter3sec1;

public class BSTTest {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        bst.put("a" , 1);
        System.out.println(bst.get("a"));
    }
}
