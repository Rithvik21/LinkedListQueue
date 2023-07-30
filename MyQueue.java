
public class MyQueue<T> implements QueueADT<T>
{
    // instance variables - replace the example below with your own
    private MyLinkedList<T> Queue;

    
    public boolean isEmpty()
    {
        return Queue.size() == 0;
    }
    
    public void offer(T item){
        Queue.add(item);
    }
    
    public T peek(){
        return Queue.get(0);
    }
    
    public T poll(){
        return Queue.remove(0);
    }
    
    public int size(){
        return Queue.size();
    }
    
    public void clear(){
        while(Queue.size() != 0){
            Queue.remove(0);
        }
    }
}
