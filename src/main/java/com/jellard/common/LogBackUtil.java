package com.jellard.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackUtil {
	private static Logger logger = LoggerFactory.getLogger(LogBackUtil.class);
	
	
	public static void main(String[] args) {
		logger.debug("test debug model");
		logger.error("test error model");
	}

}
