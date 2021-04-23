package chapter1sec2;
//Num10
import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {
    private int counter = 0;
    private int N = 0;
    int operationTimes = 0;
    private int max= 0;

    public VisualCounter(int N, int max){
        this.N = N;
        this.max = max;
    }
    public void increment(){
        if(Math.abs(counter) <= max && operationTimes <= N){
            operationTimes++;
            counter++;

            plotDraw();
        }
    }
    public void decremnet(){
        if(Math.abs(counter) <= max && operationTimes <= N){
            operationTimes++;
            counter--;

            plotDraw();
        }
    }
    public int totally(){
        return counter;
    }
    public void plotDraw(){
        StdDraw.point(operationTimes, this.totally());
    }
}
