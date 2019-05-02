/* Authors:
 * 	Nicholas Rose, s164580
 * 	Bosse Bandowski, s164582
 *
 * This program is based on our solution from last year**/

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

import javax.script.ScriptException;

public class Compiler {

    Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        try {
            Compiler c = new Compiler();                                // instantiate a new class member
            c.run();                                                    // run the program
        } catch (Exception e) {                                            // most basic error handler
            System.out.println("FATAL ERROR!");
            e.printStackTrace();
        }
    }

    public String getInput() {                                            // Ask the user to specify the code he/she wants to operate on. Returns the user input as a string
        System.out.println("---------------------------------------");
        System.out.println("Security analyser");
        System.out.println("---------------------------------------");
        System.out.println("Copy-paste your code now. To finish your input, hit enter twice. Your code must not contain empty lines.");

        //Scanner sc = new Scanner(System.in);							// create a scanner object to read multiple line input
        String input = "";                                                // create an empty output string that will be appended
        String lineNew;                                                    // declare a temporary string variable

        while (sc.hasNextLine()) {                                        // iterate over input range
            lineNew = sc.nextLine();                                    // save input line to temp var
            if (lineNew.isEmpty()) {                                    // exit criteria. Empty lines mean end of input
                input = input.substring(0, input.length() - 1);            // cut last "\n"
                break;                                                    // exit loop, stop reading input
            }
            input += lineNew + "\n";                                    // in the line is not empty, append it to the output variable
        }

        //sc.close();														// close the scanner

        input = stripWS(input);                                            // convert user input to single space string

        return input;                                                    // return program specified by user

    }

    public void specifyLattices (PG pg) {
        System.out.println("Specify security lattice");
        System.out.println("Confidentiality ('c') or Integrity ('i')");
        String input = "";
        LinkedList<String> options = new LinkedList<>();
        while (!(input.equals("c") || input.equals("i"))) {
            input = sc.nextLine();
        }
        switch (input) {
            case "c":   System.out.println("Confidentiality analysis: public < private");
                        options.add("public");
                        options.add("private");
                        specifyClassifications(pg, options);
                        break;
            case "i":   System.out.println("Integrity analysis: trusted < dubious");
                        options.add("trusted");
                        options.add("dubious");
                        specifyClassifications(pg, options);
                        break;
        }
    }

    public void specifyClassifications (PG pg, LinkedList<String> options) {
        System.out.println("Specify the security classification for every variable {'" + options.getFirst() + "', '" + options.getLast() + "'}");
        String input = "";
        for (Symbol var : pg.getSymbolList()) {
            System.out.print(var.getName() + ": ");
            while (!(input.equals(options.getFirst()) || input.equals(options.getLast()))) {
                input = sc.nextLine();
            }
            var.setClassification(input);
            input = "";
        }
    }

    public String stripWS(String input) {                                // this function does NOT strip all whitespaces. It rather converts all whitespaces to single spaces because there are tokens
        input = input.replace("\n", " ");                // containing spaces, meaning that stripping those would affect the parsing.
        input = input.replace("\t", " ");
        input = input.replace("\r", " ");
        while (input.contains("  ")) {
            input = input.replace("  ", " ");
        }
        return input;
    }

    public CompilerParser buildParser(String code) {                    // Build the parser for the content of the input in several steps and return it

        CharStream inputStream = CharStreams.fromString(code);            // Translate the input string into stream of characters
        CompilerLexer lex = new CompilerLexer(inputStream);                // Create a lexer for the CharStream
        CommonTokenStream tokens = new CommonTokenStream(lex);            // Use the lexer to generate the token stream
        CompilerParser parser = new CompilerParser(tokens);                // Create a parser for the given token stream

        lex.removeErrorListeners();                                        // Remove the inbuilt ANTLR error handlers
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());

        return parser;
    }

    public void run() throws Exception {                                // god function
        String code = getInput();                                        // Allow the user to pick a functionality (for now, only parsing will generate an action
        System.out.println("Parsing...");
        parse(code);
        System.out.println("Compiling...");
        PG pg = compile(code);
        specifyLattices(pg);
    }

    public void parse(String code) {
        try {
            Parse parse = new Parse();                    // create a new parse object
            CompilerParser parser = buildParser(code);    // build a parser object (antlr functionality)
            parse.visit(parser.start());                // visit start (the entry point specified by the grammar, in this case a C command
            System.out.println("ok");                    // upon visiting the entry point, the entire program will be parsed. If there are no errors, print "ok"
        } catch (Exception e) {                            // If the tree traversal that is initated by parse.visit(parser.start()) fails at any point, print "ko"
            System.out.println("ko");
        }
    }

    public PG compile(String code) {
        try {
            Compile compile = new Compile(new PG());    // create a new compile object
            CompilerParser parser = buildParser(code);    // build a parser object (antlr functionality)
            compile.visit(parser.start());                // visit start (the entry point specified by the grammar, in this case a C command
            compile.getPg().createExitConditions();        // get action labels for do loop exits
            compile.getPg().printBody();                // format all edges
            return compile.getPg();                        // return PG. Used for interpreter
        } catch (Exception e) {                            // error :(
            System.out.println("Syntax error. Could not create PG");
            System.exit(1);
        }
        return null;                                        // return null in case of error (this line is actually never reached)
    }

    // This class is used to throw the correct exception. The standard error handler by antlr turned out to be problematic
    public class BailErrorStrategy extends DefaultErrorStrategy {


        public void recover(Parser recognizer, RecognitionException e) {
            for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
                context.exception = e;
            }

            throw new ParseCancellationException(e);
        }


        public Token recoverInline(Parser recognizer)
                throws RecognitionException {
            InputMismatchException e = new InputMismatchException(recognizer);
            for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
                context.exception = e;
            }

            throw new ParseCancellationException(e);
        }


        public void sync(Parser recognizer) {
        }
    }
}