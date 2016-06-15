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
class RequiredMethod {
        
    public RequiredMethod(String modifier, String returnType, String name, ParamsType[] params) {
        mModifier = modifier;
        mReturnType = returnType;
        mName = name;
        mParams = params;
    }

    public String getModifier() {
        return mModifier;
    }

    public String getReturnType() {
        return mReturnType;
    }

    public String getName() {
        return mName;
    }

    public ParamsType[] getParams() {
        return mParams;
    }

    private String mModifier;
    private String mReturnType;
    private String mName;
    private ParamsType[] mParams;

}