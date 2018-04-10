package com.luo.leetcode;
import java.util.*;
public class MeetingRooms_252 {
    /*
    * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * determine if a person could attend all meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return false.
    * */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start==o2.start?o1.end-o2.end:o1.start-o2.start;
            }
        });
        int n = intervals.length;
        for(int i=1;i<n;i++){
            if(intervals[i].start<intervals[i-1].end)return false;
        }
        return true;
    }
}
