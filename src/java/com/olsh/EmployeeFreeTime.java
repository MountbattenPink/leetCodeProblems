/*
759. Employee Free Time

We are given a list schedule of employees, which represents the working time for each employee.
Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays.
For example, 
schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  
Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

Example 1:

Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:

Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
*/


package com.olsh;
import com.olsh.entities.Interval;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Integer>queue = new ArrayList<>();
        for (List<Interval>singleSchedule:schedule){
            for (Interval interval:singleSchedule){
                queue.add(interval.start);
                queue.add(interval.end);
            }
        }
        Collections.sort(queue);
        List<Interval>list = new ArrayList<>();
        int x=-1;
        for (int i:queue){
            if (x>=0 && x!=i)
                list.add(new Interval(x,i));
                x=i;
        }
        for (List<Interval> l: schedule){
            for (Interval i: l){
                Iterator<Interval>it = list.iterator();
                while(it.hasNext()){
                    Interval i1=it.next();
                    if (i.start<=i1.start && i.end>=i1.end){
                        it.remove();
                    }
                }
            }
        }
        return list;
    }
}
