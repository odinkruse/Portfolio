/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Compiler;
import java.io.*;

/**
 *
 * @author Anders, Calvin, Odin
 */
public class Analyzer{
    
    private static String path = "C:\\Users\\Anders\\Desktop\\uMachine_code3.il";
    private static boolean append = false;
    static boolean firstRun = true;
    
    public Analyzer(){
        
    }
    
    
    static void write(String textLine) throws IOException {
        if(firstRun == true){
            firstRun = false;
        }else{
            append = true;
        }
        FileWriter writer = new FileWriter(path, append);
        PrintWriter out = new PrintWriter(writer);
        out.println(textLine);
        out.close();
    }
    
    static void generateHeader(){
        //System.out.println("MOV SP D0");
        try{
            write("MOV SP D0");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
        
    }
    
    static void generateFooter(){
        //System.out.println("HLT");
        try{
            write("HLT");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateTrue(){
        try{
            write("PUSH #1");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateFalse(){
        try{
            write("PUSH #0");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateWriteS(){
        //System.out.println("WRTS");
        try{
            write("WRTS");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateWriteLnS(){
        try{
            write("WRTLNS");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateNegate(){
        try{
            write("NEGS");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generatePush(int value){
        //System.out.println("PUSH #" + value);
        try{
            write("PUSH #" + value);
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generatePushF(float value){
        //System.out.println("PUSH #" + value);
        try{
            write("PUSH #" + value);
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generatePushS(String value){
        //System.out.println("PUSH \"" + value + "\"");
        try{
            write("PUSH \"" + value + "\"");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generatePushIdent(int offset, int nestingLevel){
        //System.out.println("PUSH " + offset + "(d" + nestingLevel + ")");
        try{
            write("PUSH " + offset + "(d" + nestingLevel + ")");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generatePop(int offset, int nestingLevel){
        //System.out.println("POP " + offset + "(d" + nestingLevel + ")");
        try{
            write("POP " + offset + "(d" + nestingLevel + ")");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateRead(int offset, int nestingLevel){
        //System.out.println("RD " + offset + "(d" + nestingLevel + ")");
        try{
            write("RD " + offset + "(d" + nestingLevel +")");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateReadF(int offset, int nestingLevel){
        //System.out.println("RDF " + offset + "(d" + nestingLevel + ")");
        try{
            write("RDF " + offset + "(d" + nestingLevel + ")");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateReadS(int offset, int nestingLevel){
        //System.out.println("RDS " + offset + "(d" + nestingLevel + ")");
        try{
            write("RDS " + offset + "(d" + nestingLevel + ")");
        }catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    static void generateAdd(String type1, String type2){
        if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("ADDSF");
            try{
                write("CASTSF");
                write("ADDSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("ADDSF");
            try{
                write("CSTSF");
                write("ADDSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("ADDSF");
            try{
                write("CASTSF");
                write("ADDSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("ADDSF");
            try{
                write("CASTSF");
                write("ADDSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER") && type2.equals("MP_FLOAT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("ADDSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("ADDSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER_LIT") && type2.equals("MP_FLOAT_LIT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("ADDSF");
            try{
                write("MOV -2(SP) 0(SP");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("ADDSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if((type1.equals("MP_STRING") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING") && !type2.equals("MP_STRING_LIT")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING_LIT"))){
            //System.out.println("Type Mismatch : Can not add Strings and Non Strings");
            try{
                write("Type Mismatch : Can not add Strings and Non Strings");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else{
            //System.out.println("ADDS");
            try{
                write("ADDS");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }
    }
    
    static void generateSubtract(String type1, String type2){
        if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("SUBSF");
            try{
                write("CASTSF");
                write("SBUSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("SUBSF");
            try{
                write("CASTSF");
                write("SUBSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("SUBSF");
            try{
                write("CASTSF");
                write("SUBSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("SUBSF");
            try{
                write("CASTSF");
                write("SUBSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER") && type2.equals("MP_FLOAT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("SUBSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("SUBSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER_LIT") && type2.equals("MP_FLOAT_LIT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("SUBSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("SUBSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if((type1.equals("MP_STRING") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING") && !type2.equals("MP_STRING_LIT")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING_LIT"))){
            //System.out.println("Type Mismatch : Can not subtract Strings and Non Strings");
            try{
                write("Type Mismatch : Can not subtract Strings and Non Strings");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else{
            //System.out.println("SUBS");
            try{
                write("SUBS");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }
    }
    
    static void generateDivide(String type1, String type2){
        if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("DIVSF");
            try{
                write("CASTSF");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("DIVSF");
            try{
                write("CASTSF");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("DIVSF");
            try{
                write("CASTSF");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("DIVSF");
            try{
                write("CASTSF");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER") && type2.equals("MP_FLOAT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("DIVSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER_LIT") && type2.equals("MP_FLOAT_LIT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("DIVSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if((type1.equals("MP_STRING") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING") && !type2.equals("MP_STRING_LIT")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING_LIT"))){
            //System.out.println("Type Mismatch : Can not divide Strings and Non Strings");
            try{
                write("Type Mismatch : Can not divide Strings and Non Strings");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else{
            //System.out.println("DIVS");
            try{
                write("DIVS");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }
    }
    
    static void generateDivideF(String type1, String type2){
        if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("DIVSF");
            try{
                write("CASTSF");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("DIVSF");
            try{
                write("CASTSF");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("DIVSF");
            try{
                write("CASTSF");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("DIVSF");
            try{
                write("CASTSF");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER") && type2.equals("MP_FLOAT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("DIVSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER_LIT") && type2.equals("MP_FLOAT_LIT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("DIVSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if((type1.equals("MP_STRING") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING") && !type2.equals("MP_STRING_LIT")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING_LIT"))){
            //System.out.println("Type Mismatch : Can not divide Strings and Non Strings");
            try{
                write("Type Mismatch : Can not divide Strings and Non Strings");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else{
            //System.out.println("DIVSF");
            try{
                write("DIVSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }
    }
    
    static void generateMultiply(String type1, String type2){
        if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("MULSF");
            try{
                write("CASTSF");
                write("MULSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("MULSF");
            try{
                write("CASTSF");
                write("MULSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT") && type2.equals("MP_INTEGER_LIT")){
            //System.out.println("CASTSF");
            //System.out.println("MULSF");
            try{
                write("CASTSF");
                write("MULSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_FLOAT_LIT") && type2.equals("MP_INTEGER")){
            //System.out.println("CASTSF");
            //System.out.println("MULSF");
            try{
                write("CASTSF");
                write("MULSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER") && type2.equals("MP_FLOAT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("MULSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("MULSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if(type1.equals("MP_INTEGER_LIT") && type2.equals("MP_FLOAT_LIT")){
            //System.out.println("MOV -2(SP) 0(SP)");
            //System.out.println("ADD SP #1 SP");
            //System.out.println("CASTSF");
            //System.out.println("MOV -1(SP) -3(SP)");
            //System.out.println("SUB SP #1 SP");
            //System.out.println("MULSF");
            try{
                write("MOV -2(SP) 0(SP)");
                write("ADD SP #1 SP");
                write("CASTSF");
                write("MOV -1(SP) -3(SP)");
                write("SUB SP #1 SP");
                write("MULSF");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else if((type1.equals("MP_STRING") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING") && !type2.equals("MP_STRING_LIT")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING")) || (type1.equals("MP_STRING_LIT") && !type2.equals("MP_STRING_LIT"))){
            //System.out.println("Type Mismatch : Can not multiply Strings and Non Strings");
            try{
                write("Type Mismatch : Can not multiply Strings and Non Strings");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else{
            //System.out.println("MULS");
            try{
                write("MULS");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }
    }
    
    static void generateMod(String type1, String type2){
        if((type1.equals("MP_INTEGER") && type2.equals("MP_INTEGER")) || (type1.equals("MP_INTEGER_LIT") && type2.equals("MP_INTEGER_LIT"))){
            //System.out.println("MODS");
            try{
                write("MODS");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }else{
            //System.out.println("Syntax Error : Expecting Integer, Integer input");
            try{
                write("Syntax Error : Expecting Integer, Integer input");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }
    }    
    
    static void generateCompEq(){
        //System.out.println("CMPEQS");
        try{
                write("CMPEQS");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
    }
    
    static void generateCompGe(){
        //System.out.println("CMPGES");
        try{
                write("CMPGES");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
    }
    
    static void generateCompGt(){
        //System.out.println("CMPGTS");
        try{
                write("CMPGTS");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
    }
    
    static void generateCompLe(){
        //System.out.println("CMPLES");
        try{
                write("CMPLES");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
    }
    
    static void generateCompLt(){
        //System.out.println("CMPLTS");
        try{
                write("CMPLTS");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
    }
    
    static void generateCompNe(){
        //System.out.println("CMPNES");
        try{
                write("CMPNES");
            }catch(IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
    }
}
