/**
 * 
 */
package com.osify.apps.codebank.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osify.apps.codebank.bean.PostBean;
import com.osify.apps.codebank.dao.CodeBankDAO;
import com.osify.apps.common.util.Loggify;

/**
 * @author sok.pongsametrey
 *
 */
public class PostCodeAction extends ActionSupport implements ModelDriven<PostBean> {

    /**
     * 
     */
    private static final long serialVersionUID = -7739611793371369071L;

    private PostBean postVo;
    private Integer postId;
    private List<PostBean> lstPost;
    private String message;
    private Loggify log = Loggify.getInstance(this.getClass());
    
    /**
     * 
     * @return
     */
    public String add() {
	String result = SUCCESS;
	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	this.postVo = new PostBean();
	if (!StringUtils.isEmpty(request.getParameter("postId"))) {
	    Integer postId = Integer.parseInt(request.getParameter("postId"));
	    try {
		lstPost = CodeBankDAO.getPost(postId);
		if (lstPost != null && lstPost.size() > 0) {		
		    this.postVo = lstPost.get(0);
		    System.out.println(this.postVo.getPostTitle());
		} else {
		    System.out.println("KKOKOK");
		}
	    } catch (SQLException e) {
		log.error("SQLException: " + e.getMessage());
		this.setMessage("Technical error while search for id: "
			+ postId);
		return ERROR;
	    } catch (Exception e) {
		log.error("Exception: " + e.getMessage());
		this.setMessage("Some error while search for id: " + postId);
		return ERROR;
	    }
	} else {
	    System.out.println("NONO");
	}
	
	return result;
    }
    
    /**
     * 
     * @return
     */
    public String delete() {
	String result = SUCCESS;
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	
	if (StringUtils.isEmpty(request.getParameter("postId"))) {
	    this.setMessage("No post selected to delete, please find a post");
	    return ERROR;
	}
	
	Integer postId = Integer.parseInt(request.getParameter("postId"));
	try {
	    if(CodeBankDAO.deletePost(postId)) {
		this.setMessage("Deleted post: " + postId);
	    }
	} catch (SQLException e) {
	    log.error("SQLException: " + e.getMessage());
	    this.setMessage("Technical error while deleting id: " + postId);
	    return ERROR;
	} catch (Exception e) {
	    log.error("Exception: " + e.getMessage());
	    this.setMessage("Some error while deleting id: " + postId);
	    return ERROR;
	}
	return result;
    }
    
    /**
     * 
     * @return
     */
    public String list() {
	String result = SUCCESS;
	try {
	    lstPost = CodeBankDAO.getPost(null);
	} catch (SQLException e) {
	    log.error("SQLException: " + e.getMessage());
	    return ERROR;
	} catch (Exception e) {
	    log.error("Exception: " + e.getMessage());
	    return ERROR;
	}
	return result;
    }
    
    /**
     * 
     * @param postId
     * @return
     */
    public String view() {
	String result = SUCCESS;
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	
	if (StringUtils.isEmpty(request.getParameter("postId"))) {
	    this.setMessage("No post selected to view, please find a post");
	    return ERROR;
	}
	
	Integer postId = Integer.parseInt(request.getParameter("postId"));
	try {
	    lstPost = CodeBankDAO.getPost(postId);
	    if (lstPost == null || lstPost.size() == 0) {
		this.setMessage("No post found with given id: " + postId);
		return ERROR;
	    }
	} catch (SQLException e) {
	    log.error("SQLException: " + e.getMessage());
	    this.setMessage("Technical error while search for id: " + postId);
	    return ERROR;
	} catch (Exception e) {
	    log.error("Exception: " + e.getMessage());
	    this.setMessage("Some error while search for id: " + postId);
	    return ERROR;
	}
	return result;
    }
    /**
     * 
     * @return
     */
    public String save() {
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	
	postVo = new PostBean();	
	postVo.setPostTitle(request.getParameter("inputTitle"));
	postVo.setPostDesc(request.getParameter("inputDescription"));
	postVo.setPostCode(request.getParameter("inputPost_hidden"));
	postVo.setCategoryId(Integer.parseInt(request.getParameter("inputCategory")));
	
	try {
	    CodeBankDAO.addPost(postVo);
	    this.setMessage("New code added: <a href='viewcode.action?postId=" + postVo.getPostId() +"'>" + postVo.getPostTitle() + "</a>");
	} catch (SQLException e) {
	    log.error("SQLException: " + e.getMessage());
	    this.setMessage("Technical error while saving a code");
	    return ERROR;
	} catch (Exception e) {
	    log.error("Exception: " + e.getMessage());
	    this.setMessage("Some error while saving a code");
	    return ERROR;
	}
	return SUCCESS;
    }
    
    /**
     * 
     * @return
     */
    public String viewCategories () {
	
	return SUCCESS;
    }
    
    /**
     * 
     * @return
     */
    public Boolean validation() {
	return true;
    }

    @Override
    public PostBean getModel() {
	return postVo;
    }

    /**
     * @return the postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * @return the lstPost
     */
    public List<PostBean> getLstPost() {
        return lstPost;
    }

    /**
     * @param lstPost the lstPost to set
     */
    public void setLstPost(List<PostBean> lstPost) {
        this.lstPost = lstPost;
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
     * @return the postVo
     */
    public PostBean getPostVo() {
        return postVo;
    }

    /**
     * @param postVo the postVo to set
     */
    public void setPostVo(PostBean postVo) {
        this.postVo = postVo;
    }
}
