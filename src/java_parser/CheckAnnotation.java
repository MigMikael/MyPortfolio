/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_parser;

import com.sun.xml.internal.ws.wsdl.writer.document.ParamType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sunday
 */
public class CheckAnnotation {
    
    public static void main(String[] agrs) throws FileNotFoundException, IOException {
        new CheckAnnotation().readFile();
        
    }
    
    public CheckAnnotation() {
        mRequiredClassList = new ArrayList<RequiredClass>();
        mRequiredMemberList = new ArrayList<RequiredMember>();
        mRequiredMethodList = new ArrayList<RequiredMethod>();
    }
     public CheckAnnotation(String str) {
        
    }
    
    private void readFile() throws IOException {
        BufferedReader buffer = getBufferReaderFile("/Users/manny/NetBeansProjects/CodeRoomDev/src/test.java");
        checkLine(buffer);
        printRequiredClassList();
        printRequiredMemberList();
        printRequiredMethodList();
    }
    
    private void checkLine(BufferedReader buffer) throws IOException {
        String line = buffer.readLine();
        
        while (line != null) {
            if (!isAnnotationLineRequirement(line)) {
                line = buffer.readLine();
                continue;
            }
            
            line = buffer.readLine().trim();
            saveRequirement(line);
        } 
    }
    
    private BufferedReader getBufferReaderFile(String sourcePath) throws FileNotFoundException, IOException {
       BufferedReader buffer = new BufferedReader(new FileReader(sourcePath));
       return buffer;
    }
   
    private void saveRequirement(String line) {
        checkRequiredKind(line);
    }
    
    private void checkRequiredKind(String line) {
        if (isClass(line)) {
            mRequiredClassList.add(separaterClass(line));
//            System.out.println("class");
        } else if (isMember(line)) {
            mRequiredMemberList.add(separaterMember(line));
//            System.out.println("member");
        }else {
            mRequiredMethodList.add(separaterMethod(line));
//            System.out.println("method");
//            String[] lineArray = line.split(" ");
//            ParamsType[] paramsType = paramsSeparater(lineArray);
//            RequiredMethod requireMethod = new RequiredMethod(lineArray[0], lineArray[1] , lineArray[2], paramsType);
        }
    }
    
    private RequiredClass separaterClass(String word) {
        String[] words = word.split(" ");

        if (words.length == 4){
            return new RequiredClass(words[0], words[2]);
        }
        
        return new RequiredClass("", words[1]);
    }
    
    private RequiredMember separaterMember(String word) {
        String[] words = word.split(" ");
        
        if (isSymbolEqual(words)) {
            return separaterMemberHaveASymbol(words);
        }
        return separaterMemberNotHaveASymbol(words);
    }
    
    private RequiredMethod separaterMethod(String word) {
        String[] words = word.split(" ");
        
        ParamsType[] paramsType = paramsSeparater(words);
        return new RequiredMethod(words[0], words[1] , words[2], paramsType);
    }
    
    private RequiredMember separaterMemberHaveASymbol (String[] words) {      
        if (words.length == 4) {
            return new RequiredMember("", words[0], words[1]);
        }
        return new RequiredMember(words[0], words[1], words[2]);
    }
    
    private RequiredMember separaterMemberNotHaveASymbol (String[] words) {
        if (words.length == 2) {
           return new RequiredMember("", words[0], words[1]);
        } 
        return new RequiredMember(words[0], words[1], words[2]);
       
    }
    
    private ParamsType[] paramsSeparater (String[] line) {
        ParamsType[] paramsType = new ParamsType[15];
        boolean isBracket = false;
        int count = 0;
        
        for(int index = 3 ; index < line.length  && !line[index].equals("{"); ++index) {
           if(isOpenBracket(line[index])) {
               isBracket = true;
               String datatypeParam = changLineToDataType(line[index++], 1);
               String nameParam = changLineToNameParam(line[index]);
               System.out.println(changLineToNameParam(line[index]));
               paramsType[count++] = new ParamsType(datatypeParam, nameParam); 
           }else if(isBracket == true){
               String datatypeParam = changLineToDataType(line[index++], 0);
               String nameParam  = changLineToNameParam(line[index]);
               System.out.println(changLineToNameParam(line[index]));
               paramsType[count++] = new ParamsType(datatypeParam, nameParam); 
           }
       }
       return paramsType;
    }
    
