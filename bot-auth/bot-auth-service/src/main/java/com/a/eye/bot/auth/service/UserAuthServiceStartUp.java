package com.a.eye.bot.auth.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @Title: ServiceStartUp.java
 * @author: pengysh
 * @date 2016年8月8日 下午10:56:23
 * @Description:认证服务启动类
 */
@SpringBootApplication
public class UserAuthServiceStartUp {
	private static Logger logger = LogManager.getLogger(UserAuthServiceStartUp.class.getName());

	public static void main(String args[]) throws InterruptedException {
		logger.debug("应用启动开始");
		SpringApplication application = new SpringApplication(UserAuthServiceStartUp.class);
		application.setWebEnvironment(false);

		Set<Object> set = new HashSet<Object>();
		set.add("classpath:applicationContext-service.xml");
		application.setSources(set);
		application.run(args);
		logger.debug("应用启动结束");
		while (true) {
			Thread.sleep(1000 * 60 * 60);
		}
	}
}
