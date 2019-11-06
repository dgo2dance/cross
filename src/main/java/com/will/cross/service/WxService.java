package com.will.cross.service;

import java.util.Map;


import com.will.cross.util.HttpRequest;
import com.will.cross.util.RedisUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

/**
 * 
 * @author xiefengchang
 *
 */
@Service
public class WxService {

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private Environment environment;
	
	@SuppressWarnings("unchecked")
	public Map<String,Object>getWxSession(String wxCode){
		StringBuffer sb = new StringBuffer();
		sb.append("appid=").append(environment.getProperty("wx.appId"));
		sb.append("&secret=").append(environment.getProperty("wx.secret"));
		sb.append("&js_code=").append(wxCode);
		sb.append("&grant_type=").append(environment.getProperty("wx.grantType"));
		String res = HttpRequest.sendGet(environment.getProperty("wx.sessionHost"), sb.toString());
		if(res == null || "".equals(res)){
			return null;
		}
		return JSON.parseObject(res, Map.class);
	}
	
	public String create3rdSession(String wxOpenId, String wxSessionKey, Long expires){
		String thirdSessionKey = RandomStringUtils.randomAlphanumeric(64);
		StringBuffer sb = new StringBuffer();
		sb.append(wxSessionKey).append("#").append(wxOpenId);
		redisUtil.add(thirdSessionKey, expires, sb.toString());
		return thirdSessionKey;
	}
}
