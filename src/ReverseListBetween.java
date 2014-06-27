public class ReverseListBetween {
	public static ListNode reverseListBetween(ListNode head, int m, int n) {
		ListNode preM = null;
		ListNode preCur = null;
		ListNode cur = head;
		if(m==n) {
			return head;
		}
		if(m==1) {
			ListNode mNode = head;
			int count = 0;
			while(count<n-m+1) {
				ListNode curNext = cur.next;
				cur.next = preCur;
				preCur = cur;
				cur = curNext;
				count++;
			}
			head = preCur;
			mNode.next = cur;
		}
		if(m>1) {
			for(int i = 1; i < m-1; i++) {
				cur = cur.next;
			}
			preM = cur;
			cur = cur.next;
			ListNode mNode = cur;
			int count = 0;
			while(count<n-m+1) {
				ListNode curNext = cur.next;
				cur.next = preCur;
				preCur = cur;
				cur = curNext;
				count++;
			}
			preM.next = preCur;
			mNode.next = cur;
		}
		return head;
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
		ListNode newHead = reverseListBetween(head, 1, 3);
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