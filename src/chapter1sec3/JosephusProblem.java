package chapter1sec3;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 用队列解决约瑟夫环问题，出队以后入队，形成一个环形队列
 */
public class JosephusProblem {

    private static void josephusProblem(int personOrder, int numberOfPeople) {

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numberOfPeople; i++) {
            queue.add(i);
        }

        while (numberOfPeople > 0) {
            for (int i = 1; i < personOrder; i++) {
                queue.add(queue.poll());
            }
            System.out.print(queue.poll() + " ");
            numberOfPeople--;
        }
    }

    // Parametes example: 2 7
    public static void main(String[] args) {
        int personOrder = 2;
        int numberOfPeople = 7;
        josephusProblem(personOrder, numberOfPeople);
    }

}
