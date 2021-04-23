package chapter1sec2;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounterTest {
    public static void main(String[] args) {
        VisualCounter a = new VisualCounter(5,5);
        StdDraw.setYscale(0.0, 10);
        StdDraw.setXscale(0.0, 10);
        StdDraw.setPenRadius(0.005);
        a.increment();
        a.increment();
        a.decremnet();
        a.decremnet();
        a.increment();

//        for(int j = 0; j < 20; j++){
//            a.decremnet();
//            StdDraw.point((50+j) * 0.01, a.totally() * 0.01);
//        }

    }
}
