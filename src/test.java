
import com.mycomp.anno.Require;
import java_parser.JavaParserDemo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sunday
 */

public class test {
    
    @Require
    class A {
    
    }
    @Require
    public class B {
        
    }
    @Require
    public int x = 0;
    
    @Require
    private double man;
  
    @Require
    public String printV1 (String[] x, int y) {
        return "";
    }
    
    public void printV2 (int x){
        
    }
//    @Require
//    int variable_test = 0;
    
    public int printV3(){
        return 0;
    }
    public static void printValue(boolean boolean_does_method_exist ){
        System.out.println("does method exist : "+ boolean_does_method_exist);
    }
    public static void main(String[] args) throws Exception {
        String source_path = "/Users/manny/NetBeansProjects/CodeRoomDev/src/java_parser/JavaParserDemo.java";
        String string_method_name = "printV1";
        String string_method_type = "String";
        String string_method_paramType[] = {"String[]"};
        
        boolean boolean_does_method_exist = new JavaParserDemo(source_path).doesMethodExist( string_method_name,string_method_type, string_method_paramType);
        printValue(boolean_does_method_exist);
    }
}
