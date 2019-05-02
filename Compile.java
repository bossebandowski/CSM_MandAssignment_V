public class Compile extends CompilerBaseVisitor<String> {
    private PG pg;

    public Compile(PG pg) {
        this.pg = pg;
    }

    public PG getPg() {
        return pg;
    }

    // Flow and node creation
    public String visitStart(CompilerParser.StartContext ctx) {
        this.pg.getNodeStack().add(new Node(true));                            // add start node
        this.pg.getNodeStack().add(new Node(false));                            // add final node
        return visitChildren(ctx);
    }

    public String visitVarDef(CompilerParser.VarDefContext ctx) {
        Node initNode = this.pg.getNodeStack().pop();                            // remove start node from node stack
        Node targetNode = this.pg.getNodeStack().peek();                        // get target node from node stack
        String var = ctx.lhs.getText();
        if (!this.pg.symbolListContainsSymbol(var)) this.pg.addSymbolToList(new Symbol(var));
        String action = var + ":=" + visit(ctx.rhs);                // build action
        this.pg.getEdges().add(new Edge(initNode, targetNode, action));            // add edge
        return "";                                                                // nothing to return
    }

    public String visitAppend(CompilerParser.AppendContext ctx) {
        this.pg.getNodeStack().add(1, new Node());                        // add a new node
        visitChildren(ctx);
        return "";
    }

    public String visitDoLoop(CompilerParser.DoLoopContext ctx) {
        Node current = this.pg.getNodeStack().peek();                            // get the current node
        this.pg.getIfNodeStack().push(current);                                    // push the current node into the if node stack
        this.pg.getDoNodeStack().push(current);                                    // and the do node stack. This will allow the creation of the exit condition edge
        visit(ctx.exp);                                                            // create the loop edges
        this.pg.getNodeStack().pop();                                            // pop the current node. It has been used already
        Node initNode = this.pg.getDoNodeStack().pop();                            // create exit condition edge. Get initial node that has been saved to do loop stack
        Node targetNode = this.pg.getNodeStack().peek();                        // target node is the next node on the regular stack
        String action = "else";                                                    // add a keyword action. The correct label will be generated at the end of the program execution
        this.pg.getEdges().add(new Edge(initNode, targetNode, action));            // add edge
        return "";
    }

    public String visitSkip(CompilerParser.SkipContext ctx) {
        Node initNode = this.pg.getNodeStack().pop();                            // remove start node from stack
        Node targetNode = this.pg.getNodeStack().peek();                        // get target node from stack
        String action = "skip";                                                    // simple action
        this.pg.getEdges().add(new Edge(initNode, targetNode, action));            // add edge
        return "";                                                                // nothing to return
    }

    public String visitIf(CompilerParser.IfContext ctx) {
        this.pg.getIfNodeStack().push(this.pg.getNodeStack().pop());            // add the start node for all if-then statements
        return visitChildren(ctx);
    }

    public String visitIfElif(CompilerParser.IfElifContext ctx) {
        this.pg.getIfNodeStack().push(this.pg.getIfNodeStack().peek());            // push a copy of the if start node to the top of the if node stack
        return visitChildren(ctx);
    }

    public String visitIfThen(CompilerParser.IfThenContext ctx) {
        Node initNode = this.pg.getIfNodeStack().pop();                            // get start node from if node stack
        Node targetNode = new Node();                                            // create a fresh node as target node
        String action = visit(ctx.lhs);                                            // get boolean as action
        this.pg.getEdges().add(new Edge(initNode, targetNode, action));            // add edge
        this.pg.getNodeStack().push(targetNode);                                // push targetNode to top of stack for future use
        visit(ctx.rhs);                                                            // add rhs to PG
        return "";
    }

    // Label composition
    public String visitPlusExpr(CompilerParser.PlusExprContext ctx) {
        return (visit(ctx.lhs) + "+" + visit(ctx.rhs));
    }

    public String visitVar(CompilerParser.VarContext ctx) {
        String var = ctx.getText();
        if (!this.pg.symbolListContainsSymbol(var)) this.pg.addSymbolToList(new Symbol(var));
        return var;
    }

    public String visitNum(CompilerParser.NumContext ctx) {
        return ctx.getText();
    }

    public String visitPowExpr(CompilerParser.PowExprContext ctx) {
        return (visit(ctx.lhs) + "^(" + visit(ctx.rhs) + ")");
    }

    public String visitNestedExpr(CompilerParser.NestedExprContext ctx) {
        return "(" + visit(ctx.exp) + ")";
    }

    public String visitProdExpr(CompilerParser.ProdExprContext ctx) {
        return (visit(ctx.lhs) + "*" + visit(ctx.rhs));
    }

    public String visitUMinusExpr(CompilerParser.UMinusExprContext ctx) {
        return "-(" + visit(ctx.exp) + ")";
    }

    public String visitMinusExpr(CompilerParser.MinusExprContext ctx) {
        return (visit(ctx.lhs) + "-" + visit(ctx.rhs));
    }

    public String visitOr(CompilerParser.OrContext ctx) {
        return (visit(ctx.lhs) + "|" + visit(ctx.rhs));
    }

    public String visitTrue(CompilerParser.TrueContext ctx) {
        return "true";
    }

    public String visitSmallerEqual(CompilerParser.SmallerEqualContext ctx) {
        return (visit(ctx.lhs) + "<=" + visit(ctx.rhs));
    }

    public String visitFalse(CompilerParser.FalseContext ctx) {
        return "false";
    }

    public String visitUnequal(CompilerParser.UnequalContext ctx) {
        return (visit(ctx.lhs) + "!=" + visit(ctx.rhs));
    }

    public String visitNeg(CompilerParser.NegContext ctx) {
        return "!(" + visit(ctx.exp) + ")";
    }

    public String visitGreaterEqual(CompilerParser.GreaterEqualContext ctx) {
        return (visit(ctx.lhs) + ">=" + visit(ctx.rhs));
    }

    public String visitEqual(CompilerParser.EqualContext ctx) {
        return (visit(ctx.lhs) + "=" + visit(ctx.rhs));
    }

    public String visitNestedBool(CompilerParser.NestedBoolContext ctx) {
        return ("(" + visit(ctx.exp) + ")");
    }

    public String visitSCOr(CompilerParser.SCOrContext ctx) {
        return (visit(ctx.lhs) + "||" + visit(ctx.rhs));
    }

    public String visitAnd(CompilerParser.AndContext ctx) {
        return (visit(ctx.lhs) + "&" + visit(ctx.rhs));
    }

    public String visitSCAnd(CompilerParser.SCAndContext ctx) {
        return (visit(ctx.lhs) + "&&" + visit(ctx.rhs));
    }

    public String visitGreater(CompilerParser.GreaterContext ctx) {
        return (visit(ctx.lhs) + ">" + visit(ctx.rhs));
    }

    public String visitSmaller(CompilerParser.SmallerContext ctx) {
        return (visit(ctx.lhs) + "<" + visit(ctx.rhs));
    }
}
