package chapter1sec3;

public class Joseph {


    public static void josephProblem(int peoples, int num){
        Queue<Integer> a = new Queue<>();
        for(int i = 0; i < peoples; i++){
            a.enqueue(i);
        }
        while(peoples > 0){
            for(int j = 1; j < num; j++){
                a.enqueue(a.dequeue());
            }
            System.out.println(a.dequeue());
            peoples--;
        }
    }

    public static void main(String[] args) {
        josephProblem(7,2);
    }
}
