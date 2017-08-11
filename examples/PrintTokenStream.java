/**
 * An example of using generated files
 * Printing out the token stream and the parse tree
 */

import org.antlr.v4.runtime.*;

public class Test {

    public static void main(String[] args) throws Exception{
        CharStream cs = new ANTLRFileStream("input.txt");
        KotlinLexer lexer = new KotlinLexer(cs);
        TokenStream tokens = new CommonTokenStream(lexer);
        KotlinParser parser = new KotlinParser(tokens);
        parser.file();
        for (int i = 0; i < tokens.size() ; i++) {
            String tokenText = tokens.get(i).getText();
            String lexerRule = lexer.getVocabulary().getSymbolicName(tokens.get(i).getType());
            if (!lexerRule.equals("NL")) //skipping NewLine tokens (for beauty)
                System.out.println(tokenText + "\t\t" + lexerRule);
            
            //Simple way
            //System.out.println(tokens.get(i).toString());
        }
        System.out.println(tree.toStringTree(parser));
    }
}
