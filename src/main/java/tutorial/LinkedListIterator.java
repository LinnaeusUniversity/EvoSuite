package tutorial;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> nextNode;

    public LinkedListIterator(Node<T> head) {
	nextNode = head;
    }

    public boolean hasNext() {
	return nextNode != null;
    }

    public T next() {
	if (!hasNext())
	    throw new NoSuchElementException();

	T object = nextNode.getObject();
	nextNode = nextNode.getNext();
	return object;
    }

    public void remove() { 
	throw new UnsupportedOperationException(); 
    }
}