    private String changLineToDataType(String line, int position) {
        return line.substring(position);
    }
    
    private String changLineToNameParam(String word) {
        int positionLastWord = checkLastWord(word);
        return word.substring(0,positionLastWord);
    }
    
    private String checkModifier(String word) {
        if(word.equals("")) {
            return "default";
        }
        return word;
    }
    private int checkLastWord(String word) {
        for(int index = 0 ; index < word.length() ; ++index) {
            if(word.charAt(index) == ',' || word.charAt(index) == ')') {
                return index;
            }
        }
        return word.length();
    }
    
    private boolean isSymbolEqual (String[] words) {
         for(int index = 0 ; index < words.length ; ++index) {
            if (words[index].equals("=")) {
                return true;
            }
        }
         return false;
    }
    
    private boolean isAnnotationLineRequirement (String line) {
        return line.trim().equals("@Require");
    }
    
    private boolean isOpenBracket (String line) {
        for(int index = 0 ; index < line.length() ; ++index) {
            char word = line.charAt(index);
            if(word == '(') {
                return true;
            }
        }
        return false;
    }
    
    private boolean isClass (String line) {
        return isValidate(line,"class");
    }
    
    private boolean isMember(String line) {
        return isValidate(line,"=") || !isValidate(line, "{");
    }
    
    private boolean isValidate(String line, String target) {
        String[] words = line.split(" ");
        
        for(int index  = 0 ; index < words.length ; ++index){
            if (words[index].equals(target)) {
                return true;
            }
        }
        
        return false;
    }
    
    private void printRequiredClassList() {
        System.out.println("class");
        for(int index = 0 ; index < mRequiredClassList.size() ; ++index) {
            System.out.print("Modifier : " + checkModifier(mRequiredClassList.get(index).getModdifier()));
            System.out.println(" , Name : "+ mRequiredClassList.get(index).getName());
        }
    }
    
    private void printRequiredMemberList() {
        System.out.println("Member");
        for(int index = 0 ; index < mRequiredMemberList.size() ; ++index) {
            System.out.print("Modifier : " + checkModifier(mRequiredMemberList.get(index).getModifier()));
            System.out.print(", DataType : " + mRequiredMemberList.get(index).getDataType());
            System.out.println(" , Name : "+ mRequiredMemberList.get(index).getName());
        }
    }
    
    private void printRequiredMethodList() {
        System.out.println("Method");
        for(int index = 0 ; index < mRequiredMethodList.size() ; ++index) {
            System.out.print("Modifier : " + mRequiredMethodList.get(index).getModifier());
            System.out.print(", ReturnType : " + mRequiredMethodList.get(index).getReturnType());
            System.out.println(" , Name : "+ mRequiredMethodList.get(index).getName());
            for(int i = 0 ; i < mRequiredMethodList.get(index).getParams().length ; ++i) {
                System.out.print(" , DatatypeParms : " + mRequiredMethodList.get(index).getParams()[i].getDataType());
                System.out.print(" , NameParams : " + mRequiredMethodList.get(index).getParams()[i].getName());
            }
            System.out.println();
        }
    }
    
    private ArrayList<RequiredClass> mRequiredClassList;
    private ArrayList<RequiredMember> mRequiredMemberList;
    private ArrayList<RequiredMethod> mRequiredMethodList;
   
}
//private CheckAnnotation.ParamsType[] paramsSeparater(String[] line) {
//        CheckAnnotation.ParamsType[] paramsType = new CheckAnnotation.ParamsType[15];
//        boolean isBracket = false;
//        int count = 0;
//        
//        for(int index = 3 ; index < line.length ; ++index) {
//           if(isOpenBracket(line[index])) {
//               isBracket = true;
//               String param = changLineToParam(line[index++], 1);
//               String dataType = changLineToDataType(line[index]);
//               System.out.println(changLineToDataType(line[index]));
//               paramsType[count++] = new CheckAnnotation.ParamsType(param, dataType); 
//           }else if(isBracket == true){
//               String param = changLineToParam(line[index++], 0);
//               String dataType = changLineToDataType(line[index]);
//               System.out.println(changLineToDataType(line[index]));
//               paramsType[count++] = new CheckAnnotation.ParamsType(param, dataType); 
//           }
//       }
//       return paramsType;
//    }