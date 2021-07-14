import java.util.Iterator;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 13장 범용 프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 */
public class UnsortedSingleLinkedList <T extends Comparable<T>> implements Iterable<T> {
	private static class Node<T>{
		private T item = null;
		private Node<T> next = null;
		private Node(T item) {
			this(item, null);
		}
		private Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}
	private class LinkedListIterator implements Iterator<T>{
		private Node<T> curr = head;
		@Override
		public boolean hasNext() {
			return curr!=null;
		}
		@Override
		public T next() {
			Node<T> prev = curr;
			curr = curr.next;
			return (T) prev.item;
		}
		
	}
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;
	public boolean isFull() {
		return false;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	public void clear() {
		Node<T> curr = head;
		while(curr!=null) {
			Node<T> deleteNode = curr;
			curr = curr.next;
			deleteNode.next = null;
		}
		head = tail = null;
		size = 0;
	}
	public void pushFront(T item) {
		Node<T> newNode = new Node<T>(item, head);
		head = newNode;
		if(isEmpty()) tail = newNode;
		++size;
	}
	public T popFront() {
		if(isEmpty()) throw new IllegalStateException();
		Node<T> popNode = head;
		head = head.next;
		popNode.next = null;
		if(head==null) tail = null;
		--size;
		return (T) popNode.item;
	}
	public void pushBack(T item) {
		Node<T> newNode = new Node<T>(item);
		if(isEmpty()) head = tail = newNode;
		else {
			tail.next = newNode;
			tail = newNode;
		}
		++size;
	}
	@SuppressWarnings("unchecked")
	public T popBack() {
		if(isEmpty()) throw new IllegalStateException();
		Node<T> popNode = tail;
		Node<T> dummy = new Node<T>((T) "",head);
		Node<T> prev = dummy;
		while(prev.next!=tail) prev = prev.next;
		prev.next = null;
		head = dummy.next;
		tail = (head==null)? null: prev;
		--size;
		return (T) popNode.item;
	}
	public T peekFront() {
		if(isEmpty()) throw new IllegalStateException();
		return (T) head.item;
	}
	public T peekBack() {
		if(isEmpty()) throw new IllegalStateException();
		return (T) tail.item;
	}
	public boolean find(T item) {
		if(isEmpty()) return false;
		Node<T> curr = head;
		while(curr!=null) {
			if(curr.item.equals(item)) return true;
			curr = curr.next;
		}
		return false;
	}
	public void removeFirst(T item) {
		if(isEmpty()) return;
		Node<T> dummy = new Node<T>(null, head);
		Node<T> prev = dummy;
		Node<T> curr = head;
		while(curr!=null) {
			if(curr.item.equals(item)) {
				prev.next = curr.next;
				if(curr==tail) tail = (curr==head)? null: prev;
				curr.next = null;
				--size;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		head = dummy.next;
		dummy.next = null;
	}
	public void removeAll(T item) {
		if(isEmpty()) return;
		Node<T> dummy = new Node<T>(null, head);
		Node<T> prev = dummy;
		Node<T> curr = head;
		while(curr!=null) {
			if(curr.item.equals(item)) {
				prev.next = curr.next;
				if(curr==tail) tail = (curr==head)? null: prev;
				curr.next = null;
				--size;
				curr = prev.next;
			}
			else {
				prev = curr;
				curr = curr.next;
			}
		}
		head = dummy.next;
		dummy.next = null;
	}
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
}
