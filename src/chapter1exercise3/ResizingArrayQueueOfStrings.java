package chapter1exercise3;

public class ResizingArrayQueueOfStrings {
    String[] queue = new String[1];
    private int N;
    private int first = 0;
    private int last = 0;
    public boolean isEmpty() {return N == 0;}
    public int size()        {return N;}

    public void resize(int cap){
        String[] temp = new String[cap];
        for(int i = 0; i < N; i++){
            temp[i] = queue[(first + i) % queue.length];
        }
        queue = temp;
        first = 0;
        last = N;
    }

    public void enqueue(String string){
        if(queue.length == N){resize(2 * queue.length);}
        if(last == queue.length){
            last = 0;
        }
        queue[last++] = string;
        N++;
    }
    public String dequeue(){
        if(N == 0){throw new RuntimeException("空队列");}
        String string;
        string = queue[first++];
        N--;
        if(queue.length / 4 == N){resize(queue.length / 2);}
        if(first == queue.length){
            first = 0;
        }
        return string;
    }
}
