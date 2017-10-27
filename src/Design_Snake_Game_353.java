//http://www.cnblogs.com/grandyang/p/5558033.html
//https://www.programcreek.com/2014/08/leetcode-design-snake-game-java/
public class Design_Snake_Game_353 {
    int[][] food;
    int index;
    int row, col;
    int x, y;
    int len;
    LinkedList<int[]> queue;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.food=food;
        this.index=0;
        this.x=0;
        this.y=0;
        this.row=height;
        this.col=width;
        this.queue= new LinkedList<int[]>();
        this.queue.offer(new int[]{0, 0});
    }
 
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch(direction){
            case "U":
                x--;
                break;
            case "L":
                y--;
                break;
            case "R":
                y++;
                break;
            case "D":
                x++;
                break;
        }
 
        if(!isValid(x,y)){
            return -1;
        }
 
        return process(x, y);
    }
 
    public boolean isValid(int x, int y){
        if(x<0 || x>=row || y<0 || y>=col)
            return false;
 
        return true;    
    }
 
    public int process(int x, int y){
 
        if(index==food.length){
            queue.poll();
 
        }else if(food[index][0]==x && food[index][1]==y){
            len++;
            index++;
        }else{
            queue.poll();
        }
 
        for(int[] p: queue){   
            if(p[0]==x&&p[1]==y)
                return -1;
        }
 
        queue.offer(new int[]{x,y});
 
        return len;
    }
}
