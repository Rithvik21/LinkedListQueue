import java.util.*;
import java.io.*;
public class Maze
{
    // instance variables - replace the example below with your own
    private Square start;
    private Square end;
    private Square grid[][];

    /**
     * Constructor for objects of class Maze
     */
    public Maze()
    {
       
    }
   
    public boolean loadMaze(String fileName) {
        Scanner sc;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(e + "; File not Found");
            return false;
        }
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        grid = new Square[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Square(r, c, sc.nextInt());
                if (grid[r][c].getType() == 2) {
                    start = grid[r][c];
                } else if (grid[r][c].getType() == 3) {
                    end = grid[r][c];
                }
            }
        }
        return true;
    }
   
       
    public List<Square> getNeighbors(Square s){
        List<Square> Neighbors = new ArrayList<Square>();
         if (s.getRow() > 0) {
            if (grid[s.getRow() - 1][s.getCol()] != null) {
                Neighbors.add(grid[s.getRow() - 1][s.getCol()]);
            }
        }
        if (s.getRow() < grid.length - 1) {
            if (grid[s.getRow() + 1][s.getCol()] != null) {
                Neighbors.add(grid[s.getRow() + 1][s.getCol()]);
            }
        }
        if (s.getCol() < grid[s.getRow()].length - 1) {
            if (grid[s.getRow()][s.getCol() + 1] != null) {
                Neighbors.add(grid[s.getRow()][s.getCol() + 1]);
            }
        }
        if (s.getCol() > 0) {
            if (grid[s.getRow()][s.getCol() - 1] != null) {
                Neighbors.add(grid[s.getRow()][s.getCol() - 1]);
            }
        }
        return Neighbors;
    }
   
    public Square getStart(){
        return start;
    }
   
    public Square getExit(){
        return end;
    }
   
    public void reset(){
        for(int r = 0; r <grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                grid[r][c].reset();
            }
        }
    }
   
    public String toString(){
        String s = "";
        for(int r = 0; r <grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                s += grid[r][c].toString();
                s += " ";
            }
            s += "\n";
        }
        return s;
    }
       
}