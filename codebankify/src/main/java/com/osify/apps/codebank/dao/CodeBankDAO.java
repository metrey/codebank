/**
 * 
 */
package com.osify.apps.codebank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.osify.apps.codebank.bean.CategoryBean;
import com.osify.apps.codebank.bean.FortuneBean;
import com.osify.apps.codebank.bean.PostBean;
import com.osify.apps.common.dao.AbstractDAO;
import com.osify.apps.common.util.Loggify;

/**
 * DAO Helper in Singleton
 * @author pongsametrey.sok
 *
 */
public class CodeBankDAO extends AbstractDAO {

    private static Loggify log = Loggify.getInstance(CodeBankDAO.class);
    private static CodeBankDAO instance = null;
    
    /** No access by instance */
    private CodeBankDAO() {}
    
    /**
     * 
     * @return
     */
    public static CodeBankDAO getInstance() {
	if (instance == null) {
	    instance = new CodeBankDAO();
	}
	return instance;
    }
    /**
     * 
     * @param postVO
     * @return
     * @throws SQLException
     */
    public static Boolean addPost(PostBean postVO) throws SQLException {	
	String sql = "INSERT INTO post (title, description, post, user_id, category_id) VALUES (?, ?, ?, ?, ?)";
	
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Integer postId = null;
	try {
	    pstmt = CodeBankDAO.getInstance().getConnection().prepareStatement(sql);
	    pstmt.setString(1, postVO.getPostTitle());
	    pstmt.setString(2, postVO.getPostDesc());
	    pstmt.setString(3, postVO.getPostCode());
	    pstmt.setInt(4, 1);
	    pstmt.setInt(5, postVO.getCategoryId());
	    pstmt.executeUpdate();
	    rs = pstmt.getGeneratedKeys();
	    if (rs != null && rs.next()) {
		postId = rs.getInt(1);
		postVO.setPostId(postId);
		log.debug("> Save Code Post ID: " + postId);
	    }
	} catch (SQLException e) {
	    log.error("SQLException error: " + e.getMessage());
	    throw e;
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    CodeBankDAO.getInstance().close();
	}
	
	return Boolean.TRUE;
    }
    
