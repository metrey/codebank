/**
 * 
 */
package com.osify.apps.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLite;

import com.osify.apps.common.util.Loggify;

/**
 * Abstract DAO To manage connection, create database, tables Using SQLite JDBC
 * 
 * @author sok.pongsametrey
 * @version 1.0
 */
public abstract class AbstractDAO {
    private Connection connection = null;
    private Statement statement = null;
    public String dbName = "codebank.s3db";
    private Loggify log = Loggify.getInstance(AbstractDAO.class);
    /**
     * 
     * @throws SQLException
     */
    private void createDbConnection() throws SQLException {
	//ClassLoader loader = AbstractDAO.class.getClassLoader();
	//String dbPath = loader.getSystemResource(dbName).getPath();
	//log.debug(dbPath);
	
	try {	    
	    Class.forName("org.sqlite.JDBC");
	    connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
	    
	    statement = connection.createStatement();
	    statement.setQueryTimeout(30); // set timeout to 30 sec.
	    String sql = "pragma encoding=\"UTF-8\"";
	    statement.execute(sql);
	} catch (SQLException e) {
	    log.error("ERROR: Could not connect to db: " + dbName);
	    throw e;
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    throw new SQLException("No driver: " + e.getMessage());
	}
	log.debug("Connecting to DB: " + dbName + " via "
		+ connection.toString());
    }
    

    /**
     * Load and create db
     * 
     * @throws SQLException
     */
    //public abstract void createDBModel() throws SQLException;

    /**
     * @return the connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
	if (this.connection == null) {
	    this.createDbConnection();
	}
	return connection;
    }

    /**
     * @return the statement
     * @throws SQLException
     */
    public Statement getStatement() throws SQLException {
	if (this.statement == null) {
	    this.createDbConnection();
	}
	return statement;
    }
    /**
     * 
     * @param stm
     * @param sql
     * @return
     * @throws SQLException 
     */
    public boolean executeUpdate(String sql) throws SQLException {
	try {
	    this.statement.execute(sql);
	    return true;
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    /**
	 * 
	 */
    public void close() {
	try {
	    if (this.statement != null) {
		this.statement.close();
		this.statement = null;
	    }
	    if (this.connection != null) {
		this.connection.close();
		this.connection = null;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    System.out.println("DB Connection closed.");
	}

    }

}
