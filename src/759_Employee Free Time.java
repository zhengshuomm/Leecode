// https://massivealgorithms.blogspot.com/2019/01/leetcode-759-employee-free-time.html

//We are given a list schedule of employees, which represents the working time for each employee.
//Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
//Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
//Example 1:
//Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//Output: [[3,4]]
//Explanation:
//There are a total of three employees, and all common
//free time intervals would be [-inf, 1], [3, 4], [10, inf].
//We discard any intervals that contain inf as they aren't finite.
//
//Example 2:
//Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
//Output: [[5,6],[7,9]]

// 可能是airbnb的meeting time

public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
         List<Interval> res = new ArrayList<Interval>();
         PriorityQueue<Node> minHeap = new PriorityQueue<Node>((a,b) -> 
                                             schedule.get(a.employee).get(a.index).start - schedule.get(b.employee).get(b.index).start);
         
         int start = Integer.MAX_VALUE;
         for(int i = 0; i<schedule.size(); i++){
             minHeap.add(new Node(i, 0));
             start = Math.min(start, schedule.get(i).get(0).start);
         }
         
         while(!minHeap.isEmpty()){
             Node cur = minHeap.poll();
             if(start < schedule.get(cur.employee).get(cur.index).start){
                 res.add(new Interval(start, schedule.get(cur.employee).get(cur.index).start));
             }
             
             start = Math.max(start, schedule.get(cur.employee).get(cur.index).end);
             cur.index++;
             if(cur.index < schedule.get(cur.employee).size()){
                 minHeap.add(cur);
             }
         }
         
         return res;
     }
 class Node{
     int employee;
     int index;
     public Node(int employee, int index){
         this.employee = employee;
         this.index = index;
     }
 }