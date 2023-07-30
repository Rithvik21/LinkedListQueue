public class MazeSolverWithStack extends MazeSolver
{
    // instance variables - replace the example below with your own
    public MyStack worklist;

    /**
     * Constructor for objects of class MazeSolverStack
     */
    public MazeSolverWithStack(Maze maze)
    {
        super(maze);
    }

    
    public void makeEmpty()
    {
        worklist = new MyStack();
    }
    
    public boolean isEmpty(){
        return worklist.isEmpty();
    }
    
    public void add(Square s){
        worklist.push(s);
    }
    
    public Square next(){
        return worklist.peek();
    }
}
