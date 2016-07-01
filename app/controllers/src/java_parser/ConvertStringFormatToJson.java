/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_parser;

import java.util.ArrayList;

/**
 *
 * @author sunday
 */
public class ConvertStringFormatToJson {
    
    protected String getDescriptionClass(ArrayList<RequiredClass> list) {
        String mWords = "{\"class\":[";
        
        for(int index = 0 ; index < list.size() ; ++index) {
            mWords += "{\"modifier\":" + "\""+ checkModifier(list.get(index).getModdifier() ) + "\"" + ",";
            mWords += "\"name\":"+ "\"" + list.get(index).getName() + "\"" + ",";
            mWords += "\"enclose\":"+ "\""  + list.get(index).getEnClose() + "\"" + ",";
            mWords += getDescriptionAttributeInClass(list, index)+",";
            mWords += getDescriptionMethodInClass(list, index)+"}";
            if(index != list.size()-1 ) {
                mWords += ",";
            }
        }
        mWords += "]}";
        return mWords;
    }

    private String getDescriptionAttributeInClass(ArrayList<RequiredClass> list , int i) {
        String words =  "\"attribute\":[";
        
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
    
    protected String getDescriptionAttribute(ArrayList<RequiredAttribute> list) {
         String words =  ",\"attribute\":[";
        
        for(int index = 0 ; index < list.size() ; ++index) {
            words += "{\"modifier\":"+ "\"" + checkModifier(list.get(index).getModifier())+ "\"" + ",";
            words += "\"datatype\":" + "\""+ list.get(index).getDataType() + "\"" + ",";
            words +="\"name\":"+ "\"" + list.get(index).getName()+ "\"" +"}";
            if( index != list.size()-1 ) {
                words += ",";
            }
        }
        words += "]";
        return words;
        
    }
     
    protected String getDescriptionMethod(ArrayList<RequiredMethod> list) {
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
    
//    private void printRequiredClassList() {
//        System.out.println("class");
//        for(int index = 0 ; index < mReuiredClassList.size() ; ++index) {
//            System.out.print("Modifier : " + checkModifier(mReuiredClassList.get(index).getModdifier()));
//            System.out.println(" , Name : "+ mReuiredClassList.get(index).getName());
//        }
//    }
//    
//    private void printRequiredMemberList() {
//        System.out.println("Member");
//        for(int index = 0 ; index < mRequiredMemberList.size() ; ++index) {
//            System.out.print("Modifier : " + checkModifier(mRequiredMemberList.get(index).getModifier()));
//            System.out.print(", DataType : " + mRequiredMemberList.get(index).getDataType());
//            System.out.println(" , Name : "+ mRequiredMemberList.get(index).getName());
//        }
//    }
//    
//    private void printRequiredMethodList() {
//        System.out.println("Method");
//        for(int index = 0 ; index < mRequiredMethodList.size() ; ++index) {
//            System.out.print("Modifier : " + mRequiredMethodList.get(index).getModifier());
//            System.out.print(" , ReturnType : " + mRequiredMethodList.get(index).getReturnType());
//            System.out.println(" , Name : "+ mRequiredMethodList.get(index).getName());
//            for(int i = 0 ; i < mRequiredMethodList.get(index).getParams().length  && mRequiredMethodList.get(index).getParams()[i] !=null ; ++i) {
//                System.out.print(" \t   DatatypeParms : " + mRequiredMethodList.get(index).getParams()[i].getDataType());
//                System.out.println(" , NameParams : " + mRequiredMethodList.get(index).getParams()[i].getName());
//            }
//            System.out.println();
//        }
//    }
     
    
}
