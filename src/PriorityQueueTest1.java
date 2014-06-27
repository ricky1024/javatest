import java.util.*;
public class PriorityQueueTest1 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(9);
		pq.offer(0);
		System.out.println(pq);
		while(pq.peek()!=null) {
			System.out.print(pq.poll() + ", ");
		}
		System.out.println();
	}
}