    /**
     * 
     * @param postVO
     * @return
     * @throws SQLException
     */
    public static Boolean updatePost(PostBean postVO) throws SQLException {
	String sql = "UPDATE post SET title=?, description=?, post=?, category_id=? WHERE post_id=?";
	
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	try {
	    pstmt = CodeBankDAO.getInstance().getConnection().prepareStatement(sql);
	    pstmt.setString(1, postVO.getPostTitle());
	    pstmt.setString(2, postVO.getPostDesc());
	    pstmt.setString(3, postVO.getPostCode());
	    pstmt.setInt(4, postVO.getCategoryId());
	    pstmt.setInt(5, postVO.getPostId());
	    pstmt.executeUpdate();	    
	} catch (SQLException e) {
	    log.error("SQLException error: " + e.getMessage());
	    throw e;
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    CodeBankDAO.getInstance().close();
	}
	
	return Boolean.TRUE;
    }
    /**
     * 
     * 
     * @param postId
     * @return
     * @throws SQLException
     */
    public static Boolean deletePost(Integer postId) throws SQLException {
	String sql = "DELETE FROM post WHERE post_id=?";
	
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	try {
	    pstmt = CodeBankDAO.getInstance().getConnection().prepareStatement(sql);
	    pstmt.setInt(1, postId);
	    pstmt.executeUpdate();	    
	} catch (SQLException e) {
	    log.error("SQLException error: " + e.getMessage());
	    throw e;
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    CodeBankDAO.getInstance().close();
	}
	
	return Boolean.TRUE;
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public static List<PostBean> getPost(Integer postId) throws SQLException {
	List<PostBean> lstPost = new ArrayList<PostBean>();
	String sql = "SELECT * FROM post";
	if (postId != null) {
	    sql = sql + " WHERE post_id = " + postId.intValue();	    
	}
	sql = sql + " ORDER BY dt_cre DESC ";
	ResultSet rs = null;
	
	try {
	    rs = CodeBankDAO.getInstance().getStatement().executeQuery(sql);
	    while(rs.next()) {
		PostBean postVo = new PostBean();
		postVo.setPostId(rs.getInt("post_id"));
		postVo.setPostTitle(rs.getString("title"));
		postVo.setPostCode(rs.getString("post"));
		postVo.setPostDesc(rs.getString("description"));
		postVo.setCategoryId(rs.getInt("category_id"));
		lstPost.add(postVo);
	    }
	} catch (SQLException e) {
	    log.error("SQLException error: " + e.getMessage());
	    throw e;
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    CodeBankDAO.getInstance().close();
	}
	return lstPost;
	
    }
    
    /**
     * 
     * @param categoryId
     * @return
     * @throws SQLException
     */
    public static List<CategoryBean> getCategory(Integer categoryId) throws SQLException {
	List<CategoryBean> lstCategory = new ArrayList<CategoryBean>();
	Map<Integer, String> mapCategory = new Hashtable<Integer, String>();
	ResultSet rs = null;
	String sql = "SELECT * FROM category";
	if (categoryId != null) {
	    sql = sql + " WHERE category_id = " + categoryId.intValue();
	}
	try {
	    rs = CodeBankDAO.getInstance().getStatement().executeQuery(sql);
	    while(rs.next()) {
		CategoryBean categoryVo = new CategoryBean();
		categoryVo.setCategoryId(rs.getInt("category_id"));
		categoryVo.setCategory(rs.getString("category"));
		categoryVo.setDescription(rs.getString("desc"));
		lstCategory.add(categoryVo);
		mapCategory.put(rs.getInt("category_id"), rs.getString("category"));
	    }
	} catch (SQLException e) {
	    log.error("SQLException error: " + e.getMessage());
	    throw e;
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    
	    CodeBankDAO.getInstance().close();
	}
	return lstCategory;
    }
    
    /**
     * 
     * @param categoryId
     * @return
     * @throws SQLException
     */
    public static Map<Integer, String> getMapCategory(Integer categoryId) throws SQLException {
	Map<Integer, String> mapCategory = new Hashtable<Integer, String>();
	ResultSet rs = null;
	String sql = "SELECT * FROM category";
	if (categoryId != null) {
	    sql = sql + " WHERE category_id = " + categoryId.intValue();
	}
	try {
	    rs = CodeBankDAO.getInstance().getStatement().executeQuery(sql);
	    while(rs.next()) {
		mapCategory.put(rs.getInt("category_id"), rs.getString("category"));
	    }
	} catch (SQLException e) {
	    log.error("SQLException error: " + e.getMessage());
	    throw e;
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    
	    CodeBankDAO.getInstance().close();
	}
	
	return mapCategory;
    }

    /**
     * 
     * @param fortuneNumber
     * @param fortuneType
     * @return
     * @throws SQLException
     */
    public static FortuneBean getFortune(Integer fortuneNumber, Integer fortuneType) throws SQLException {
	FortuneBean fortuneVo = null;
	String sql = "SELECT * FROM fortune WHERE type = ? AND [number] = ?";
	
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	try {
	    pstmt = CodeBankDAO.getInstance().getConnection().prepareStatement(sql);
	    pstmt.setInt(1, fortuneType);
	    pstmt.setInt(2, fortuneNumber);
	    rs = pstmt.executeQuery();
	    if (rs != null && rs.next()) {
		fortuneVo = new FortuneBean();
		fortuneVo.setFortuneId(rs.getInt("fortune_id"));
		fortuneVo.setType(rs.getInt("type"));
		fortuneVo.setFortuneNumber(rs.getInt("number"));
		fortuneVo.setDescription(rs.getString("description"));
		fortuneVo.setDescriptionEn(rs.getString("description_en"));
	    }
	} catch (SQLException e) {
	    log.error("SQLException error: " + e.getMessage());
	    throw e;
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    CodeBankDAO.getInstance().close();
	}
	
	return fortuneVo;
    }
}
