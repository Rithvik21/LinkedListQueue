import java.util.*;
import java.io.File;
public abstract class MazeSolver
{
    // instance variables - replace the example below with your own
    private Maze maze;
    private boolean solved = false;
    private boolean solvable = true;

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
    }
    
    abstract void makeEmpty();
    
    abstract boolean isEmpty();
    
    abstract void add(Square s);

    abstract Square next();
    
    public boolean isSolved(){
        if(!solvable){
            return true;
        }
        else{
            return solved;
        }
    }
    
    public void step(){
        
        if (isEmpty()) {
            solvable = false;
        }
        
        else{
            Square now = next();
            if (now == maze.getExit()) {
                solved = true;
            }
            for (Square neighbor : maze.getNeighbors(now)) {
                if (neighbor.getType() != Square.WALL && neighbor.getStatus() != Square.EXPLORED && neighbor.getStatus() != Square.WORKING) {
                    neighbor.previous = now;
                    neighbor.setStatus(Square.WORKING);
                    add(neighbor);
                }
            }
            now.setStatus(Square.EXPLORED);
        }

        
    }
    
    public String getPath(){
        String s = "";
        if(!isSolved()){
           return "Maze is not yet solved"; 
        }
        else if(!solvable){
            return "Maze is Unsolvable";
        }
        else{
            Stack<Square> path = new Stack<>();
            for(Square current = this.maze.getExit(); current != null;current = current.previous)
            {
                 path.push(current);
                 current.setStatus(Square.ON_EXIT_PATH);
            }
            while(!path.isEmpty())
            {
                 s += "[" + path.peek().getRow() + "," + path.pop().getCol() + "]";
            }
            return s;
        }
        
    }
    
    public void solve(){
        while(!isSolved()){
            step();
        }
    }
}
