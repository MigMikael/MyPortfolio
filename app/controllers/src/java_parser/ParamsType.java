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
class ParamsType {
        
    public ParamsType(String dataType, String name) {
        mDataType = dataType;
        mName = name;
    }

    public String getDataType() {
        return mDataType;
    }

    public String getName() {
        return mName;
    }
    private String mDataType;
    private String mName;
}

