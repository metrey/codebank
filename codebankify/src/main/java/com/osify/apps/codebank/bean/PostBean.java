/**
 * 
 */
package com.osify.apps.codebank.bean;

/**
 * @author pongsametrey.sok
 *
 */
public class PostBean {
    private Integer postId;
    private String postTitle;
    private String postDesc;
    private String postCode;
    
    private Integer userId;
    private Integer categoryId;
    
    private Integer rateNo;

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
     * @return the postTitle
     */
    public String getPostTitle() {
        return postTitle;
    }

    /**
     * @param postTitle the postTitle to set
     */
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    /**
     * @return the postDesc
     */
    public String getPostDesc() {
        return postDesc;
    }

    /**
     * @param postDesc the postDesc to set
     */
    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    /**
     * @return the postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the rateNo
     */
    public Integer getRateNo() {
        return rateNo;
    }

    /**
     * @param rateNo the rateNo to set
     */
    public void setRateNo(Integer rateNo) {
        this.rateNo = rateNo;
    }
}
