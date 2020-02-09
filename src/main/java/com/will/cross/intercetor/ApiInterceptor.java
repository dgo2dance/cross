package com.will.cross.intercetor;

import com.google.common.collect.ImmutableMap;

import com.will.cross.configurer.Constants;
import com.will.cross.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 
 * @author xiefengchang
 *
 */
public class ApiInterceptor implements HandlerInterceptor {
	private static final Logger LOG = LoggerFactory.getLogger(ApiInterceptor.class);
	private static ImmutableMap<String,Integer> methodMap = ImmutableMap.of("GET", 1, "POST", 2, "PUT", 4, "DELETE", 8);
	
	@Autowired
	private RedisUtil redisUtil;

	
	@Autowired
	private ImmutableMap<String, String> errorCodeMap;
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception exp)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	private boolean checkSessionAvailable(String thirdKey) {
		// check if thirdKey exist in redis
		return (redisUtil.get(thirdKey)!=null);
	}

	/**
	 * 拦截器逻辑，用于做认证，用户在header中提供3rdsessionKey,相当于传统浏览器提供的cookie，然后这里去redis中查是否存在该3rdsessionKey,如不存在就拦截请求，否则放行
	 * @param request
	 * @param response
	 * @param arg2
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        PrintWriter out = null;
		if(Constants.TRUE.equals(System.getenv(Constants.DEBUGGING))){
		    return true;
		}

	//	String sessionId = request.getHeader("sessionId");

		String sessionId = request.getHeader("cookie");
		if(sessionId.indexOf("JSESSIONID")>-1) {
			sessionId=request.getHeader("Authorization");
		}

		boolean sessionValid = false;
		
		if("/sys/user/openapi".equals(request.getRequestURI())||"/sys/user/login".equals(request.getRequestURI())){
			// if it's login request, don't intercept with any thing
			return true;
		}else {
			if(StringUtils.isEmpty(sessionId)) {
				LOG.warn("Request intercepted due to empty sessionId");
                out = response.getWriter();
                out.append(getResStr("40002"));
                out.flush();
                out.close();
				return false;
			}
		    sessionValid = checkSessionAvailable(sessionId);
			if(!sessionValid){
                LOG.warn("Request intercepted due to invalid sessionId");
                out = response.getWriter();
                out.append(getResStr("40002"));
                out.flush();
                out.close();
            }
		    return sessionValid;
		}
	}
	
	private String getResStr(String errorCode){
		return "{\"Code\":" + errorCode + ",\"msg\":\"" + errorCodeMap.get(errorCode) + "\"}";
	}
	
}
