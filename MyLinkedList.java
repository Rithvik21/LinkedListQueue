import java.util.*;
public class MyLinkedList<T>
{
    // instance variables - replace the example below with your own
    private ListNode head;
    private ListNode tail;
    private int size = 0;
    
    public MyLinkedList()
    {
        head = null;
        tail = null;
    }
    
    public MyLinkedList(T val)
    {
        head = new ListNode(val);
        head.next = null;
        size++;
        tail = head;
    }
    
    public MyLinkedList(T... vals){
        ListNode current = head;
        for(T i: vals){
            add(i);
        }
    }
    
    private class ListNode
    {
        T val;
        ListNode next;
        
        public ListNode(T val) {this.val = val; }
        
        public String toString() {return "" + this.val;}
        
    }

    public void add(T newVal){
        if(head == null){
            head = new ListNode(newVal);
            tail = head;
        }
        else{
            ListNode add = new ListNode(newVal);
            tail.next = add;
            tail = tail.next;
        }
        size++;
    }
    
    public boolean contains(T target){
        ListNode current = head;
        while(current != null){
            if(current.val == target){
                return true;
            }
            current = current.next;
            
        }
        return false;
    }
    
    public T get(int index){
        ListNode current = head;
        for(int i = 0; i<index; i++){
            current = current.next;
        }
        if(current == null){
            throw new IndexOutOfBoundsException();
        }
        else{
            return current.val;
        }
    }
    
    public int indexOf(T target){
        ListNode current = head;
        int i = 0;
        boolean found = false;
        while(current.val != target && current.next != null){
            current = current.next;
            i++;
            if(current.val == target){
                found = true;
            }
        }
        if(current.val == target){
            found = true;
        }
        if(found){
            return i;
        }
        return -1;
    }
    
    public void set(T newVal, int index){
        ListNode current = head;
        for(int i = 0; i<index; i++){
            current = current.next;
        }
        if(current == null){
            throw new IndexOutOfBoundsException();
        }
        else{
            current.val = newVal;
        }
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public T remove(int index){
        ListNode current = head;
        T val = current.val;
        if(index == 0){
            head = head.next;
            size--;
            return val;
        }
        else if(index == size-1){
            for(int i = 0; i<size-2; i++){
                current = current.next;
            }
            val = current.next.val;
            current.next = null;
            tail = current;
            size--;
            return val;
        }
        else{
            for(int i = 0; i<index-1; i++){
                current = current.next;
            }
            ListNode skip = current.next;
            val = skip.val;
            ListNode next = skip.next;
            current.next = next;
            skip.next = null;
            size--;
            return val;
        }
        
    }
    
    public void add(T newVal, int index){
        ListNode current = head;
        for(int i = 0; i<index-1; i++){
            current = current.next;
        }
        ListNode add = new ListNode(newVal);
        if(index == 0){
            add.next = head;
            head = add;
        }
        else if(current != null){
            add.next = current.next;
            current.next = add;
            if(index == size-1){
                tail = add;
            }
        }
        size++;
    }
    
    public String toString(){
        ListNode current = head;
        String nodes = "[";
        for(int i = 0; i<size-1; i++){
            nodes += "" + current.val + ", ";
            current = current.next;
        }
        if(current != null){
            nodes += "" + current + "]";
        }
        else{
            nodes += "]";
        }
        
        return nodes;
    }
}
