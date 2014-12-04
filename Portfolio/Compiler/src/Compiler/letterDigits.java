/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compiler;

import java.io.*;

/**
 *@author Anders, Calvin, Odin
 * Only going to handle digits, but this includes digits, integer_lit,
 * fixed_lit, and Float_lit
 *
 */
public class letterDigits {

    File file;
    int row, column;
    char token, next_token;
    String lexeme = "";
    int c = 0;

    public letterDigits(File in_file, int in_row, int in_column, char first_token) {
        file = in_file;
        row = in_row;
        column = in_column;
        token = first_token;
    }

    public String getToken() throws IOException {
        lexeme = lexeme + token;
        column++;
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        try {
            for(int i = 0;i<row;i++){
                    buffer.readLine();
                }
                for(int j = 0;j<=column-1;j++){
                    buffer.read();
                }
                next_token = (char)buffer.read();
            //if (Character.isDigit(next_token)) {
                if(next_token == ' '){
                    return "MP_INTEGER_LIT";
                }
                while (Character.isDigit(next_token)) {
                    lexeme = lexeme + next_token;
                    column++;
                    next_token = (char) buffer.read();
                }
                
                
                if (next_token == '.') {
                    lexeme = lexeme + next_token;
                    column++;
                    next_token = (char) buffer.read();
                    if (Character.isDigit(next_token)) {
                        while (Character.isDigit(next_token)) {
                            lexeme = lexeme + next_token;
                            column++;
                            next_token = (char) buffer.read();
                        }
                        if (next_token == 'e' || next_token == 'E') {
                            lexeme = lexeme + next_token;
                            column++;
                            next_token = (char) buffer.read();
                            if (Character.isDigit(next_token)) {
                                while (Character.isDigit(next_token)) {
                                    lexeme = lexeme + next_token;
                                    column++;
                                    next_token = (char) buffer.read();
                                }
                                return "MP_FLOAT_LIT";
                            } else if (next_token == '+' || next_token == '-') {
                                lexeme = lexeme + next_token;
                                column++;
                                next_token = (char) buffer.read();
                                if (Character.isDigit(next_token)) {
                                    while (Character.isDigit(next_token)) {
                                        lexeme = lexeme + next_token;
                                        column++;
                                        next_token = (char) buffer.read();
                                    }
                                    return "MP_FLOAT_LIT";
                                } else {
                                    return "ERROR";
                                }
                            } else {
                                return "ERROR";
                            }
                        } else {
                            return "MP_FLOAT_LIT";      //MP_FIXED_LIT
                        }
                    } else {
                        return "ERROR";
                    }
                } else if (next_token == 'e' || next_token == 'E') {
                    lexeme = lexeme + next_token;
                    column++;
                    next_token = (char) buffer.read();
                    if (Character.isDigit(next_token)) {
                        while (Character.isDigit(next_token)) {
                            lexeme = lexeme + next_token;
                            column++;
                            next_token = (char) buffer.read();
                        }
                        return "MP_FLOAT_LIT";
                    } else if (next_token == '+' || next_token == '-') {
                        lexeme = lexeme + next_token;
                        column++;
                        next_token = (char) buffer.read();
                        if (Character.isDigit(next_token)) {
                            while (Character.isDigit(next_token)) {
                                lexeme = lexeme + next_token;
                                column++;
                                next_token = (char) buffer.read();
                            }
                            return "MP_FLOAT_LIT";

                        } else {
                            return "ERROR";
                        }
                    } else {
                        return "ERROR";
                    }
                } else {
                    return "MP_INTEGER_LIT";
                }
            /*} else {
                return "digit";
            }*/
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
            return "ERROR";
        }
    }

    public String getLexeme() {
        return lexeme;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
