import java.util.*;
public class LRUCache {
    int length = 0;
    DoubleList list = new DoubleList();
    public LRUCache(int capacity) {
        length = capacity;
    }
    
    public int get(int key) {
    	int n = list.get(key);
    	System.out.println(n);
        return n;
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1) {
            list.delete(key);
            list.add(key, value);
            System.out.println("haha3");
        } else {
            if(list.size<length) {
                list.add(key, value);
                System.out.println("haha1");
            } else {
                list.delete(list.head.key);
                list.add(key, value);
                System.out.println("haha2");
            }
        }
        list.print();
    }
    public static void main(String[] args) {
    	LRUCache lru = new LRUCache(2);
    	lru.set(2,1);
    	lru.set(1,1);
    	lru.get(2);
    	lru.set(4,1);
    	lru.get(1);
    	lru.get(2);
    }
}
class DoubleList {
    ListNode head;
    ListNode tail;
    int size;
    Map<Integer, ListNode> map;
    public DoubleList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        map = new HashMap<Integer, ListNode>();
    }
    public int get(int key) {
        if(map.containsKey(key)) {
        	int value = map.get(key).value;
        	delete(key);
        	add(key, value);
            return value;
        } else {
        	return -1;
        }
    }
    public void add(int key, int value) {
        ListNode node = new ListNode(key, value);
        if(size==0) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        map.put(key, node);
        size++;
    }
    public void delete(int key) {
        ListNode node = map.get(key);
        if(!map.containsValue(node) || node==head) {
            head = head.next;
            if(head!=null) head.pre = null;
        } else {
            if(node==tail) {
                tail = tail.pre;;
                tail.next = null;
            } else {
                ListNode n1 = node.pre;
                ListNode n2 = node.next;
                if(n1!=null) {
                    n1.next = n2;
                } else {
                    head = n2;
                }
                if(n2!=null) {
                    n2.pre = n1;
                } else {
                    tail = n1;
                }
            }
        }
        map.remove(key);
        size--;
    }
    public void print() {
		ListNode node = this.head;
		while(node.next!=null) {
			System.out.print("(" + node.key + "," + node.value + ")" + "->");
			node = node.next;
		}
		System.out.println("(" + node.key + "," + node.value + ")");
	}
}
class ListNode {
	int key;
	int value;
	ListNode pre;
	ListNode next;
	ListNode(int x, int y) {
		key = x;
		value = y;
		pre = null;
		next = null;
	}
}