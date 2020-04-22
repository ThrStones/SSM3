package com.galaxy.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:db.properties")
public class BaseController {
	
	@Value("${mybatis.pageHelper.size}")
	int pageSize;
	
}
