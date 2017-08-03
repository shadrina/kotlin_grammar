/**
 * An example of using generated files
 * Printing out identifiers of classes declared in a file
 */

import org.antlr.v4.runtime.*;

public class Test {

    public static void main(String[] args) throws Exception{
        CharStream cs = new ANTLRFileStream("input.txt");
        KotlinLexer lexer = new KotlinLexer(cs);
        TokenStream tokens = new CommonTokenStream(lexer);
        KotlinParser parser = new KotlinParser(tokens);
        parser.kotlinFile();

        for (int i = 1; i < tokens.size() ; i++) {
            String prevToken = tokens.get(i - 1).getText();
            String currToken = tokens.get(i).getText();
            String currTokenType = lexer.getVocabulary().getDisplayName(tokens.get(i).getType());
            if (prevToken.equals("class") && currTokenType.equals("Identifier"))
                System.out.println(currToken);
        }
    }
}