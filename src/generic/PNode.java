package generic;
import dsa.annotated.Node;

/**
 * priority node
 */
public class PNode extends Node {
	public int priority;

	public PNode(int value, int priority) {
		super(value);
		this.priority = priority;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PNode))
			return false;
		PNode other = (PNode) obj;
		return super.equals(obj) && other.priority == this.priority;
	}
}
