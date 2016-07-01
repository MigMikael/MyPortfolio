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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/**
 *
 * @author sunday
 */
public class CheckAnnotation {
    
    public static void main(String[] agrs) throws FileNotFoundException, IOException {
        CheckAnnotation check  = new CheckAnnotation();
        check.readFile();
        check.saveJsonFile();
    }
    
    public CheckAnnotation() {
        mName = "";
        mRequiredClassList = new ArrayList<RequiredClass>();
        mRequiredAttributemberList = new ArrayList<RequiredAttribute>();
        mRequiredMethodList = new ArrayList<RequiredMethod>();
    }
//     
    public void saveJsonFile() {
       String words =  changeStringFormatToJson() ; 
      
       new WriteFile("/Users/manny/Documents/Work/ruby/CodeRoomDev/app/controllers/json_file.txt").writeFile(words);
       
    }

    private String changeStringFormatToJson() {
        ConvertStringFormatToJson format = new ConvertStringFormatToJson();
        String words = "" ;

        words += format.getDescriptionClass(mRequiredClassList);
//        words += format.getDescriptionAttribute(mRequiredAttributemberList);
//        words += format.getDescriptionMethod(mRequiredMethodList);
//        
        return words;
    }
    
    public void readFile() throws IOException {
        mBuffer = getBufferReaderFile("/Users/manny/Documents/Work/ruby/CodeRoomDev/app/controllers/test.java");
//        mBuffer = getBufferReaderFile("/Users/manny/NetBeansProjects/CodeRoomDev/src/test.java");
        checkLine();
    }
    
    private void checkLine() throws IOException {
        String line = mBuffer.readLine();
        while (line != null) {
            
            if (!isAnnotationLineRequirement(line)) {
                if(isPublicClass(line) && isEmptyName()) {
                   String words[] = processExtractClassName(line);
                   setModifierOfLine(words[0]);
                   setNameOfLine(words[1]);
                   mRequiredClassList.add(new RequiredClass(mModifier,mName,null,null));
                }
                line = mBuffer.readLine();
                continue;
            }

            line = mBuffer.readLine().replaceAll("//.*|/\\*((.|\\n)(?!=*/))+\\*/", "").trim();
            System.out.println(line);
            saveRequirement(line);
        }
        mRequiredClassList.set(0, new RequiredClass(mModifier,mName,mRequiredAttributemberList,mRequiredMethodList));
    }
    
    private BufferedReader getBufferReaderFile(String sourcePath) throws FileNotFoundException, IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(sourcePath));
        return buffer;
    }
   
    private void saveRequirement(String line) throws IOException {
        checkRequiredKind(line);
    }
    
    private void checkRequiredKind(String line) throws IOException {
        if (isClass(line)) {
           add(mRequiredClassList.get(mRequiredClassList.size()-1), line);
        } else if (isAttribute(line)) {
           mRequiredAttributemberList.add(addAttribute(line));
        }else {
           addMethod(mRequiredMethodList, line);
        }
    }
    
    private void add(RequiredClass previosClasses, String line) throws IOException {
        String[] words = processExtractClassName(line);
        line = mBuffer.readLine();
        
        RequiredClass classes;
        if (words.length >= 2){
            classes = new RequiredClass(words[0], words[1],previosClasses.getName());
        }else {
            classes = new RequiredClass("", words[0],previosClasses.getName());
        }
        ArrayList<RequiredAttribute> attribute = new ArrayList<RequiredAttribute>();
        ArrayList<RequiredMethod> method = new ArrayList<RequiredMethod>();
        
        while (!isLineHaveCloseBraces(line)) {
            if (!isAnnotationLineRequirement(line)) {
               line = mBuffer.readLine();
               continue;
            }
            
            line = mBuffer.readLine().replaceAll("//.*|/\\*((.|\\n)(?!=*/))+\\*/", "").trim();
            System.out.println(line);
            if (isClass(line)) {
                add(classes, line);
            } else if (isAttribute(line)) {
                attribute.add(addAttribute(line));
            }else {
                addMethod(method, line);
            }
        } 
         
        if (words.length >= 2){
            mRequiredClassList.add(new RequiredClass(words[0], words[1],previosClasses.getName(), attribute, method));
        }
        
         mRequiredClassList.add(new RequiredClass("", words[0],previosClasses.getName(), attribute, method));
    }
    
    private RequiredAttribute addAttribute(String line) {
        line = removeSymbol(line,"=|;|\\{|\\}|\"|\\(|\\)", "");
        String[] words = line.split(" ");
       
        return separaterAttributeNotHaveASymbol(words);
    }
    
    private void addMethod(ArrayList<RequiredMethod> listMethod, String line) {
        String[] words = line.split(" ");
        
        ParamsType[] paramsType = paramsSeparater(words);
       listMethod.add(new RequiredMethod(words[0], words[1] , words[2], paramsType));
    }
    
    private RequiredAttribute separaterAttributeNotHaveASymbol (String[] words) {
        if (words.length == 2) {
           return new RequiredAttribute("", words[0], words[1]);
        } 
        return new RequiredAttribute(words[0], words[1], words[2]);
       
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
               paramsType[count++] = new ParamsType(datatypeParam, nameParam); 
           }else if(isBracket == true){
               String datatypeParam = changLineToDataType(line[index++], 0);
               String nameParam  = changLineToNameParam(line[index]);
               paramsType[count++] = new ParamsType(datatypeParam, nameParam); 
           }
       }
       return paramsType;
    }
    
    private String[] processExtractClassName(String word) {
        word = word.replaceAll("\\p{Punct}", "");
        word = word.replaceAll("class", "");
        word = word.replaceAll("\\s+"," ").trim();
    
        return word.split(" ");
    }
    
    private String changLineToDataType(String line, int position) {
        return line.substring(position);
    }
    
    private String changLineToNameParam(String word) {
        int positionLastWord = checkLastWord(word);
        return word.substring(0,positionLastWord);
    }

    private String removeSymbol(String word, String regex, String wordRepalce) {
        return word.replaceAll(regex, wordRepalce);
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
        if(line != null){
            return isStringTarget(line.trim(),"@Required");
        }
        return false;
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
    
    private boolean isPublicClass(String line) {
        return isValidate(line,"public") && isValidate(line,"class") ;
    }
    
    private boolean isAttribute(String line) {
        return isValidate(line,"=") || !isValidate(line, "{");
    }
    
    private boolean isLineHaveOpenBraces(String line) {
        return isSymbol(line, '{');
    }
    
    private boolean isLineHaveCloseBraces(String line) {
        return isSymbol(line, '}');
    }
    
    private boolean isSymbol(String line ,char target) {
        for(int index = 0 ; line != null && index < line.length() ; index++ ) {
            if(line.charAt(index) == target) {
                return true;
            }
        }
        return false;
    } 
    
    private boolean isStringTarget(String line,String target) {
        for(int index  = 0 ; index < line.length() ; ++index){
            if (line.equals(target)) {
                return true;
            }
        }
        return false;
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
    
    private boolean isEmptyName() {
        return mName.equals("");
    }
    
    private void setNameOfLine(String word) {
        mName = word;
    }
    private void setModifierOfLine(String word) {
        mModifier = word;
    }
    private ArrayList<RequiredClass> mRequiredClassList;
    private ArrayList<RequiredAttribute> mRequiredAttributemberList;
    private ArrayList<RequiredMethod> mRequiredMethodList;
    private String mModifier;
    private String mName ;
    private BufferedReader mBuffer;
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