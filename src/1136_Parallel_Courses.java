//There are N courses, labelled from 1 to N.
//
//We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.
//
//In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
//
//Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.

//Input: N = 3, relations = [[1,3],[2,3]]
//Output: 2
//Explanation: 
//In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.

class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[N+1];
        for(int[] r : relations){
            indegree[r[1]]++;
            map.putIfAbsent(r[0], new HashSet<>());
            map.get(r[0]).add(r[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> lst = new ArrayList<>();
        for(int i=1;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.offer(i);
                lst.add(i);
            }
        }
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int cur = q.poll();
                for(int nei : map.getOrDefault(cur, new HashSet<>())){
                    indegree[nei]--;
                    if(indegree[nei] == 0){
                        q.offer(nei);
                        lst.add(i);
                    }
                }
            }
            res++;
        }
        return lst.size() == N ? res : -1;
    }
}