package parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.visitor.ModifierVisitorAdapter;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.io.*;
import java.util.List;



/**
 *
 * @author Pinyo Taeprasartsit
 */
public class JavaParserDemo {
    public static void main(String[] args) throws Exception {
        final String codePathStr = "Z:/zTemp/GenWordsOf3Powers.java";
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream(codePathStr);

        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // prints the resulting compilation unit to default system output
        //System.out.println(cu.toString());
        List<TypeDeclaration> types = cu.getTypes();
//        for(TypeDeclaration type : types)
//            System.out.println(type.getName() + " " + type.getModifiers());
        
        int modCode = types.get(0).getModifiers();
//        System.out.println(ModifierSet.isProtected(modCode));
//        System.out.println(ModifierSet.isPublic(modCode));
//        System.out.println(ModifierSet.isFinal(modCode));
        
        new MethodVisitor().visit(cu, null);
    }
    
    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes. 
     */
    private static class MethodVisitor extends VoidVisitorAdapter {

        @Override
        public void visit(MethodDeclaration n, Object arg) {
            // here you can access the attributes of the method.
            // this method will be called for all methods in this 
            // CompilationUnit, including inner class methods
            //System.out.println(currentClassName + ": " + n.getName());
            super.visit(n, arg);
        }
        
        static String currentClassName = null;
        
        @Override
        public void visit(ClassOrInterfaceDeclaration n, Object arg) {
            String previousClass = currentClassName;
            
            currentClassName = n.getName();
            System.out.println("Class = " + currentClassName);
            super.visit(n, arg);
            
            System.out.println("Leave Class " + currentClassName);
            currentClassName = previousClass; // Not a perfect solution, we actually need
                                   //  need a stack of class visit here.
            if(currentClassName != null)
                System.out.println("Current (from previous) = " + currentClassName);
            else
                System.out.println("Currently at the class top level");
        }
    }
}
