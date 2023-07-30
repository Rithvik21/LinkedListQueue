
/**
 * Write a description of class MazeSolverWithQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MazeSolverWithQueue extends MazeSolver
{
    // instance variables - replace the example below with your own
    public MyQueue<Square> worklist;

    /**
     * Constructor for objects of class MazeSolverStack
     */
    public MazeSolverWithQueue(Maze maze)
    {
        super(maze);
    }

    
    public void makeEmpty()
    {
        worklist = new MyQueue<Square>();
    }
    
    public boolean isEmpty(){
        return worklist.isEmpty();
    }
    
    public void add(Square s){
        worklist.offer(s);
    }
    
    public Square next(){
        return worklist.peek();
    }
}
