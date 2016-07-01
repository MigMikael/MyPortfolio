/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_parser;

/**
 *
 * @author sunday
 */
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.TypeParameter;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.AnnotationMemberDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.MultiTypeParameter;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.MethodReferenceExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JavaParserDemo {
   
    private String mCurrentMethodName = null;
    private String mCurrentMethodDatatype = null;
    private String[] mParamTypes = null;
    private boolean mIsFindMethod = false;
    private CompilationUnit mCompilation_unit;
    
    public JavaParserDemo(String string_source_path) throws ParseException, IOException{
        intialize(string_source_path);
    }
    public void intialize(String string_source_path) throws FileNotFoundException, ParseException, IOException{
        // final String codePathStr = "/Users/manny/NetBeansProjects/Part2_ReadAndDisplay/src/Part2_ReadAndDisplay.java";
        // final String codePathStr = "C:\\Users\\Sunday\\Documents\\NetBeansProjects\\Project_Final\\src\\ProgramTest\\printV1.java";
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream(string_source_path);
        try {

            // parse the file
            mCompilation_unit = JavaParser.parse(in);
        } finally {
            in.close();
        }

        //prints the resulting compilation unit to default system output
        //System.out.println(cu.toString());
        List<TypeDeclaration> types = mCompilation_unit.getTypes();
        //for(TypeDeclaration type : types)
            //System.out.println(type.getName() + " " + type.getModifiers());

        int modCode = types.get(0).getModifiers();
        //System.out.println(ModifierSet.isProtected(modCode));
        //System.out.println(ModifierSet.isPublic(modCode));
        //System.out.println(ModifierSet.isFinal(modCode));
 
    }
    
    
       
    
    public boolean doesMethodExist(String string_method_name, String stirng_method_datatype, String[] string_array_param_type){
        this.mCurrentMethodName = string_method_name;
        this.mCurrentMethodDatatype = stirng_method_datatype;
        this.mParamTypes = string_array_param_type;
        
        new MethodVisitor().visit(mCompilation_unit, null);  
        
        return (mIsFindMethod ? true : false);
    }
    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    private class MethodVisitor extends VoidVisitorAdapter {
        
       
       
        
        @Override
        public void visit(MethodDeclaration n, Object arg) {
            
            // here you can access the attributes of the method.
            // this method will be called for all methods in this 
            // CompilationUnit, including inner class methods
           mIsFindMethod =  isEqualParamTypes(mParamTypes,mParamTypeVisitor,mIsFindMethod);
          
           if(mIsFindMethod == true){
               return ;
           }
           if(mCurrentMethodName.equals(n.getName()) && mCurrentMethodDatatype.equals( String.valueOf( n.getType() ) ) ){
                mIsFindMethod = true;
           }
           mParamTypeVisitor = new String[100];
           mTopArray = 0;
           super.visit(n, arg);
            //System.out.println("\tLeave Method  = " + currentMethod + " , Loop Existance = " + isLoopExistance() +" , Recursive = " + isRecursive());    
        }
        
        @Override
        public void visit(AnnotationDeclaration n, Object arg) {
            System.out.println("annotation_Declaration = " + n.getName());
            super.visit(n, arg); //To change body of generated methods, choose Tools | Templates.
        }
        
        @Override
        public void visit(AnnotationMemberDeclaration n, Object arg) {
            System.out.println("annotation_member = "+ n.getName());
            super.visit(n, arg); //To change body of generated methods, choose Tools | Templates.
        }
        
        
        @Override
        public void visit(Parameter n, Object arg) {
            mParamTypeVisitor[mTopArray++] = String.valueOf(n.getType());
            super.visit(n, arg); //To change body of generated methods, choose Tools | Templates.
        }
        
        
        private String mMethodNameVisitor = null ;
        private String[] mParamTypeVisitor  = new String[100];
        private boolean mIsMethodRecursive = false ;
        private boolean isLoopExist = false ;
        private int mTopArray = 0;
        
        private boolean isEqualParamTypes(String[] string_array_param_types_require, String[] string_array_param_types_visitor , boolean boolean_status_find_method){
            if(boolean_status_find_method == true){
                int count = 0; 
                for(int index = 0 ; index < string_array_param_types_require.length ; index++ ){
                    if(string_array_param_types_require[index].equals(string_array_param_types_visitor[index])){
                        count++;
                    }
                }
                if(count == string_array_param_types_require.length){
                    return true;
                }
            }
            return false;
        }
        private String changModifier(int number) {
            if (number == 0) {
                return "default";
            } else if (number == 1) {
                return "public";
            } else if (number == 2) {
                return "private";
            } else {
                return "protected";
            }
        }

        private String isRecursive() {
          if( mIsMethodRecursive == true){
                mIsMethodRecursive = false;
                return "Yes";
            }else {
                return "No";
    
            }
        }
        private String isLoopExistance() {
            if( isLoopExist == true){
                isLoopExist = false;
                return "Yes";
            }else {
                return "No";
    
            }
        }
        /* @Override
        public void visit(MethodCallExpr n, Object arg) {
            if(n.getName().equals(currentMethod)){
                statusRecursive = true;
            }
            super.visit(n, arg); //To change body of generated methods, choose Tools | Templates.
        }
        @Override
        public void visit(ForStmt n, Object arg) {
            statusLoopExistance = true;
            super.visit(n, arg); //To change body of generated methods, choose Tools | Templates.
        }


        @Override
        public void visit(FieldDeclaration n, Object arg) {
            System.out.print(currentClassName + " : Method : " + currentMethod + ": Type : " + n.getType() + " : ");
            super.visit(n, arg); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void visit(VariableDeclarationExpr n, Object arg) {
            System.out.print("\t\t Variable : DataType = " + n.getType() + " , ");
            super.visit(n, arg); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void visit(VariableDeclarator n, Object arg) {
            System.out.println(" Name = " + n.getId() + " , Value =  " + n.getInit());
            super.visit(n, arg); //To change body of generated methods, choose Tools | Templates.
        }
        @Override
        public void visit(ClassOrInterfaceDeclaration n, Object arg) {
            String previousClass = currentClassName;
            
            currentClassName = n.getName();
             if(previousClass != null){
                System.out.println("Inner Class = " + currentClassName +" : Extends : " + n.getExtends() );
            }else {
                System.out.println("Class = " + currentClassName +" : Extends : " + n.getExtends() );
            }
            //System.out.println("Class = " + currentClassName +" : Extends : " + n.getExtends() );
            super.visit(n, arg);

            System.out.println("Leave Class " + currentClassName);
            currentClassName = previousClass; // Not a perfect solution, we actually need
            //  need a stack of class visit here.
            if (currentClassName != null) {
                System.out.println("Current (from previous) = " + currentClassName);
            } else {
                System.out.println("Currently at the class top level");
            }
        }
        */
        
    }
}
