package com.luo.leetcode;
import java.util.*;
public class MeetingRoomsII_253 {
    /*
    * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
    * find the minimum number of conference rooms required.*/
    //[[0, 30],[5, 10],[15, 20]]
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int n = intervals.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(intervals[0].end);
        for(int i=1;i<n;i++){
            if(intervals[i].start>=pq.peek())pq.poll();
            pq.add(intervals[i].end);
        }
        return pq.size();
    }

    public int minMeetingRoomsFast(Interval[] intervals){
        int n = intervals.length;
        int[]starts = new int[n];
        int[]ends = new int[n];
        for(int i=0;i<n;i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int startIdx = 0,endIdx = 0,res = 0,count = 0;
        while(startIdx<n&&endIdx<n){
            if(starts[startIdx]<ends[endIdx]){
                count++;
                startIdx++;
            }else{
                count--;
                endIdx++;
            }
            res = Math.max(res,count);
        }
        return res;
    }
}
