import java.util.Iterator;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 11장 내부 클래스
 * tail을 유지, 중복을 허용, 비정렬 단일 연결구조
 * @version 2020년도 2학기
 * @author 2019136072 손지민 
 */
public class UnsortedSingleLinkedList implements Iterable<String> {
	private static class Node{
		private String item = null;
		private Node next = null;
		private Node(String item) {
			this(item, null);
		}
		private Node(String item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	private class LinkedListIterator implements Iterator<String>{
		private Node curr = head;
		@Override
		public boolean hasNext() {
			if(curr!=null) return true;
			return false;
		}
		@Override
		public String next() {
			String tmp = curr.item;
			curr = curr.next;
			return tmp;
		}
	}
	private Node head = null;
	private Node tail = null;
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
		size = 0;
		head = tail = null;
	}
	public void pushFront(String item) {
		Node newNode = new Node(item, head);
		head = newNode;
		if(isEmpty()) tail = newNode;
		++size;
	}
	public String popFront() {
		if(isEmpty()) throw new IllegalStateException();
		Node popNode = head;
		head = head.next;
		if(head==null) tail = null;
		--size;
		return popNode.item;
	}
	public void pushBack(String item) {
		if(isEmpty()) pushFront(item);
		else {
			Node newNode = new Node(item, null);
			tail.next = newNode;
			tail = newNode;
			++size;
		}
	}
	public String popBack() {
		if(isEmpty()) throw new IllegalStateException();
		Node popNode = tail;
		Node dummy = new Node("",head);
		Node prev = dummy;
		while(prev.next!=tail) prev = prev.next;
		prev.next = null;
		head = dummy.next;
		dummy.next = null; // 꼭 필요한 요소는 아님
		tail = (head==null)? null: prev;
		--size;
		return popNode.item;
	}
	public String peekFront() {
		if(isEmpty()) throw new IllegalStateException();
		return head.item;
	}
	public String peekBack() {
		if(isEmpty()) throw new IllegalStateException();
		return tail.item;
	}
	public boolean find(String item) {
		Node curr = head;
		while(curr!=null) {
			if(curr.item == item) return true;
			curr = curr.next;
		}
		return false;
	}
	// head부터 검색하여 item을 유지하는 첫 번째 노드를 삭제함 
	public void removeFirst(String item) {
		if(isEmpty()) throw new IllegalStateException();
		Node dummy = new Node("",head);
		Node prev = dummy;
		Node curr = head;
		while(curr!=null) {
			if(curr.item == item) {
				if(curr==tail) tail = (curr==head)? null: prev;
				prev.next = curr.next;
				--size;
				head = dummy.next;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
	}
	// 리스트에서 item을 유지하는 모든 노드를 삭제함
	public void removeAll(String item) {
		if(isEmpty()) throw new IllegalStateException();
		Node dummy = new Node("",head);
		Node prev = dummy;
		Node curr = head;
		while(curr!=null) {
			if(curr.item == item) {
				if(curr==tail) tail = (curr==head)? null: prev;
				prev.next = curr.next;
				--size;
				curr = prev.next;
			}
			else {
				prev = curr;
				curr = curr.next;	
			}
		}
		head = dummy.next;
	}
	@Override
	public Iterator<String> iterator() {
		return new LinkedListIterator();
	}
}
