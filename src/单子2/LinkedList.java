package 单子2;

class ListNode {

	private Object data;
	private ListNode next;

	public ListNode(Object o) { data = o; next = null; }
	public ListNode(Object o, ListNode nextNode)
		{ data = o; next = nextNode; }

	public Object getData() { return data; }
	public void setData(Object o) { data = o; }
	
	public ListNode getNext() { return next; }
	public void setNext(ListNode next) { this.next = next; }


}

class EmptyListException extends RuntimeException {
	public EmptyListException () {
		super("List is empty");
	}
}

public class LinkedList {

	private ListNode head;
	private ListNode tail;

	private int length;

	public LinkedList() {
		head = tail = null;
		length = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToHead(Object item) {
		if (isEmpty())
			head = tail = new ListNode(item);
		else
			head = new ListNode(item, head);
		length++;
	}

	public void addToTail(Object item) {
		if (isEmpty())
			head = tail = new ListNode(item);
		else {
			tail.setNext(new ListNode(item));
			tail = tail.getNext();
		}
		length++;
	}

	public Object removeFromHead() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = head.getData();
		if (head == tail)
			head = tail = null;
		else
			head = head.getNext();
		length--;
		return item;
	}

	public Object removeFromTail() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = tail.getData();
		if (head == tail)
			head = tail = null;
		else {
			ListNode current = head;
			while (current.getNext() != tail)
				current = current.getNext();
			tail = current;
			current.setNext(null);
		}
		length--;
		return item;
	}
	
	public int count() {
		return length;
	}
	
	//students need to revise toString method
	public String toString() {
		String str = "";
		ListNode current = head;
		while (current != null) {
			str = str + ((FoodOrder)current.getData()).toString();
			current = current.getNext();
		}
		return str ;
	}



	// to be completed ...
	// Method remove(int) is to remove a ListNode from the LinkedList with a specific Member ID
	public void remove(int targetID) throws EmptyListException {
		if (isEmpty()) throw new EmptyListException();
		if (head.getNext() == null && ((FoodOrder)head.getData()).getMemberID() == targetID) {
			head = null;
			return;
		}
		ListNode pre = head;
		ListNode p = head.getNext();
		while(p != null) {
			if (((FoodOrder)p.getData()).getMemberID() == targetID) {
				pre.setNext(p.getNext());
				length--;
				break;
			}
			pre = p;
			p = p.getNext();
		}
	}

	//to be completed ...
    // Method add(Object) is to insert a new ListNode into the LinkedList in a correct position
	public void add(Object item) {
		int memberID = ((FoodOrder)item).getMemberID();
		if (memberID < ((FoodOrder)(head.getData())).getMemberID()) {
			addToHead(item);
			return;
		}
		ListNode node = new ListNode(item);

		ListNode pre = head;
		ListNode p = pre.getNext();
		boolean flag = false;
		while(p != null) {
			if (memberID > ((FoodOrder)pre.getData()).getMemberID() && memberID <  ((FoodOrder)p.getData()).getMemberID() ) {
				node.setNext(p);
				pre.setNext(node);
				flag = true;
				length++;
				break;
			}
			pre = p;
			p = p.getNext();
		}
		if (!flag) {
			addToTail(item);
		}


	}
}
