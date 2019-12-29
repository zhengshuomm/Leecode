//Input: 
//["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
//[[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
//Output: 
//[null,null,null,null,null,null,73,null,null,null,141]
//
//Explanation: 
//Leaderboard leaderboard = new Leaderboard ();
//leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
//leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
//leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
//leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//leaderboard.top(1);           // returns 73;
//leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
//leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
//leaderboard.top(3);           // returns 141 = 51 + 51 + 39;

class Leaderboard {
    Map<Integer, Integer> map;

    public Leaderboard() {
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int res = 0;
        while (K > 0 && !pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res += entry.getValue();
            K--;
        }
        return res;
    }
    
    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */