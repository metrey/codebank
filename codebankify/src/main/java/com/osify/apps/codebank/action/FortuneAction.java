/**
 * 
 */
package com.osify.apps.codebank.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osify.apps.codebank.bean.FortuneBean;
import com.osify.apps.codebank.dao.CodeBankDAO;
import com.osify.apps.common.util.Loggify;

/**
 * @author pongsametrey.sok
 *
 */
public class FortuneAction extends ActionSupport implements ModelDriven<FortuneBean> {

    private FortuneBean fortuneVO;
    private String message;
    private Loggify log = Loggify.getInstance(this.getClass());
    /**
     * 
     */
    private static final long serialVersionUID = 7265988358499326910L;

    /**
     * Display form startup
     * @return
     */
    public String displayForm () {
	return SUCCESS;
    }
    
    /**
     * 
     * @return
     */
    public String phoneNumber() {
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	
	if (StringUtils.isEmpty(request.getParameter("inputFortunePhone"))) {
	    this.setMessage("No post selected to view, please find a post");
	    return ERROR;
	}
	String original = request.getParameter("inputFortunePhone");
	// rule1 = number / 80
	double number = Double.parseDouble(original) / 80;
	double decimal = number % 1d;
	// rule2 = rule1 decimal * 80
	Double fortuneNumber = decimal * 80;
	
	try {
	    fortuneVO = CodeBankDAO.getFortune(fortuneNumber.intValue(), 1);
	    fortuneVO.setInputFortune(String.valueOf(original));
	} catch (SQLException e) {
	    log.error("SQLException: " + e.getMessage());
	    this.setMessage("Technical error while search fortune: " + original);
	    return ERROR;
	} catch (Exception e) {
	    log.error("Exception: " + e.getMessage());
	    this.setMessage("Some error while search fortune: " + original);
	    return ERROR;
	}
	
	return SUCCESS;
    }
    
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }


    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * @return the fortuneVO
     */
    public FortuneBean getFortuneVO() {
        return fortuneVO;
    }

    /**
     * @param fortuneVO the fortuneVO to set
     */
    public void setFortuneVO(FortuneBean fortuneVO) {
        this.fortuneVO = fortuneVO;
    }




    @Override
    public FortuneBean getModel() {
	return fortuneVO;
    }

}
