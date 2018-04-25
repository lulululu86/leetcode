package com.luo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class MovingAverageFromDataStream_346 {
    /*Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3*/
    private List<Integer> list;
    private int size;
    private int sum;
    public MovingAverageFromDataStream_346(int size){
        list = new LinkedList<Integer>();
        this.size = size;
        sum = 0;
    }
    public double next(int val){
        if(list.size()<size){
            list.add(val);
            sum += val;
            return (double)sum/list.size();
        }else{
            sum-=list.get(0);
            list.remove(0);
            list.add(val);
            sum+=val;
            return (double)sum/size;
        }
    }
}
