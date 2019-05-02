

public class Edge {
	private String action;
	private Node startNode;
	private Node targetNode;
	
	public Edge (Node startNode, Node targetNode, String action) {
		this.startNode = startNode;
		this.targetNode = targetNode;
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getTargetNode() {
		return targetNode;
	}

	public void setTargetNode(Node targetNode) {
		this.targetNode = targetNode;
	}

	public boolean isVarDef() {
		return this.getAction().contains(":=");
	}
	
}
