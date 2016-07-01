
package java_parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class WriteFile {
    
    String mPath ;
    String mWords;        
    public WriteFile(String path) {
       mPath = path ;
       mWords = "";
       
    }
    public void writeFile(String words) {
        BufferedWriter writer = null ;
        
        try {
            //create a temporary file
            File logFile = new File(mPath) ;

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath()) ;

            writer = new BufferedWriter(new FileWriter(logFile)) ;
            writer.write(words) ;
        } catch (Exception e) {
            e.printStackTrace() ;
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close() ;
            } catch (Exception e) {
                
            }
        }
    }
    private String getDescriptionClass(ArrayList<RequiredClass> list) {
        String mWords = "{\"class\":[";
        
        for(int index = 0 ; index < list.size() ; ++index) {
            mWords += "{\"modifier\":" + "\""+ checkModifier(list.get(index).getModdifier() ) + "\"" + ",";
            mWords += "\"name\":"+ "\"" + list.get(index).getName() + "\"" + ",";
            mWords += getDescriptionMemberInClass(list, index)+",";
            mWords += getDescriptionMethodInClass(list, index)+"}";
            if(index != list.size()-1 ) {
                mWords += ",";
            }
        }
        mWords += "]";
        return mWords;
    }
    private String getDescriptionMemberInClass(ArrayList<RequiredClass> list , int i) {
        String words =  "\"member\":[";
        
        for(int index = 0 ; index < list.get(i).getAttribute().size() ; ++index) {
            words += " {\"modifier\":"+ "\"" + checkModifier(list.get(i).getAttribute().get(index).getModifier())+ "\"" + ",";
            words += "\"datatype\":" + "\""+ list.get(i).getAttribute().get(index).getDataType() + "\"" + ",";
            words +="\"name\":"+ "\"" + list.get(i).getAttribute().get(index).getName()+ "\"" +"}";
            if( index != list.get(i).getAttribute().size()-1 ) {
                words += ",";
            }
        }
        words += "]";
        return words;
    }
    
     private String getDescriptionMethodInClass(ArrayList<RequiredClass> list, int i) {
       String words = "\"method\":[";
        for(int index = 0 ; index < list.get(i).getMethod().size() ; ++index) {
            boolean status = false;
            words += "{\"modifier\":" + "\"" + list.get(i).getMethod().get(index).getModifier()+ "\"," ;
            words += "\"returnType\":"+ "\""  + list.get(i).getMethod().get(index).getReturnType()+ "\"," ;
            words += "\"name\":"+ "\"" + list.get(i).getMethod().get(index).getName()+ "\"" +",";
            words += "\"params\":[";
            for(int index_arr = 0 ; index_arr <  list.get(i).getMethod().get(index).getParams().length  && list.get(i).getMethod().get(index).getParams()[index_arr] !=null ; ++index_arr) {
                if( status == true ){
                     words += ",";
                }
                words += "{\"datatype_parms\":"+ "\""+ list.get(i).getMethod().get(index).getParams()[index_arr].getDataType()+ "\"" +",";
                words += "\"name_params\":"+ "\"" +list.get(i).getMethod().get(index).getParams()[index_arr].getName()+ "\"" + "}";
                status = true;
            }
            words += "]}";
            
            if( index !=  list.get(i).getMethod().size()-1 ) {
                words += ",";
            }
        }
        words += "]";

        return words;
    }
    
     private String getDescriptionMember(ArrayList<RequiredAttribute> list) {
         String words =  ",\"member\":[";
        
        for(int index = 0 ; index < list.size() ; ++index) {
            words += " {\"modifier\":"+ "\"" + checkModifier(list.get(index).getModifier())+ "\"" + ",";
            words += "\"datatype\":" + "\""+ list.get(index).getDataType() + "\"" + ",";
            words +="\"name\":"+ "\"" + list.get(index).getName()+ "\"" +"}";
            if( index != list.size()-1 ) {
                words += ",";
            }
        }
        words += "]";
        return words;
        
    }
     
    private String getDescriptionMethod(ArrayList<RequiredMethod> list) {
        String words = ",\"method\":[";
        for(int index = 0 ; index < list.size() ; ++index) {
            boolean status = false;
            words += "{\"modifier\":" + "\"" + list.get(index).getModifier()+ "\"," ;
            words += "\"returnType\":"+ "\""  + list.get(index).getReturnType()+ "\"," ;
            words += "\"name\":"+ "\"" + list.get(index).getName()+ "\"" +",";
            words += "\"params\":[";
            for(int index_arr = 0 ; index_arr <  list.get(index).getParams().length  && list.get(index).getParams()[index_arr] !=null ; ++index_arr) {
                if( status == true ){
                     words += ",";
                }
                words += "{\"datatype_parms\":"+ "\""+ list.get(index).getParams()[index_arr].getDataType()+ "\"" +",";
                words += "\"name_params\":"+ "\"" +list.get(index).getParams()[index_arr].getName()+ "\"" + "}";
                status = true;
            }
            words += "]}";
            
            if( index != list.size()-1 ) {
                words += ",";
            }
        }
        words += "]";
        words += "}";
        return words;
    }
    
     private String checkModifier(String word) {
        if(word.equals("")) {
            return "default";
        }
        return word;
    }
}