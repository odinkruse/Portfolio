/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Compiler;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anders, Calvin, Odin
 */
public class mp 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
        {
            String filename = args[0];
            File file = new File(filename);
            dispatcher(file);
            //SymbolTable st = new SymbolTable();
            //st.createSTable("Apples", 0);
            //st.insert("A", "variable", "local", "integer");
            //st.insert("B", "procedure", "in", "character");
            //st.createSTable("Bananas", 1);
            //st.insert("C", "variable", "local", "boolean");
            //st.createSTable("Cherry", 2);
            //st.insert("D", "variable", "private", "String");
            //st.printSTable();
        }
    public static void dispatcher(File file)throws IOException
        {
            ArrayList<String> tokenList = new ArrayList<String>();
            ArrayList<String> lexemeList = new ArrayList<String>();
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            int c = 0;
            int rowNum = 0;
            int colNum = 0;
            int colPrint = 0;
            boolean isSymbol = false;
            boolean isReservedWord = false;
            boolean isLetterDigit = false;
            
            while((c = buffer.read()) != -1) 
            {   
                //this should now be updated to work with new values
                char character = (char) c;
                switch(character) 
                   {
                       case '\n':
                           rowNum++;
                           colNum = 0;
                           break;
                       case '\r':
                           colNum = 0;
                           break;
                       case ' ':
                           colNum++;
                           break;
                       case '\t':
                           colNum++;
                           colNum++;
                           colNum++;
                           colNum++;
                           colNum++;
                           break;
                       case '.':
                           isSymbol = true;
                           break;
                       case ',':
                           isSymbol = true;
                           break;
                       case '\"':
                           isSymbol = true;
                           break;
                       case '/':
                           isSymbol = true;
                           break;
                       case '\'':
                           isSymbol = true; 
                           break;
                       case '{':
                           isSymbol = true;
                           break;
                       case '}':
                           //isSymbol = true;
                           break;
                       case ';':
                           isSymbol = true;
                           break;
                       case '(':
                           isSymbol = true;
                           break;
                       case ')':
                           isSymbol = true;
                           break;
                       case '=':
                           isSymbol = true;
                           break;
                       case '>':
                           isSymbol = true;
                           break;
                       case '<':
                           isSymbol = true;
                           break;
                       case ':':
                           isSymbol = true;
                           break;
                       case '+':
                           isSymbol = true;
                           break;
                       case '-':
                           isSymbol = true;
                           break;
                       case '*':
                           isSymbol = true;
                           break;
                       case 'a':
                           isReservedWord = true;
                           break;
                       case 'b':
                           isReservedWord = true;
                           break;
                       case 'c':
                           isReservedWord = true;
                           break;
                       case 'd':
                           isReservedWord = true;
                           break;
                       case 'e':
                           isReservedWord = true;
                           break;
                       case 'f':
                           isReservedWord = true;
                           break;
                       case 'g':
                           isReservedWord = true;
                           break;
                       case 'h':
                           isReservedWord = true;
                           break;
                       case 'i':
                           isReservedWord = true;
                           break;
                       case 'j':
                           isReservedWord = true;
                           break;
                       case 'k':
                           isReservedWord = true;
                           break;
                       case 'l':
                           isReservedWord = true;
                           break;
                       case 'm':
                           isReservedWord = true;
                           break;
                       case 'n':
                           isReservedWord = true;
                           break;
                       case 'o':
                           isReservedWord = true;
                           break;
                       case 'p':
                           isReservedWord = true;
                           break;
                       case 'q':
                           isReservedWord = true;
                           break;
                       case 'r':
                           isReservedWord = true;
                           break;
                       case 's':
                           isReservedWord = true;
                           break;
                       case 't':
                           isReservedWord = true;
                           break;
                       case 'u':
                           isReservedWord = true;
                           break;
                       case 'v':
                           isReservedWord = true;
                           break;
                       case 'w':
                           isReservedWord = true;
                           break;
                       case 'x':
                           isReservedWord = true;
                           break;
                       case 'y':
                           isReservedWord = true;
                           break;
                       case 'z':
                           isReservedWord = true;
                           break;
                       case 'A':
                           isReservedWord = true;
                           break;
                       case 'B':
                           isReservedWord = true;
                           break;
                       case 'C':
                           isReservedWord = true;
                           break;
                       case 'D':
                           isReservedWord = true;
                           break;
                       case 'E':
                           isReservedWord = true;
                           break;
                       case 'F':
                           isReservedWord = true;
                           break;
                       case 'G':
                           isReservedWord = true;
                           break;
                       case 'H':
                           isReservedWord = true;
                           break;
                       case 'I':
                           isReservedWord = true;
                           break;
                       case 'J':
                           isReservedWord = true;
                           break;
                       case 'K':
                           isReservedWord = true;
                           break;
                       case 'L':
                           isReservedWord = true;
                           break;
                       case 'M':
                           isReservedWord = true;
                           break;
                       case 'N':
                           isReservedWord = true;
                           break;
                       case 'O':
                           isReservedWord = true;
                           break;
                       case 'P':
                           isReservedWord = true;
                           break;
                       case 'Q':
                           isReservedWord = true;
                           break;
                       case 'R':
                           isReservedWord = true;
                           break;
                       case 'S':
                           isReservedWord = true;
                           break;
                       case 'T':
                           isReservedWord = true;
                           break;
                       case 'U':
                           isReservedWord = true;
                           break;
                       case 'V':
                           isReservedWord = true;
                           break;
                       case 'W':
                           isReservedWord = true;
                           break;
                       case 'X':
                           isReservedWord = true;
                           break;
                       case 'Y':
                           isReservedWord = true;
                           break;
                       case 'Z':
                           isReservedWord = true;
                           break;
                       case '0':
                           isLetterDigit = true;
                           break;
                       case '1':
                           isLetterDigit = true;
                           break;
                       case '2':
                           isLetterDigit = true;
                           break;
                       case '3':
                           isLetterDigit = true;
                           break;
                       case '4':
                           isLetterDigit = true;
                           break;
                       case '5':
                           isLetterDigit = true;
                           break;
                       case '6':
                           isLetterDigit = true;
                           break;
                       case '7':
                           isLetterDigit = true;
                           break;
                       case '8':
                           isLetterDigit = true;
                           break;
                       case '9':
                           isLetterDigit = true;
                           break;
                       default:
                           System.out.println("MP_ERROR");
                            break;
                   }
                colPrint = colNum;
                if (isSymbol == true)
                {
                    Symbols symbol = new Symbols(file, rowNum, colNum, character);
                    String token = symbol.getToken();
                    int tokenRowNum = symbol.getRow();
                    int tokenColNum = symbol.getColumn();
                    String lexeme = symbol.getLexeme();
                    int difference = tokenColNum-colNum;
                    int difference2 = tokenRowNum-rowNum;
                    for(int j = 0;j<difference2;j++)
                    {
                        buffer.readLine();
                    }
                    colNum = tokenColNum;
                    rowNum = tokenRowNum;
                    for(int i = 0;i<difference-1;i++){
                        buffer.read();
                    }
                    if (token.equals("ERROR"))
                    {
                        System.out.println("somethings broken");
                        System.out.println(token);
                        System.out.println(tokenRowNum);
                        System.out.println(tokenColNum);
                        System.out.println(lexeme);
                    }
                    
                    if (!token.equals("MP_COMMENT"))
                    {
                        tokenList.add(token);
                        lexemeList.add(lexeme);
                        printSymbol(token, tokenRowNum, colPrint, lexeme);
                    }


                }
                if (isLetterDigit == true)
                {
                    letterDigits letterDigit = new letterDigits(file, rowNum, colNum, character);
                    String token = letterDigit.getToken();
                    int tokenRowNum = letterDigit.getRow();
                    int tokenColNum = letterDigit.getColumn();
                    int difference = tokenColNum-colNum;
                    for(int i = 0;i<difference-1;i++){
                        buffer.read();
                    }
                    colNum = tokenColNum;
                    String lexeme = letterDigit.getLexeme();
                    tokenList.add(token);
                    lexemeList.add(lexeme);
                    printDigit(token, tokenRowNum, colPrint, lexeme);

                }
                if (isReservedWord == true)
                {
                    ReservedWords rWord = new ReservedWords(file, rowNum, colNum, character);
                    String token = rWord.getToken();
                    int tokenRowNum = rWord.getRow();
                    int tokenColNum = rWord.getColumn();
                    int difference = tokenColNum-colNum;

                    for(int i = 0;i<difference-1;i++){
                        buffer.read();
                    }
                    colNum = tokenColNum;
                    String lexeme = rWord.getLexeme();
                    tokenList.add(token);
                    lexemeList.add(lexeme);
                    printReservedWord(token, tokenRowNum, tokenColNum, lexeme);
                    //System.out.println(lexeme);
                }
                
            isSymbol = false;
            isLetterDigit = false;
            isReservedWord = false;
            }
    String token = "";
    tokenList.add(token);
    lexemeList.add(token);
    System.out.println(tokenList);
    Parser parse = new Parser(tokenList, lexemeList);
        }
    public static void printSymbol(String token, int rowNum, int colNum, String lexeme)
    {
        //System.out.println("Symbol Found: Token "+token+" Row Number "+rowNum+" Column Number "+colNum+" Lexeme "+lexeme);
    }
    public static void printReservedWord(String token, int rowNum, int colNum, String lexeme)
    {
        //System.out.println("Reserved Word Found: Token "+token+" Row Number "+rowNum+" Column Number "+colNum+" Lexeme "+lexeme);
    }
    public static void printDigit(String token, int rowNum, int colNum, String lexeme)
    {
        //System.out.println("Digit Found: Token "+token+" Row Number "+rowNum+" Column Number "+colNum+" Lexeme "+lexeme);
    }
}