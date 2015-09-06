package com.bx.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {

	// Spring搴旂敤涓婁笅鏂囩幆澧�
	private static ApplicationContext applicationContext;

	/**
	 * 瀹炵幇ApplicationContextAware鎺ュ彛鐨勫洖璋冩柟娉曪紝璁剧疆涓婁笅鏂囩幆澧�
	 * 
	 * @param applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 鑾峰彇瀵硅薄
	 * 
	 * @param name
	 * @return Object
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}
}
