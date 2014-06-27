public class Node_Link_CircleTest {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();  
		/*l.delete("A");
		System.out.println(l.length);
		l.print();*/
		l.add("A");
		l.print();
		System.out.println(l.length);
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("B");
		l.add("E");
		l.add("A");
		l.print();
		System.out.println(l.length);
		System.out.println(l.head.data);
		System.out.println(l.tail.data);
		l.delete("E");
		l.print();
		System.out.println(l.length);
		System.out.println(l.head.data);
		System.out.println(l.tail.data);
		
		CircleLinkedList cll = new CircleLinkedList();
		cll.add("A1");
		cll.add("B1");
		cll.add("C1");
		cll.add("B2");
		cll.print();
		System.out.println("tail.next: " + cll.tail.next.data);
		System.out.println("length: " + cll.length);
		System.out.println("head: " + cll.head.data);
		System.out.println("tail: " + cll.tail.data);
		cll.delete("A1");
		cll.print();
		System.out.println("tail.next: " + cll.tail.next.data);
		System.out.println("length: " + cll.length);
		System.out.println("head: " + cll.head.data);
		System.out.println("tail: " + cll.tail.data);
		
	}
}

class Node {
	String data;
	Node next;
	
	public Node(String data) {
		this.data = data;
	}
	public Node(String data, Node node) {
		this.data = data;
		this.next = node;
	}
}

class LinkedList {
	Node head;
	Node tail;
	int length;
	public LinkedList() {
		this.head = this.tail = null;
		length = 0;
	}
	public LinkedList(Node node) {
		this.head = this.tail = node;
		length++;
	}
	public void add(String data) {
		Node node = new Node(data);
		if(length<=0) {
			this.head = this.tail = node;
		} else {
			tail.next = node;
			tail=node;
		}
		length++;
	}

	public void delete(String data) {
		if (length<=0) {
			System.out.println("no nodes");
		} else {
			if (head.data.equals(data)) { // if delete head
				length--;
				if (head.next != null) {
					head = head.next;
				} else {
					head = tail = null;
				}
			}
			Node tmp = head;
			while (tmp.next != tail) {
				Node pointer = tmp;
				tmp = tmp.next;
				if (tmp.data.equals(data)) {
					length--;
					pointer.next = tmp.next;
				}
			}
			if (tmp.next == tail && tail.data.equals(data)) {
				length--;
				tail = tmp;
			} else {
				System.out.println("node not found");
			}
		}
	}
	public void print() {
		if(length<=0) {
			System.out.println("empty");
		} else if(length==1) {
			System.out.println(head.data);
		} else {
			System.out.print(head.data+"->");
			Node tmp = head;
			while(tmp.next != tail && tmp.next != null) {
				tmp = tmp.next;
				System.out.print(tmp.data+"->");
			}
			System.out.println(tail.data);
		}
	}

}

class CircleLinkedList {
	Node head;
	Node tail;
	int length;
	public CircleLinkedList() {
		this.head = null;
		this.tail = null;
		length=0;
	}
	public CircleLinkedList(Node node) {
		this.head = node;
		this.tail = node;
		tail.next = head;
		length++;
	}
	public void add(String data) {
		Node node = new Node(data);
		if(length<=0) {
			this.head = this.tail = node;
			tail.next = head;
		} else {
			tail.next = node;
			node.next = head;
			tail = node;
		}
		length++;
	}
	public void delete(String data) {
		if(length<=0) {
			System.out.println("empty");
		} else {
			if(head.data.equals(data)){
				length--;
				if(head.next!=null) {
					head = head.next;
					tail.next = head;
				} else {
					head = tail = null;
				}
			}
			Node tmp = head;
			while(tmp.next != tail) {
				Node pointer = tmp;
				tmp = tmp.next;
				if(tmp.data.equals(data)) {
					length--;
					pointer.next = tmp.next;
				}
			}
			if(tmp.next == tail && tail.data.equals(data)) {
				length--;
				tmp.next = head;
				tail = tmp;
			}
		}
	}
	public void print() {
		if(length<=0) {
			System.out.println("empty");
		} else if(length==1) {
			System.out.println(head.data);
		} else {
			System.out.print(head.data + "->");
			Node tmp = head;
			while(tmp.next!=tail && tmp.next !=null) {
				tmp = tmp.next;
				System.out.print(tmp.data + "->");
			}
			if(tmp.next==tail) {
				System.out.println(tail.data);
			}
		}
	}
}