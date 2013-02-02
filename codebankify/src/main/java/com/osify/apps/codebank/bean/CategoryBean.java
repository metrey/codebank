/**
 * 
 */
package com.osify.apps.codebank.bean;

/**
 * @author pongsametrey.sok
 *
 */
public class CategoryBean {
    private Integer categoryId;
    private String category;
    private String description;
    private Integer parentCategoryId;
    private Boolean isInactive;
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
     * @return the category
     */
    public String getCategory() {
        return category;
    }
    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the parentCategoryId
     */
    public Integer getParentCategoryId() {
        return parentCategoryId;
    }
    /**
     * @param parentCategoryId the parentCategoryId to set
     */
    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
    /**
     * @return the isInactive
     */
    public Boolean getIsInactive() {
        return isInactive;
    }
    /**
     * @param isInactive the isInactive to set
     */
    public void setIsInactive(Boolean isInactive) {
        this.isInactive = isInactive;
    }
    
    
}
