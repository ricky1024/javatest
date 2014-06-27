public class ReverseList {
	public static ListNode reverseList(ListNode head) {
		if(head==null) return null;
		ListNode preNode = null;
		ListNode curNode = head;
		while(curNode!=null) {
			ListNode nextNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		return preNode;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		printList(head);
		ListNode newHead = reverseList(head);
		printList(newHead);
	}
	public static void printList(ListNode head) {
		ListNode node = head;
		while(node.next!=null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(node.val);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}