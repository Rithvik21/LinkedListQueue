import java.util.*;
public class MyStack implements StackADT
{
    // instance variables - replace the example below with your own
    private Square[] stack;
    private int size = 0;
    private int top = 0;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack()
    {
        stack = new Square[10];
        top = -1;
        size = stack.length;
    }
    public MyStack(int initCap)
    {
        stack = new Square[initCap];
        top = -1;
        size = stack.length;
    }
    
    public int size() {
        return size;
    }

    
    public boolean isEmpty()
    {
        return top <= -1;
    }
    
    public Square peek(){
        if(top == -1){
            throw new EmptyStackException();
        }
        else{
            return stack[top];
        }
    }
    
    public Square pop(){
        if(top <= 0){
            throw new EmptyStackException(); 
        }
        else{
            top--;
            return stack[top+1];
        }
        
    }
    
    public void push(Square item){
        if (top == stack.length - 1) {
            doubleCapacity();
        }
        else{
            top++;
            stack[top] = item;
        }
    }
    
    private void doubleCapacity(){
        stack = new Square[size*2];
    }
    
    public String toString(){
        String s = "";
        for(int i = top; i>=0; i--){
            s += stack[i];
            s += "\n";
        }
        return s;
    }
    
    public void clear() {
        for (int i = 0; i < stack.length; i++) {
            stack[i] = null;
        }
        size = 0;
    }
}

