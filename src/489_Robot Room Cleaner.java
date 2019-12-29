class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        helper(robot, 0, 0, 0, visited);
    }
    
    void helper(Robot robot, int x, int y, int dir, Set<String> visited) {
        robot.clean();
        visited.add(x + "-" + y);
        for (int i = 0; i < 4; ++i) {
            int cur = (i + dir) % 4, newX = x + dirs[cur][0], newY = y + dirs[cur][1];
            if (!visited.contains(newX + "-" + newY) && robot.move()) {
                helper(robot, newX, newY, cur, visited);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
        }
    }
}