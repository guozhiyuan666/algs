package chapter2sec4;
/*
练习2.4.30 动态查找中位数
 */
public class DynamicMedianFinding{

    int size = 0;

    MaxPQ<Double> maxPQ;//比中位数小的放在这
    MinPQ<Double> minPQ;//比中位数大的放在这
    DynamicMedianFinding(){
        maxPQ = new MaxPQ<>(20);
        minPQ = new MinPQ<>();
    }

    public void insert(Double value){
        if(size == 0 || value.compareTo(findMedian()) < 0){
            maxPQ.insert(value);
        } else{
            minPQ.insert(value);
        }

        if(minPQ.size() > maxPQ.size() + 1){
            maxPQ.insert(minPQ.delMin());
        }else if(maxPQ.size() > maxPQ.size() + 1){
            minPQ.insert(maxPQ.delMax());
        }
        size++;
    }

    public Double findMedian(){
        if(maxPQ.size() >= minPQ.size()){
            return maxPQ.getMax();
        }else{
            return minPQ.getMin();
        }
    }

    public void delMedian(){
        if(maxPQ.size() >= minPQ.size()){
            maxPQ.delMax();
        }else{
            minPQ.delMin();
        }
        size--;
    }

    /*测试函数*/
    public static void main(String[] args) {
        DynamicMedianFinding dmf = new DynamicMedianFinding();
        dmf.insert(1.0);
        dmf.insert(2.0);
        dmf.insert(3.0);
        dmf.insert(4.0);
        dmf.insert(5.0);
        dmf.insert(10.0);
        dmf.insert(-1.0);
        System.out.println(dmf.findMedian());//输出3.0
        dmf.delMedian();
        dmf.insert(5.0);
        System.out.println(dmf.findMedian());//输出2.0
    }

}
