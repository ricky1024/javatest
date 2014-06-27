class Node {
	String data;
	Node next;

	public Node(String data) {
		this.data = data;
		this.next = null;
	}

	public void add(String data) {
		if(this.next==null) {
			this.next = new Node(data);
		} else {
			this.next.add(data);
		}
	}

	public boolean search(String data) {
		if(this.data.equals(data)) {
			return true;
		} else {
			if(this.next!=null) {
				return this.next.search(data);
			} else {
				return false;
			}
		}
	}

	public void delete(Node previous, String data) {
		if(this.data.equals(data)) {
			previous.next = this.next;
		} else {
			if(this.next!=null) {
				this.next.delete(this, data);
			}
		}
	}

	public void print() {
		if(this.next!=null) {
			System.out.print(this.data + "-->");
			this.next.print();
		} else {
			System.out.print(this.data + "\n");
		}
	}
}

class Link {
	Node root;

	public void addNode(Node node) {
		if(this.root==null) {
			this.root = node;
		} else {
			this.root.add(node.data);
		}
	}

	public boolean searchNode(Node node) {
		return this.root.search(node.data);
	}

	public void deleteNode(Node node) {
		if(this.root.data.equals(node.data)) {
			if(this.root.next!=null) {
				root = root.next;
			}
		} else {
			root.next.delete(this.root, node.data);
		}
	}

	public void print() {
		if(this.root!=null) {
			this.root.print();
		}
	}
}

public class LinkDemo {
	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Link l = new Link();
		l.addNode(a);
		l.addNode(b);
		l.addNode(c);
		l.addNode(d);
		System.out.println("Original link：");
		l.print();
		//String searchNode = "C";
		System.out.println("Search node:" + c.data);
		String result = l.searchNode(c) ? "Find!" : "Not find!";
		System.out.println("Search result：" + result);
		System.out.println("Delete node：" + c.data);
		l.deleteNode(c);
		System.out.println("After deleting：");
		l.print();
	}
}