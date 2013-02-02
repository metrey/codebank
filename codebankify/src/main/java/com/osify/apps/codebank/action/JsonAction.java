/**
 * 
 */
package com.osify.apps.codebank.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.osify.apps.codebank.dao.CodeBankDAO;
import com.osify.apps.common.util.ListValue;

/**
 * @author pongsametrey.sok
 * 
 */
public class JsonAction extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = -6299655579383910629L;
    private Map<Integer, String> languageMap;
    private String language;

    /**
     * Get map category
     */
    public String execute() {
	languageMap = new HashMap<Integer, String>();

	try {
	    languageMap = CodeBankDAO.getMapCategory(null);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return ERROR;
	}
	
	return SUCCESS;
    }

    public String getJSON() {
	return execute();
    }

    /**
     * @return the languageMap
     */
    public Map<Integer, String> getLanguageMap() {
        return languageMap;
    }

    /**
     * @param languageMap the languageMap to set
     */
    public void setLanguageMap(Map<Integer, String> languageMap) {
        this.languageMap = languageMap;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }
}
