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
public class RequiredClass {
    
    public RequiredClass(String modifier, String name ) {
        mModifier = modifier;
        mName = name;
    }
    
    public String getModdifier() {
        return mModifier;
    }
    
    public String getName() {
        return mName;
    }
    
    private String mModifier;
    private String mName;
}
