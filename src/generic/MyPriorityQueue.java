package generic;
import java.util.ArrayList;

public class MyPriorityQueue {
	private PNode max;
	ArrayList<PNode> rest = new ArrayList<PNode>();

	public void queue(int value, int priority) {
		PNode pn = new PNode(value, priority);
		if (max == null) {
			max = pn;
		} else {
			if (pn.priority < max.priority) {
				rest.add(max);
				max = pn;
			} else {
				rest.add(pn);
			}
		}
	}

	public PNode dequeque() {
		PNode r = max;

		if (!rest.isEmpty()) {
			// find max
			max = rest.get(0);
			for (PNode pn : rest) {
				if (pn.priority < max.priority)
					max = pn;
			}
			rest.remove(max);
		}

		return r;
	}

	
	public static void main(String[] args) {
		MyPriorityQueue mpq = new MyPriorityQueue();
		mpq.queue(1, 4);
		mpq.queue(2, 4);
		mpq.queue(3, 1);
		mpq.queue(4, 2);
		System.out.println(mpq.dequeque());
		System.out.println(mpq.dequeque());
		System.out.println(mpq.dequeque());
		System.out.println(mpq.dequeque());
	}
}
