

public class Parse extends CompilerBaseVisitor<String> {			// this class does nothing except traversing through the syntax tree and checking if there are any errors.

		public String visitStart(CompilerParser.StartContext ctx) {
			return visitChildren(ctx);}
		public String visitVarDef(CompilerParser.VarDefContext ctx) {
			return visitChildren(ctx); }
		public String visitAppend(CompilerParser.AppendContext ctx) {
			return visitChildren(ctx); }
		public String visitDoLoop(CompilerParser.DoLoopContext ctx) {
			return visitChildren(ctx); }
		public String visitSkip(CompilerParser.SkipContext ctx) {
			return visitChildren(ctx); }
		public String visitIf(CompilerParser.IfContext ctx) {
			return visitChildren(ctx); }
		public String visitIfElif(CompilerParser.IfElifContext ctx) {
			return visitChildren(ctx); }
		public String visitIfThen(CompilerParser.IfThenContext ctx) {
			return visitChildren(ctx); }
		public String visitPlusExpr(CompilerParser.PlusExprContext ctx) {
			return visitChildren(ctx); }
		public String visitVar(CompilerParser.VarContext ctx) { 
			return visitChildren(ctx); }
		public String visitNum(CompilerParser.NumContext ctx) {
			return visitChildren(ctx); }
		public String visitPowExpr(CompilerParser.PowExprContext ctx) {
			return visitChildren(ctx); }
		public String visitNestedExpr(CompilerParser.NestedExprContext ctx) {
			return visitChildren(ctx); }
		public String visitProdExpr(CompilerParser.ProdExprContext ctx) {
			return visitChildren(ctx); }
		public String visitUMinusExpr(CompilerParser.UMinusExprContext ctx) {
			return visitChildren(ctx); }
		public String visitMinusExpr(CompilerParser.MinusExprContext ctx) {
			return visitChildren(ctx); }
		public String visitOr(CompilerParser.OrContext ctx) {
			return visitChildren(ctx); }
		public String visitTrue(CompilerParser.TrueContext ctx) {
			return visitChildren(ctx); }
		public String visitSmallerEqual(CompilerParser.SmallerEqualContext ctx) {
			return visitChildren(ctx); }
		public String visitFalse(CompilerParser.FalseContext ctx) {
			return visitChildren(ctx); }
		public String visitUnequal(CompilerParser.UnequalContext ctx) {
			return visitChildren(ctx); }
		public String visitNeg(CompilerParser.NegContext ctx) {
			return visitChildren(ctx); }
		public String visitGreaterEqual(CompilerParser.GreaterEqualContext ctx) {
			return visitChildren(ctx); }
		public String visitEqual(CompilerParser.EqualContext ctx) {
			return visitChildren(ctx); }
		public String visitNestedBool(CompilerParser.NestedBoolContext ctx) {
			return visitChildren(ctx); }
		public String visitSCOr(CompilerParser.SCOrContext ctx) {
			return visitChildren(ctx); }
		public String visitAnd(CompilerParser.AndContext ctx) {
			return visitChildren(ctx); }
		public String visitSCAnd(CompilerParser.SCAndContext ctx) {
			return visitChildren(ctx); }
		public String visitGreater(CompilerParser.GreaterContext ctx) {
			return visitChildren(ctx); }
		public String visitSmaller(CompilerParser.SmallerContext ctx) {
			return visitChildren(ctx); }
	}
