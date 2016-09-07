package com.lvmama.lvfit.adapter.vst.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @author lutianyu
 * @date 2015年7月11日
 */
@Component
public class VSTLoggerHandler {
	private static final Logger logger = LoggerFactory.getLogger(VSTLoggerHandler.class);

	public void trace(String message) {
		try {
			if (logger.isTraceEnabled()) {
				logger.trace(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	public void debug(String message) {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	public void info(String message) {
		try {
			if (logger.isInfoEnabled()) {
				logger.info(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

	}

	public void warn(String message) {
		try {
			if (logger.isWarnEnabled()) {
				logger.warn(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	public void error(String message) {
		try {
			if (logger.isErrorEnabled()) {
				logger.error(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

	}
}
