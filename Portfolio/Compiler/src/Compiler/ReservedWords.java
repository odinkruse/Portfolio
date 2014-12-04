/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.isLetterOrDigit;

/**
 *
 * @author Anders, Calvin, Odin
 */

class ReservedWords {
    BufferedReader buffer;
    File file;
    int row, column;
    char first_token,ch;
    boolean whitespace;
    String lexeme;
    String tempLex;
    
    ReservedWords(File in_file, int in_row, int in_column, char in_first_token)
    {
        file = in_file;
        row = in_row;
        column = in_column;
        first_token = in_first_token;
        whitespace = false;
        tempLex = "";
        lexeme = "";
    }
    public String getToken() throws FileNotFoundException, IOException
    {
        lexeme = lexeme+first_token;
        tempLex = tempLex+first_token;
        buffer = new BufferedReader(new FileReader(file));
        int temp = 0;
        int r = 0;
        while(temp<row){
            buffer.readLine();
            temp++;
        }
        for(int j = 0;j<=column;j++){
                     buffer.read();
        }
        while(whitespace == false){
            r = buffer.read();
            column++;
            ch = (char) r;
            if(Character.isLetterOrDigit(ch) == true || ch == '_')
            {
                tempLex = tempLex+ch;
                lexeme = lexeme+ch;
            }
            else
            {
                whitespace = true;
            }
        }
        tempLex = tempLex.toLowerCase();
        switch (tempLex)
        {
            case "a":
                return "MP_IDENTIFIER";
            case "b":
                return "MP_IDENTIFIER";
            case "c":
                return "MP_IDENTIFIER";
            case "d":
                return "MP_IDENTIFIER";
            case "e":
                return "MP_IDENTIFIER";
            case "f":
                return "MP_IDENTIFIER";
            case "g":
                return "MP_IDENTIFIER";
            case "h":
                return "MP_IDENTIFIER";
            case "i":
                return "MP_IDENTIFIER";
            case "j":
                return "MP_IDENTIFIER";
            case "k":
                return "MP_IDENTIFIER";
            case "l":
                return "MP_IDENTIFIER";
            case "m":
                return "MP_IDENTIFIER";
            case "n":
                return "MP_IDENTIFIER";
            case "o":
                return "MP_IDENTIFIER";
            case "p":
                return "MP_IDENTIFIER";
            case "q":
                return "MP_IDENTIFIER";
            case "r":
                return "MP_IDENTIFIER";
            case "s":
                return "MP_IDENTIFIER";
            case "t":
                return "MP_IDENTIFIER";
            case "u":
                return "MP_IDENTIFIER";
            case "v":
                return "MP_IDENTIFIER";
            case "w":
                return "MP_IDENTIFIER";
            case "x":
                return "MP_IDENTIFIER";
            case "y":
                return "MP_IDENTIFIER";
            case "z":
                return "MP_IDENTIFIER";
            case "and":
                return andToken();
            case "begin":
                return beginToken();
            case "boolean":
                return booleanToken();
            case "div":
                return divToken();
            case "do":
                return doToken();
            case "downto":
                return downtoToken();
            case "else":
                return elseToken();
            case "end":
                return endToken();
            case "false":
                return falseToken();
            case "fixed":
                return fixedToken();
            case "float":
                return floatToken();
            case "for":
                return forToken();
            case "function":
                return functionToken();
            case "if":
                return ifToken();
            case "integer":
                return integerToken();
            case "mod":
                return modToken();
            case "not":
                return notToken();
            case "or":
                return orToken();
            case "procedure":
                return procedureToken();
            case "program":
                return programToken();
            case "read":
                return readToken();
            case "repeat":
                return repeatToken();
            case "string":
                return stringToken();
            case "then":
                return thenToken();
            case "true":
                return trueToken();
            case "to":
                return toToken();
            case "until":
                return untilToken();
            case "var":
                return varToken();
            case "while":
                return whileToken();
            case "write":
                return writeToken();
            case "writeln":
                return writelnToken();    
            default:
                return newIdentifier();
        }  
    }
    public String newIdentifier()
    {
        return "MP_IDENTIFIER";
    }  
    public int getRow()
    {
        return row;
    }
    public int getColumn()
    {
        return column;
    }
    public String getLexeme()
    {
        return lexeme;
    }
    public String andToken()
    {
        return "MP_AND";
    }public String beginToken()
    {
        return "MP_BEGIN";
    }
    public String booleanToken()
    {
        return "MP_BOOLEAN";
    }
    public String divToken()
    {
        return "MP_DIV";
    }
    public String doToken()
    {
        return "MP_DO";
    }
    public String downtoToken()
    {
        return "MP_DOWNTO";
    }
    public String elseToken()
    {
        return "MP_ELSE";
    }
    public String endToken()
    {
        return "MP_END";
    }
    public String falseToken()
    {
        return "MP_FALSE";
    }
    public String fixedToken()
    {
        return "MP_FIXED";
    }
    public String floatToken()
    {
        return "MP_FLOAT";
    }public String forToken()
    {
        return "MP_FOR";
    }
    public String functionToken()
    {
        return "MP_FUNCTION";
    }
    public String ifToken()
    {
        return "MP_IF";
    }
    public String integerToken()
    {
        return "MP_INTEGER";
    }
    public String modToken()
    {
        return "MP_MOD";
    }
    public String notToken()
    {
        return "MP_NOT";
    }
    public String orToken()
    {
        return "MP_OR";
    }
    public String procedureToken()
    {
        return "MP_PROCEDURE";
    }
    public String programToken()
    {
        return "MP_PROGRAM";
    }
    public String readToken()
    {
        return "MP_READ";
    }public String repeatToken()
    {
        return "MP_REPEAT";
    }
    public String stringToken()
    {
        return "MP_STRING";
    }
    public String thenToken()
    {
        return "MP_THEN";
    }
    public String And()
    {
        return "MP_AND";
    }
    public String trueToken()
    {
        return "MP_TRUE";
    }
    public String toToken()
    {
        return "MP_TO";
    }
    public String untilToken()
    {
        return "MP_UNTIL";
    }
    public String varToken()
    {
        return "MP_VAR";
    }
    public String whileToken()
    {
        return "MP_WHILE";
    }
    public String writeToken()
    {
        return "MP_WRITE";
    }
    public String writelnToken()
    {
        return "MP_WRITELN";
    }
}