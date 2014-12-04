/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compiler;

import java.util.ArrayList;

/**
 *
 * @author Anders, Calvin, Odin
 */
public class Parser {
    
    ArrayList<String> tList;
    ArrayList<String> lList;
    boolean syntax_error = false;
    SymbolTable st = new SymbolTable();
    ArrayList<String> varList = new ArrayList<String>();
    public int offset = 0;
    public int nestingLevel;
    public String type1, type2, type1temp, type2temp, type1type, type2type;
    public boolean negateTerm = false;
    
    public Parser(ArrayList<String> tokenList, ArrayList<String> lexemeList) {
        tList= tokenList;
        lList = lexemeList;
        parserMethod(tList, lList, Globals.tokenCounter);

    }

    private void parserMethod(ArrayList tokenList, ArrayList lexemeList, int tokenCounter) {
        //String token = nextToken(tokenList, tokenCounter);
        Globals.token = tokenList.get(tokenCounter).toString();
        Globals.lexeme = lexemeList.get(tokenCounter).toString();
        system_Goal();


    }

    private void nextToken(ArrayList tokenList, int tokenCounter) {
        String nextToken = tokenList.get(tokenCounter + 1).toString();
        String nextLexeme = lList.get(tokenCounter + 1).toString();
        Globals.tokenCounter++;
        Globals.token = nextToken;
        Globals.lexeme = nextLexeme;
    }

    public void system_Goal() {
        program();                                          //Rule 1
        if(syntax_error == false){
            EOF();
        }
    }

    public void program() {
        Analyzer.generateHeader();                          //Move the stack pointer to D0
        program_Heading();                                  //Rule 2
        if(Globals.token.equals("MP_SCOLON")){
            match(Globals.token, "MP_SCOLON");
        }else{
            syntax_Error();
        }
        block();
        if(Globals.token.equals("MP_PERIOD")){
            match(Globals.token, "MP_PERIOD");
        }else{
            syntax_Error();
        }
        Analyzer.generateFooter();
        st.printSTable();
        st.destroySTable();                                 //destroy main symbol table
    }

    public void program_Heading() {
        if(Globals.token.equals("MP_PROGRAM")){             //Rule 3
            match(Globals.token, "MP_PROGRAM");
        }else{
            syntax_Error();
        }
        st.createSTable(Globals.lexeme, 0);                  //Create main Symbol Table
        program_Identifier();
    }

    public void block() {
        variable_Declaration_Part();                        //Rule 4
        procedure_And_Function_Declaration_Part();
        statement_Part();
    }

    public void variable_Declaration_Part() {
        if(Globals.token.equals("MP_VAR")){                 //Rule 5
            match(Globals.token, "MP_VAR");
            variable_Declaration();
            if(Globals.token.equals("MP_SCOLON")){
                match(Globals.token, "MP_SCOLON");
            }else{
                syntax_Error();
            }
            variable_Declaration_Tail();
        }else if(Globals.token.equals("MP_BEGIN") || Globals.token.equals("MP_FUNCTION") || Globals.token.equals("MP_PROCEDURE")){
            //Rule 6
            //epsilon
        }else{
            syntax_Error();
        }
    }

