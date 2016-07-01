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
public class RequiredAttribute {
    
    public RequiredAttribute(String modifier, String dataType, String name) {
        mModifier = modifier;
        mDataType = dataType;
        mName = name;
    }
    
    public RequiredAttribute(RequiredAttribute member) {
        mModifier = member.mModifier;
        mDataType = member.mDataType;
        mName = member.mName;
    }
    
    public String getModifier() {
        return mModifier;
    }
    public String getDataType() {
        return mDataType;
    }
    
    public String getName() {
        return mName;
    }
    
    private String mModifier;
    private String mDataType;
    private String mName ;
}
