/**
 * 
 */
package com.osify.apps.common.util;

/**
 * @author pongsametrey.sok
 *
 */
public class ListValue {
    private String code;
    private String desc;
    
    public ListValue(String code, String desc) {
	this.code = code;
	this.desc = desc;
    }
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
}
