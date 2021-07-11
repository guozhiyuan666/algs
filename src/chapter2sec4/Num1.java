package chapter2sec4;

public class Num1 {
    public static void main(String[] args) {
        Character[] in = {'P','R','I','O','*','R',
                          '*','*','I','*','T','*','Y','*',
                          '*','*','Q','U','E','*',
                          '*','*','U','*','E'};
        MaxPQ<Character> pq = new MaxPQ<>();
        for(char i : in){
            if(i == '*'){
                System.out.print(pq.delMax() + " ");
            } else{
                pq.insert(i);
            }
        }
        if(!pq.isEmpty()){
            System.out.println("队列里还剩下:" + pq.delMax());
        }
    }
}
