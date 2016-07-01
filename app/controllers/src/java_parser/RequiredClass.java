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
public class RequiredClass {
    
    public static void main(String []args) {
        
        System.out.println("555");
    }
    public RequiredClass() {
        
    }
    public RequiredClass(String modifier, String name, String enClose) {
        mModifier = modifier;
        mName = name;
        mEnClose = enClose;
    }
    
    public RequiredClass(String modifier, String name, ArrayList<RequiredAttribute> member, ArrayList<RequiredMethod> method) {
        mModifier = modifier;
        mName = name;
        mMember = member;
        mMethod = method;
    }
    
    public RequiredClass(String modifier, String name, String enClose, ArrayList<RequiredAttribute> member, ArrayList<RequiredMethod> method) {
        mModifier = modifier;
        mName = name;
        mEnClose = enClose;
        mMember = member;
        mMethod = method;
    }
    
    public String getModdifier() {
        return mModifier;
    }
    
    public String getName() {
        return mName;
    }
    public String getEnClose() {
        return mEnClose;
    }
    
    public ArrayList<RequiredAttribute> getAttribute() {
        return mMember;
    }
    
    public void setMember(ArrayList<RequiredAttribute> list) {
        mMember = list;
    }
    
    public ArrayList<RequiredMethod> getMethod() {
        return mMethod;
    }
    
    public void setMethod(ArrayList<RequiredMethod> list) {
        mMethod = list;
    }
    
    private String mModifier;
    private String mName;
    private String mEnClose;
    private ArrayList<RequiredAttribute> mMember;
    private ArrayList<RequiredMethod> mMethod;
}
