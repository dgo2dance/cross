package com.will.cross.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.will.cross.model.SchedulePersonOrgRelate;
import com.will.cross.model.SysOffice;
import com.will.cross.service.SchedulePersonOrgRelateService;
import com.will.cross.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Controller 基类
 *
 * @author will
 * @version 1.0 2016年12月16日
 * @since 1.0
 */
public abstract class BaseController {

	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private RedisUtil redisUtil;

	@Resource
	private SchedulePersonOrgRelateService schedulePersonOrgRelateService;
	/**
	 * 根据thirdsession获取masterid
	 */
	protected  String getMasterId(HttpServletRequest request){

		String masterId="";
		HttpSession session = request.getSession();
		String sid = request.getHeader("Authorization");
		if(sid.indexOf("JSESSIONID")>-1) {
			sid=request.getHeader("Authorization");
		}
		String openId = (String) redisUtil.get(sid.toString()).toString();
		openId=openId.substring(0,openId.indexOf("#"));

		//查询当前激活组织ID; 租户ID;
		Condition query=new Condition(SchedulePersonOrgRelate.class);
		query.createCriteria().andEqualTo("personId",openId).andEqualTo("status","0");

		List<SchedulePersonOrgRelate> schedulePersonOrgRelate= schedulePersonOrgRelateService.findByCondition(query);

		if(schedulePersonOrgRelate.size()>0){
			masterId = schedulePersonOrgRelate.get(0).getOrgId();
		}

	//	return (UserVO) session.getAttribute(SessionConstUtil.SESSION_USER_KEY);
		return masterId;
	}



	protected  String getUserId(HttpServletRequest request){


		HttpSession session = request.getSession();
		String sid = request.getHeader("Authorization");
		if(sid.indexOf("JSESSIONID")>-1) {
			sid=request.getHeader("Authorization");
		}
		String userId = (String) redisUtil.get(sid.toString()).toString();
		userId=userId.substring(0,userId.indexOf("#"));

		return userId;
	}


	/**
	 * 根据thirdsession获取openid
	 */
	protected  String getOpenId(HttpServletRequest request){

		HttpSession session = request.getSession();
		String sid = request.getHeader("cookie");
		String openId = (String) redisUtil.get(sid.toString()).toString();
		openId=openId.substring(openId.indexOf("#")+1);

		return openId;
	}


	/**
	 * 得到session用户信息
	 * 
	 * @author taojiagui(云启)
	 * @time 下午5:39:43
	 * @param request
	 * @return
	 */
//	protected UserVO getUser(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		return (UserVO) session.getAttribute(SessionConstUtil.SESSION_USER_KEY);
//	}

	/**
	 * 得到session用户信息
	 * 
	 * @author taojiagui(云启)
	 * @time 下午5:15:15
	 * @return
	 */
	protected String getMasterId() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return getMasterId(request);
	}

	protected String getOpenId() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return getOpenId(request);
	}


	protected String getUserId() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return getUserId(request);
	}
	/**
	 * 得到当前会话用户ID
	 * 
	 * @author taojiagui(云启)
	 * @time 下午5:22:03
	 * @param request
	 * @return
	 */
//	protected String getUserId(HttpServletRequest request) {
//		return getUser(request).getUserId();
//	}

	/**
	 * 得到当前会话用户ID
	 * 
	 * @author taojiagui(云启)
	 * @time 下午5:22:03
	 * @param request
	 * @return
	 */
//	protected String getUserId() {
//		return getUser().getUserId();
//	}

	/**
	 * session设置
	 * 
	 * @author taojiagui(云启)
	 * @time 下午4:29:28
	 * @param request
	 * @param sessUser
//	 */
//	protected void setSession(HttpServletRequest request, UserVO sessUser) {
//		HttpSession session = request.getSession();
//		String sessionId = session.getId();
//		logger.debug(sessionId);
//		if (sessUser != null) {
//			session.setAttribute(SessionConstUtil.SESSION_USER_KEY, sessUser);
//		}
//	}

	/**
	 * 清除session
	 * 
	 * @author will
	 * @time 上午11:35:37
	 * @param request
//	 */
//	protected void removeSession(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.removeAttribute(SessionConstUtil.SESSION_USER_KEY);
//	}

	/**
	 * 返回HttpServletRequest
	 * 
	 * @author taojiagui(云启)
	 * @time 下午7:40:36
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取域名
	 * 
	 * @author will
	 * @time 下午5:02:01
	 * @return
	 */
	protected String getHostName() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获取域名
		StringBuffer url = request.getRequestURL();
		String hostName = url.delete(url.length() - request.getRequestURI().length(), url.length())
				.append(request.getServletContext().getContextPath()).toString();
		return hostName;
	}

	/**
	 * 获取 https 域名
	 * 
	 * @author will
	 * @time 下午5:02:26
	 * @return
	 */
	protected String getHttpsHost() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获取域名
		StringBuffer url = request.getRequestURL();
		String hostName = url.delete(url.length() - request.getRequestURI().length(), url.length())
				.append(request.getServletContext().getContextPath()).toString();

		if (hostName.startsWith("http://")) {
			return hostName.replaceFirst("http://", "https://");
		}
		return hostName;
	}

}
