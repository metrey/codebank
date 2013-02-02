/**
 * 
 */
package com.osify.apps.common.util;

import org.apache.log4j.Logger;


/**
 * Singleton for logging 
 * @author pongsametrey.sok
 *
 */
public class Loggify {
private static Loggify instance;
    
    private Logger logger = null;
    
    private Loggify () {}
    
    /**
     * 
     * @param c
     * @return
     */
    public static Loggify getInstance(Class c) {
	if (instance == null) {
	    instance = new Loggify();
	    instance.initLogger(c);
	}
	
	return instance;
    }
    /**
     * 
     * @param c
     */
    private void initLogger (Class<?> c) {
	logger = Logger.getLogger(c.getName());
    }
    /**
     * 
     * @param message
     */
    public void debug(String message) {
	logger.debug(message);
    }

    /**
     * 
     * @param message
     */
    public void info(String message) {
	logger.info(message);
    }
    /**
     * 
     * @param message
     */
    public void error(String message) {
	logger.error(message);
    }

    /**
     * 
     * @param message
     */
    public void warn(String message) {
	logger.warn(message);
    }

}
