import java.util.ArrayList;
import java.util.LinkedList;

public class PG {
    private String header;
    private String footer;
    private String body = "";
    private LinkedList<Node> nodeStack = new LinkedList();
    private LinkedList<Node> ifNodeStack = new LinkedList();
    private LinkedList<Node> doNodeStack = new LinkedList();
    private LinkedList<Edge> edges = new LinkedList();
    private LinkedList<Symbol> symbolList = new LinkedList();

    public PG() {
        this.header = "digraph program_graph {rankdir=LR;\r\n" +
                "node [shape = circle]; q▷;\r\n" +
                "node [shape = doublecircle]; q◀; \r\n" +
                "node [shape = circle]\r\n";
        this.footer = "}";

    }

    public LinkedList<Symbol> getSymbolList() {
        return symbolList;
    }

    public void addSymbolToList(Symbol symbol) {
        this.symbolList.add(symbol);
    }

    public boolean symbolListContainsSymbol(String symbol) {
        for (Symbol existingSymbol : this.symbolList) {
            if (existingSymbol.getName().equals(symbol)) return true;
        }
        return false;
    }

    public LinkedList<Node> getNodeStack() {
        return nodeStack;
    }

    public LinkedList<Node> getIfNodeStack() {
        return ifNodeStack;
    }

    public LinkedList<Node> getDoNodeStack() {
        return doNodeStack;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void createExitConditions() {
        // iterate over all edges
        // check every edge for action. if action = "else" then
        // check for matching starting nodes. if found:
        // convert action to inverted and appended string

        for (Edge edge : this.getEdges()) {
            if (edge.getAction().equals("else")) {
                String action = "!(";
                for (Edge comp : this.getEdges()) {
                    if (!(edge == comp) && comp.getStartNode().getId() == edge.getStartNode().getId()) {
                        action += comp.getAction() + "|";
                    }
                }

                action = action.substring(0, action.length() - 1) + ")";
                edge.setAction(action);
            }
        }
    }

    public void printBody() {
        for (Edge edge : this.edges) {
            String startNode = "";
            String targetNode = "";

            switch (edge.getStartNode().getId()) {
                case -1:
                    startNode = "q▷";
                    break;
                case -2:
                    startNode = "q◀";
                    break;
                default:
                    startNode = "q" + Integer.toString(edge.getStartNode().getId());
            }

            switch (edge.getTargetNode().getId()) {
                case -1:
                    targetNode = "q▷";
                    break;
                case -2:
                    targetNode = "q◀";
                    break;
                default:
                    targetNode = "q" + Integer.toString(edge.getTargetNode().getId());
            }

            this.body += startNode + " -> " + targetNode + " [label = \"" + edge.getAction() + "\"];\n";
        }
    }

    public ArrayList<Node> getAllNodes() {
        ArrayList<Node> out = new ArrayList<>();

        for (Edge edge : edges) {
            if (!out.contains(edge.getStartNode())) {
                out.add(edge.getStartNode());
            }
            if (!out.contains(edge.getTargetNode())) {
                out.add(edge.getTargetNode());
            }
        }

        return out;
    }

    public String toString() {
        return (this.header + this.body + this.footer);
    }
}