    public void variable_Declaration_Tail() {
        if(Globals.token.equals("MP_IDENTIFIER")){          //Rule 7
            variable_Declaration();
            if(Globals.token.equals("MP_SCOLON")){
                match(Globals.token, "MP_SCOLON");
            }else{
                syntax_Error();
            }
            variable_Declaration_Tail();
        }else if(Globals.token.equals("MP_BEGIN") || Globals.token.equals("MP_FUCTION") || Globals.token.equals("MP_PROCEDURE")){
            //Rule 8
            //epsilon
        }else{
            syntax_Error();
        }
    }
    public void variable_Declaration()
    {
        identifier_List();                                  //Rule 9
        if(Globals.token.equals("MP_COLON")){
            match(Globals.token, "MP_COLON");
        }else{
            syntax_Error();
        }
        for(int x=0; x < varList.size(); x ++){
            st.insert(varList.get(x), Globals.token, "local", null, offset);
            offset++;
        }
        varList.clear();
        type();
    }
    public void type()
    {
        if(Globals.token.equals("MP_INTEGER")){             //Rule 10
            match(Globals.token, "MP_INTEGER");
        }else if(Globals.token.equals("MP_FLOAT")){         //Rule 11
            match(Globals.token, "MP_FLOAT");
        }else if(Globals.token.equals("MP_STRING")){        //Rule 12
            match(Globals.token, "MP_STRING");
        }else if(Globals.token.equals("MP_BOOLEAN")){       //Rule 13
            match(Globals.token, "MP_BOOLEAN");
        }else{
            syntax_Error();
        }

    }
    public void procedure_And_Function_Declaration_Part()
    {
        if(Globals.token.equals("MP_PROCEDURE")){           //Rule 14
            procedure_Declaration();
            procedure_And_Function_Declaration_Part();
        }else if(Globals.token.equals("MP_FUNCTION")){      //Rule 15
            function_Declaration();
            procedure_And_Function_Declaration_Part();
        }else if(Globals.token.equals("MP_BEGIN")){         //Rule 16
            //epsilon
        }else{
            syntax_Error();
        }
    }
    public void procedure_Declaration()
    {
        procedure_Heading();
        if(Globals.token.equals("MP_SCOLON")){          //Rule 17
            match(Globals.token, "MP_SCOLON");
        }else{
            syntax_Error();
        }
        block();
        if(Globals.token.equals("MP_SCOLON")){
            match(Globals.token, "MP_SCOLON");
        }else{
            syntax_Error();
        }
    }
    public void function_Declaration()
    {
        function_Heading();
        if(Globals.token.equals("MP_SCOLON")){         //Rule 18
            match(Globals.token, "MP_SCOLON");
        }else{
            syntax_Error();
        }
        block();
        if(Globals.token.equals("MP_SCOLON")){         
            match(Globals.token, "MP_SCOLON");
        }else{
            syntax_Error();
        }
    }
    public void procedure_Heading()
    {
        if(Globals.token.equals("MP_PROCEDURE")){       //Rule 19
            match(Globals.token, "MP_PROCEDURE");
            procedure_Identifier();
            optional_Formal_Parameter_List();
        }else{
            syntax_Error();
        }
    }
    public void function_Heading()
    {
        if(Globals.token.equals("MP_FUNCTION")){        //Rule 20
            match(Globals.token, "MP_FUNCTION");
            function_Identifier();
            optional_Formal_Parameter_List();
            if(Globals.token.equals("MP_COLON")){
                match(Globals.token, "MP_COLON");
            }else{
                syntax_Error();
            }
            type();
        }else{
            syntax_Error();
        }
    }
    public void optional_Formal_Parameter_List()
    {
        if(Globals.token.equals("MP_LPAREN")){      //Rule 21
            match(Globals.token, "MP_LPAREN");
            formal_Parameter_Section();
            formal_Parameter_Section_Tail();
            if(Globals.token.equals("MP_RPAREN")){
                match(Globals.token, "MP_RPAREN");
            }else{
                syntax_Error();
                
            }
        }else if(Globals.token.equals("MP_BEGIN") || Globals.token.equals("MP_BOOLEAN") || Globals.token.equals("MP_FLOAT") || Globals.token.equals("MP_FUNCTION") || Globals.token.equals("MP_INTEGER") || Globals.token.equals("MP_PROCEDURE") || Globals.token.equals("MP_STRING")){
            //Rule 22
            //epsilon
        }else{
            syntax_Error();
        }
    }
    public void formal_Parameter_Section_Tail()
    {
        if(Globals.token.equals("MP_SCOLON")){          //Rule 23
            match(Globals.token, "MP_SCOLON");
            formal_Parameter_Section();
            formal_Parameter_Section_Tail();
        }else if(Globals.token.equals("MP_RPAREN")){    //Rule 24
            //epsilon
        }else{
            syntax_Error();
            
        }
    }
    public void formal_Parameter_Section()
    {
        if(Globals.token.equals("MP_IDENTIFIER")){      //Rule 25
            value_Parameter_Section();
        }else if(Globals.token.equals("MP_VAR")){       //Rule 26
            variable_Parameter_Section();
        }else{
            syntax_Error();
            
        }
    }
    public void value_Parameter_Section()
    {
        identifier_List();                              //Rule 27
        if(Globals.token.equals("MP_COLON")){
            match(Globals.token, "MP_COLON");
        }else{
            syntax_Error();
        }
        type();
    }
    public void variable_Parameter_Section()
    {
        if(Globals.token.equals("MP_VAR")){             //Rule 28
            match(Globals.token, "MP_VAR");
            identifier_List();
            if(Globals.token.equals("MP_COLON")){
                match(Globals.token, "MP_COLON");
            }else{
                syntax_Error();
            }
            type();
        }else{
            syntax_Error();
        }
    }
    public void statement_Part()
    {
        compound_Statement();
    }
    public void compound_Statement()
    {
        if(Globals.token.equals("MP_BEGIN")){           //Rule 30
            match(Globals.token, "MP_BEGIN");
            statement_Sequence();
            if(Globals.token.equals("MP_END")){
                match(Globals.token, "MP_END");
            }else{
                syntax_Error();
            }
        }else{
            syntax_Error();
        }
    }
    public void statement_Sequence()
    {
        statement();
        statement_Tail();
    }
    public void statement_Tail()
    {
        if(Globals.token.equals("MP_SCOLON")){      //Rule 32
            match(Globals.token, "MP_SCOLON");
            statement();
            statement_Tail();
        }else if(Globals.token.equals("MP_END")){   //Rule 33
            //epsilon
        }else{
            syntax_Error();
        }
    }
    public void statement()
    {
        if(Globals.token.equals("MP_END") || Globals.token.equals("MP_SCOLON")){            //Rule 34
            empty_Statement();
        }else if(Globals.token.equals("MP_BEGIN")){                                         //Rule 35
            compound_Statement();
        }else if(Globals.token.equals("MP_READ")){                                          //Rule 36
            read_Statement();
        }else if(Globals.token.equals("MP_WRITE") || Globals.token.equals("MP_WRITELN")){   //Rule 37
            write_Statement();
        }else if(Globals.token.equals("MP_IDENTIFIER")){                                    //Rule 38
            assignment_Statement();
        }else if(Globals.token.equals("MP_IF")){                                            //Rule 39
            if_Statement();
        }else if(Globals.token.equals("MP_WHILE")){                                         //Rule 40
            while_Statement();
        }else if(Globals.token.equals("MP_REPEAT")){                                        //Rule 41
            repeat_Statement();
        }else if(Globals.token.equals("MP_FOR")){                                           //Rule 42
            for_Statement();
        /*
         * 
         * NOT SURE HOW TO HANDLE AMBIGUITY
         * RULE 38 AND 43 BOTH GO TO IDENTIFIER
         * 
         *
        }else if(Globals.token.equals("MP_IDENTIFIER")){                                    //Rule 43
            procedure_Statement();
            * 
            */
        }else{
            syntax_Error();
        }
    }
    public void empty_Statement()
    {
        if(Globals.token.equals("MP_END") || Globals.token.equals("MP_SCOLON")){            //Rule 44
            //epsilon
        }else{
            syntax_Error();
        }
    }
    public void read_Statement()
    {
        if(Globals.token.equals("MP_READ")){                //Rule 45
            match(Globals.token, "MP_READ");
            if(Globals.token.equals("MP_LPAREN")){
                match(Globals.token, "MP_LPAREN");
            }else{
                syntax_Error();
            }
            
            read_Parameter();
            read_Parameter_Tail();
            if(Globals.token.equals("MP_RPAREN")){
                match(Globals.token, "MP_RPAREN");
            }else{
                syntax_Error();
            }
        }else{
            syntax_Error();

        }
    }
    public void read_Parameter_Tail()
    {
        if(Globals.token.equals("MP_COMMA")){           //Rule 46
            match(Globals.token, "MP_COMMA");
            read_Parameter();
            read_Parameter_Tail();
        }else if(Globals.token.equals("MP_RPAREN")){    //Rule 47
            //epsilon
        }else{
            syntax_Error();
            
        }
    }
    public void read_Parameter()
    {
        offset = st.lookupOffset(Globals.lexeme);
        nestingLevel = st.lookupNestingLevel(Globals.lexeme);
        String varType = st.lookupVarType(Globals.lexeme);
        variable_Identifier();
        if(varType.equals("MP_INTEGER")){
            Analyzer.generateRead(offset, nestingLevel);
        }else if(varType.equals("MP_FLOAT")){
            Analyzer.generateReadF(offset, nestingLevel);
        }else if(varType.equals("MP_STRING")){
            Analyzer.generateReadS(offset, nestingLevel);
        }
    }
    public void write_Statement()
    {
        if(Globals.token.equals("MP_WRITE")){           //Rule 49
            match(Globals.token, "MP_WRITE");
            if(Globals.token.equals("MP_LPAREN")){
                match(Globals.token, "MP_LPAREN");
            }else{
                syntax_Error();
                
            }
            write_Parameter("Write");
            write_Parameter_Tail("Write");
            if(Globals.token.equals("MP_RPAREN")){
                match(Globals.token, "MP_RPAREN");
            }else{
                syntax_Error();
            }
        }else if(Globals.token.equals("MP_WRITELN")){   //Rule 50
            match(Globals.token, "MP_WRITELN");
            if(Globals.token.equals("MP_LPAREN")){
                match(Globals.token, "MP_LPAREN");
            }else{
                syntax_Error();
            }
            write_Parameter("WriteLine");
            write_Parameter_Tail("writeLine");
            if(Globals.token.equals("MP_RPAREN")){
                match(Globals.token, "MP_RPAREN");
            }else{
                syntax_Error();
                
            }
        }
    }
    public void write_Parameter_Tail(String record)
    {
        if(Globals.token.equals("MP_COMMA")){           //Rule 51
            match(Globals.token, "MP_COMMA");
            write_Parameter(record);
            write_Parameter_Tail(record);
        }else if(Globals.token.equals("MP_RPAREN")){    //Rule 52
            //epsilon
        }else{
            syntax_Error();
            
        }
    }
    public void write_Parameter(String record)
    {
        ordinal_Expression();
        if(record.equals("Write")){
            Analyzer.generateWriteS();
        }else{
            Analyzer.generateWriteLnS();
        }
    }
    public void assignment_Statement()
    {
        /*
         * AMBIGUITY
         * RULE 54 AND 55 GO TO IDENTIFIER
         * 
         * 
         */
        if (Globals.token.equals("MP_IDENTIFIER"))
        {
            String popLocation = Globals.lexeme;
            variable_Identifier();
            if (Globals.token.equals("MP_ASSIGN"))
            {
                match(Globals.token, "MP_ASSIGN");
            }else 
            {
                syntax_Error();
            }
            expression();
            Analyzer.generatePop(st.lookupOffset(popLocation), st.lookupNestingLevel(popLocation));
        }else 
        {
            syntax_Error();
        }
    }
    public void if_Statement()
    {
        if(Globals.token.equals("MP_IF")){          //Rule 56
            match(Globals.token, "MP_IF");
            boolean_Expression();
            if(Globals.token.equals("MP_THEN")){
                match(Globals.token, "MP_THEN");
            }else{
                syntax_Error();
            }
            statement();
            optional_Else_Part();
        }else{
            syntax_Error();
        }
    }
    public void optional_Else_Part()
    {
        if(Globals.token.equals("MP_ELSE")){                //Rule 57
            match(Globals.token, "MP_ELSE");
            statement();
        }else if(Globals.token.equals("MP_SCOLON") || Globals.token.equals("MP_END")){  //Rule 58
            //epsilon
        }else{
            syntax_Error();
        }
    }
    public void repeat_Statement()
    {
        if(Globals.token.equals("MP_REPEAT")){              //Rule 59
            match(Globals.token, "MP_REPEAT");
            statement_Sequence();
            if(Globals.token.equals("MP_UNTIL")){
                match(Globals.token, "MP_UNTIL");
            }else{
                syntax_Error();
            }
            boolean_Expression();
        }else{
            syntax_Error();
        }
    }
    public void while_Statement()
    {
        if(Globals.token.equals("MP_WHILE")){              //Rule 60
            match(Globals.token, "MP_WHILE");
            boolean_Expression();
            if(Globals.token.equals("MP_DO")){
                match(Globals.token, "MP_DO");
            }else{
                syntax_Error();
            }
            statement();
        }else{
            syntax_Error();
        }
    }
    public void for_Statement()
    {
        if(Globals.token.equals("MP_FOR")){                 //Rule 61
            match(Globals.token, "MP_FOR");
            control_Variable();
            if(Globals.token.equals("MP_ASSIGN")){
                match(Globals.token, "MP_ASSIGN");
            }else{
                syntax_Error();
            }
            initial_Value();
            step_Value();
            final_Value();
            if(Globals.token.equals("MP_DO")){
                match(Globals.token, "MP_DO");
            }else{
                syntax_Error();
            }
            statement();
        }else{
            syntax_Error();
        }
    }
    public void control_Variable()
    {
        variable_Identifier();                      //Rule 62
    }
    public void initial_Value()
    {
        ordinal_Expression();                       //Rule 63
    }
    public void step_Value()
    {
        if(Globals.token.equals("MP_TO")){          //Rule 64
            match(Globals.token, "MP_TO");
        }else if(Globals.token.equals("MP_DOWNTO")){    //Rule 65
            match(Globals.token, "MP_DOWNTO");
        }else{
            syntax_Error();
        }
    }
    public void final_Value()
    {
        ordinal_Expression();                       //Rule 66
    }
    public void procedure_Statement()
    {
        procedure_Identifier();                     //Rule 67
        optional_Actual_Parameter_List();
    }
    public void optional_Actual_Parameter_List()
    {
        if(Globals.token.equals("MP_LPAREN")){      //Rule 68
            match(Globals.token, "MP_LPAREN");
            actual_Parameter();
            actual_Parameter_Tail();
            if(Globals.token.equals("MP_RPAREN")){
                match(Globals.token, "MP_RPAREN");
            }else{
                syntax_Error();
                
            }
        }else if(Globals.token.equals("MP_AND") || Globals.token.equals("MP_DIV") || Globals.token.equals("MP_DO") || Globals.token.equals("MP_DOWNTO") || Globals.token.equals("MP_ELSE") || Globals.token.equals("MP_END") || Globals.token.equals("MP_MOD") || Globals.token.equals("MP_OR") || Globals.token.equals("MP_THEN") || Globals.token.equals("MP_TO") || Globals.token.equals("MP_COMMA") || Globals.token.equals("MP_FLOAT_DIVIDE") || Globals.token.equals("MP_MINUS") || Globals.token.equals("MP_PLUS") || Globals.token.equals("MP_RPAREN") || Globals.token.equals("MP_SCOLON") || Globals.token.equals("MP_TIMES")){
            //Rule 69
            //epsilon
        }else{
            syntax_Error();
            
        }
    }
    public void actual_Parameter_Tail()
    {
        if(Globals.token.equals("MP_COMMA")){                   //Rule 70
            match(Globals.token, "MP_COMMA");
            actual_Parameter();
            actual_Parameter_Tail();
        }else if(Globals.token.equals("MP_RPAREN")){            //Rule 71
            //epsilon
        }else{
            syntax_Error();
            
        }
    }
    public void actual_Parameter()
    {
        ordinal_Expression();
    }
    public void expression()
    {
        simple_Expression();
        optional_Relational_Part();
    }
    public void optional_Relational_Part()      
    {
        if(Globals.token.equals("MP_EQUAL")){           //Rule 74
            relational_Operator();
            simple_Expression();
            Analyzer.generateCompEq();
        }else if(Globals.token.equals("MP_GEQUAL")){    //Rule 74
            relational_Operator();
            simple_Expression();
            Analyzer.generateCompGe();
        }else if(Globals.token.equals("MP_GTHAN")){     //Rule 74
            relational_Operator();
            simple_Expression();
            Analyzer.generateCompGt();
        }else if(Globals.token.equals("MP_LEQUAL")){    //Rule 74
            relational_Operator();
            simple_Expression();
            Analyzer.generateCompLe();
        }else if(Globals.token.equals("MP_LTHAN")){     //Rule 74
            relational_Operator();
            simple_Expression();
            Analyzer.generateCompLt();
        }else if(Globals.token.equals("MP_NEQUAL")){    //Rule 74
            relational_Operator();
            simple_Expression();
            Analyzer.generateCompNe();
        }else if(Globals.token.equals("MP_DO")){        //Rule 75
            //epsilon
        }else if(Globals.token.equals("MP_DOWNTO")){    //Rule 75
            //epsilon
        }else if(Globals.token.equals("MP_END")){       //Rule 75
            //epsilon
        }else if(Globals.token.equals("MP_THEN")){      //Rule 75
            //epsilon
        }else if(Globals.token.equals("MP_TO")){        //Rule 75
            //epsilon
        }else if(Globals.token.equals("MP_COMMA")){     //Rule 75
            //epsilon
        }else if(Globals.token.equals("MP_RPAREN")){    //Rule 75
            //epsilon
        }else if(Globals.token.equals("MP_SCOLON")){    //Rule 75
            //epsilon
        }else{
            syntax_Error();
        }
    }
    public void relational_Operator()
    {
        if(Globals.token.equals("MP_EQUAL")){           //Rule 76
            match(Globals.token, "MP_EQUAL");
        }else if(Globals.token.equals("MP_LTHAN")){     //Rule 77
            match(Globals.token, "MP_LTHAN");
        }else if(Globals.token.equals("MP_GTHAN")){     //Rule 78
            match(Globals.token, "MP_GTHAN");
        }else if(Globals.token.equals("MP_LEQUAL")){    //Rule 79
            match(Globals.token, "MP_LEQUAL");
        }else if(Globals.token.equals("MP_GEQUAL")){    //Rule 80
            match(Globals.token, "MP_GEQUAL");
        }else if(Globals.token.equals("MP_NEQUAL")){    //Rule 81
            match(Globals.token, "MP_NEQUAL");
        }else{
            syntax_Error();
        }
    }
    public void simple_Expression()
    {
        if(Globals.token.equals("MP_MINUS")){
            negateTerm = true;
        }
        optional_Sign();                //Rule 82
        type1 = Globals.token;
        if(type1.equals("MP_IDENTIFIER")){
            type1temp = Globals.lexeme;
            type1type = st.lookupVarType(type1temp);
        }else{
            type1type = Globals.token;
        }
        //System.out.println(Globals.token);
        term();
        if(Globals.token.equals("MP_RPAREN")){
            if(negateTerm == true){
                Analyzer.generateNegate();
                negateTerm = false;
            }
        }
        term_Tail();
        
    }
    public void term_Tail()
    {
        if(Globals.token.equals("MP_OR") || Globals.token.equals("MP_MINUS") || Globals.token.equals("MP_PLUS")){   //Rule 83
            String addOp = Globals.token;
            adding_Operator();
            type2 = Globals.token;
            if(type2.equals("MP_IDENTIFIER")){
                type2temp = Globals.lexeme;
                type2type = st.lookupVarType(type2temp);
            }else{
                type2type = Globals.token;
            }
            term();
            if(addOp.equals("MP_MINUS")){
                Analyzer.generateSubtract(type1type, type2type);
            }else if(addOp.equals("MP_PLUS")){
                Analyzer.generateAdd(type1type, type2type);
            }else if(addOp.equals("MP_OR")){
                //whatever MP_OR does
            }else{
                System.out.println("THIS SHOULDN'T HAPPEN");
                syntax_Error(); //This should never happen
            }
            term_Tail();
        }else if(Globals.token.equals("MP_DO") || Globals.token.equals("MP_DOWNTO") || Globals.token.equals("MP_END") || Globals.token.equals("MP_THEN") || Globals.token.equals("MP_TO") || Globals.token.equals("MP_COMMA") || Globals.token.equals("MP_RPAREN") || Globals.token.equals("MP_SCOLON") || Globals.token.equals("MP_EQUAL") || Globals.token.equals("MP_LTHAN") || Globals.token.equals("MP_GTHAN") || Globals.token.equals("MP_LEQUAL") || Globals.token.equals("MP_GEQUAL") || Globals.token.equals("MP_NEQUAL")){
            //Rule 84
            //epsilon
        }else{
            syntax_Error();
            
        }
    }
    public void optional_Sign()
    {
        if(Globals.token.equals("MP_PLUS")){            //Rule 85
            match(Globals.token, "MP_PLUS");
            //nothing happens..i think
        }else if(Globals.token.equals("MP_MINUS")){     //Rule 86
            match(Globals.token, "MP_MINUS");
        }else if(Globals.token.equals("MP_FALSE") || Globals.token.equals("MP_NOT") || Globals.token.equals("MP_TRUE") || Globals.token.equals("MP_IDENTIFIER") || Globals.token.equals("MP_INTEGER_LIT") || Globals.token.equals("MP_FLOAT_LIT") || Globals.token.equals("MP_STRING_LIT") || Globals.token.equals("MP_RPAREN") || Globals.token.equals("MP_LPAREN")){
            //Rules 87
            //epsilon
        }else{
            syntax_Error();
            
        }
    }
    public void adding_Operator()
    {
        if(Globals.token.equals("MP_PLUS")){        //Rule 88
            match(Globals.token, "MP_PLUS");
        }else if(Globals.token.equals("MP_MINUS")){ //Rule 89
            match(Globals.token, "MP_MINUS");
        }else if(Globals.token.equals("MP_OR")){    //Rule 90
            match(Globals.token, "MP_OR");
        }else{
            syntax_Error();
        }
    }
    public void term()
    {
        factor();                               //Rule 91
        factor_Tail();
    }
    public void factor_Tail()
    {
        if(Globals.token.equals("MP_AND") || Globals.token.equals("MP_DIV") || Globals.token.equals("MP_MOD") || Globals.token.equals("MP_FLOAT_DIVIDE") || Globals.token.equals("MP_TIMES")){
            //Rule 92
            String mulOp = Globals.token;
            multiplying_Operator();
            type2 = Globals.token;
            if(type2.equals("MP_IDENTIFIER")){
                type2temp = Globals.lexeme;
                type2type = st.lookupVarType(type2temp);
            }else{
                type2type = Globals.token;
            }
            factor();
            if(mulOp.equals("MP_AND")){
                //do whatever MP_AND does
            }else if(mulOp.equals("MP_DIV")){
                Analyzer.generateDivide(type1type, type2type);
            }else if(mulOp.equals("MP_TIMES")){
                Analyzer.generateMultiply(type1type, type2type);
            }else if(mulOp.equals("MP_MOD")){
                Analyzer.generateMod(type1type, type2type);
            }else if(mulOp.equals("MP_FLOAT_DIVIDE")){
                Analyzer.generateDivideF(type1type, type2type);
            }else{
                syntax_Error(); //This should never happen
            }
            factor_Tail();
        }else if(Globals.token.equals("MP_DO") || Globals.token.equals("MP_DOWNTO") || Globals.token.equals("MP_END") || Globals.token.equals("MP_OR") || Globals.token.equals("MP_THEN") || Globals.token.equals("MP_TO") || Globals.token.equals("MP_IDENTIFIER") || Globals.token.equals("MP_COMMA") || Globals.token.equals("MP_MINUS") || Globals.token.equals("MP_PLUS") || Globals.token.equals("MP_RPAREN") || Globals.token.equals("MP_SCOLON") || Globals.token.equals("MP_EQUAL") || Globals.token.equals("MP_LTHAN") || Globals.token.equals("MP_GTHAN") || Globals.token.equals("MP_LEQUAL") || Globals.token.equals("MP_GEQUAL") || Globals.token.equals("MP_NEQUAL")){
            //Rule 93
            //epsilon
        }else{
            syntax_Error();
            
        }
    }
    public void multiplying_Operator()
    {
        if(Globals.token.equals("MP_TIMES")){               //Rule 94
            match(Globals.token, "MP_TIMES");
        }else if(Globals.token.equals("MP_FLOAT_DIVIDE")){  //Rule 95
            match(Globals.token, "MP_FLOAT_DIVIDE");    
        }else if(Globals.token.equals("MP_DIV")){           //Rule 96
            match(Globals.token, "MP_DIV");
        }else if(Globals.token.equals("MP_MOD")){           //Rule 97
            match(Globals.token, "MP_MOD");
        }else if(Globals.token.equals("MP_AND")){           //Rule 98
            match(Globals.token, "MP_AND");
        }else{
            syntax_Error();
        }
    }
    public void factor()
    {
        if(Globals.token.equals("MP_INTEGER_LIT")){         //Rule 99
            Analyzer.generatePush(Integer.parseInt(Globals.lexeme));
            match(Globals.token, "MP_INTEGER_LIT");
        }else if(Globals.token.equals("MP_FLOAT_LIT")){     //Rule 100
            Analyzer.generatePushF(Float.parseFloat(Globals.lexeme));
            match(Globals.token, "MP_FLOAT_LIT");
        }else if(Globals.token.equals("MP_STRING_LIT")){    //Rule 101
            Analyzer.generatePushS(Globals.lexeme);
            match(Globals.token, "MP_STRING_LIT");
        }else if(Globals.token.equals("MP_TRUE")){          //Rule 102
            Analyzer.generateTrue();
            match(Globals.token, "MP_TRUE");
        }else if(Globals.token.equals("MP_FALSE")){         //Rule 103
            Analyzer.generateFalse();
            match(Globals.token, "MP_FALSE");  
        }else if(Globals.token.equals("MP_NOT")){           //Rule 104
            match(Globals.token, "MP_NOT");
        }else if(Globals.token.equals("MP_LPAREN")){        //Rule 105
            match(Globals.token, "MP_LPAREN");
            expression();
            match(Globals.token, "MP_RPAREN");
        }else if(Globals.token.equals ("MP_IDENTIFIER")){   //Rule 106
            Analyzer.generatePushIdent(st.lookupOffset(Globals.lexeme),st.lookupNestingLevel(Globals.lexeme));
            match(Globals.token, "MP_IDENTIFIER");
        }else if (Globals.token.equals ("MP_RPAREN")){
            //
                }
        else{
            syntax_Error();
                                        System.out.println("ERROR");

        }
    }
    public void program_Identifier()
    {
        if(Globals.token.equals("MP_IDENTIFIER")){          //Rule 107
            match(Globals.token, "MP_IDENTIFIER");
        }else{
            syntax_Error();
            
        }        
    }
    public void variable_Identifier()
    {
        if(Globals.token.equals("MP_IDENTIFIER")){          //Rule 108
            match(Globals.token, "MP_IDENTIFIER");
        }
        else if (Globals.token.equals("MP_RPAREN"))
        {
            //
        }
        else{
            syntax_Error();
        }
    }
    public void procedure_Identifier()
    {
        if(Globals.token.equals("MP_IDENTIFIER")){          //Rule 109
            match(Globals.token, "MP_IDENTIFIER");
        }else{
            syntax_Error();
        }
    }
    public void function_Identifier()
    {
        if(Globals.token.equals("MP_IDENTIFIER")){          //Rule 110
            match(Globals.token, "MP_IDENTIFIER");
        }else{
            syntax_Error();
        }
    }
    public void boolean_Expression()
    {
        expression();                                       //Rule 111
    }
    public void ordinal_Expression()
    {
        expression();                                       //Rule 112
    }
    public void identifier_List()
    {
        varList.add(Globals.lexeme);
        if(Globals.token.equals("MP_IDENTIFIER")){          //Rule 113
            match(Globals.token, "MP_IDENTIFIER");
            identifier_Tail();
        }else{
            syntax_Error();
        }
    }
    public void identifier_Tail()
    {
        if(Globals.token.equals("MP_COMMA")){               //Rule 114
            match(Globals.token, "MP_COMMA");
            varList.add(Globals.lexeme);
            if(Globals.token.equals("MP_IDENTIFIER")){
                match(Globals.token, "MP_IDENTIFIER");
            }else{
                syntax_Error();
            }
            identifier_Tail();
        }else if(Globals.token.equals("MP_COLON")){
            //Rule 115
            //epsilon
        }else{
            syntax_Error();
        }
    }
    public void EOF(){
        System.out.println("The input program parses!");
    }
    public void syntax_Error()
    {
        syntax_error = true;
        try{
        throw new SyntaxErrorException();
        }catch (SyntaxErrorException e){
            System.out.println("Syntax Error");
            System.out.println(Globals.token);
        }
    }
    public void match(String token, String realToken)
    {
        if(token.equals(realToken)){
            nextToken(tList, Globals.tokenCounter);
        }else{
            syntax_Error();
        }
    }
    public class SyntaxErrorException extends Exception {
        public SyntaxErrorException(){
        }
    }
}
