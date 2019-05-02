import java.util.ArrayList;

public class Node {
	static int nodeCount = 1;
	private int id;

	public Node() {
		this.setId(nodeCount);
		nodeCount++;
	}

	public Node(boolean b) {
		if (b) {
			this.id = -1;
		} else {
			this.id = -2;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
