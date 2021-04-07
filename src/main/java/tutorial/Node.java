package tutorial;

public class Node<T> {

    private Node next = null;

    private T object = null;

    public Node(T object) {
	this.object = object;
    }

    public Node<T> getNext() {
	return next;
    }

    public void setNext(Node<T> next) {
	this.next = next;
    }

    public T getObject() {
	return object;
    }
}
