package datatypes;

public class Node<T> {
	private T value;
	private Node<T> next;
	
	
	public Node(T value) {
		this.value = value;
		this.next = null;
	}


	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	//return true if there is a next node
	public boolean hasNext() {
		return this.next != null;
	}
	public T getValue() {
		return value;
	}


	public void setValue(T value) {
		this.value = value;
	}


	public Node<T> getNext() {
		return next;
	}


	public void setNext(Node<T> next) {
		this.next = next;
	}


	public static<T> Node<T> createFrom(T ... args) {
		Node<T> head = new Node<T>(args[0]);
		Node<T> current = head;
		for (int i = 1; i < args.length; i++) {
			current.setNext(new Node<T>(args[i]));
			current = current.getNext();
		}
		return head;
	}

	
	public String toString() {
		return "value=" + value + ", next=" + next + " ";
	}
	
}
