package tutorial;

public class Stack<T> {
    private int capacity = 10;
    private int pointer  = 0;
    private T[] objects = (T[]) new Object[capacity];
    
    public void push(T o) {
	if(pointer >= capacity)
	    throw new IllegalArgumentException("Stack exceeded capacity!");
	objects[pointer++] = o;
    }
    public T pop() {
	if(pointer <= 0)
	    throw new IllegalArgumentException("Stack empty");
	return objects[--pointer];
    }
    public boolean isEmpty() {
	return pointer <= 0;
    } 
}
