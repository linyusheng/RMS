package com.lys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.entity.User;
import com.lys.model.DataGrid;
import com.lys.model.Json;
import com.lys.model.MUser;
import com.lys.model.Page;
import com.lys.model.SessionInfo;
import com.lys.service.UserService;
import com.lys.util.PageBean;
import com.lys.util.Tool;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService; 
	
	/**
	 * 访问首页
	 */
	@RequestMapping("/index")
	public String enterIndex(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");
		if (sessionInfo == null) {
			return "/admin/login";
		}
		return "index";
	}
	/**
	 * 用户登录
	 */
	@ResponseBody
	@RequestMapping("/login")//声明请求的方法，默认为GET方法
	public Json login(User user,HttpSession session) throws Exception{
		Json j = new Json();
		User u = userService.get(user.getUserName(), user.getPassword());
		if (u != null) {
			//登录日志（记录登录时间，登录次数+1）
			u.setLoginTime(Tool.getCurrentTime());
			u.setLoginCount(u.getLoginCount()+1);
			userService.update(u);
			j.setSuccess(true);
			j.setMsg("登录成功！");
			//将用户信息存入SessionInfo
			SessionInfo sessionInfo = new SessionInfo();
			BeanUtils.copyProperties(u, sessionInfo);
			session.setAttribute("userName", user.getUserName());//用于解锁功能
			session.setAttribute("sessionInfo", sessionInfo);
		}else {
			j.setSuccess(false);
			j.setMsg("用户名或密码错误！");
		}
		return j;
	}
	/**
	 * 用户注册
	 */
	@ResponseBody
	@RequestMapping("/register")
	public Json register(User user,HttpSession session) {
		Json j = new Json();
		try {
			//TODO : 未设用户所处的机构
			user.setCreateTime(Tool.getCurrentTime());
			user.setLoginTime(Tool.getCurrentTime());
			user.setLoginCount(1);
			Integer userId = (Integer)userService.save(user);
			j.setSuccess(true);
			//将用户信息存入SessionInfo
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setUserId(userId);
			sessionInfo.setUserName(user.getUserName());
			session.setAttribute("userName", user.getUserName());//用于解锁功能
			session.setAttribute("sessionInfo", sessionInfo);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}
	/**
	 * 退出登录
	 * 
	 * @param session
	 * 
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session != null) {
			//退出系统日志
			SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");
			if (sessionInfo != null) {
				User user = userService.get(sessionInfo.getUserId());
				if (user != null) {
					user.setLastLoginTime(Tool.getCurrentTime());
					userService.update(user);
				}
			}
			session.invalidate();
		}
		return "/admin/login";
	}
	/**
	 * 用户登录时的autoComplete
	 * 
	 * @param q
	 *      
	 */
	@ResponseBody
	@RequestMapping("/loginCombobox")
	public List<MUser> loginCombobox(String q) {
		List<User> list = userService.find(q);
		return userService.copyList(list);
	}
	/**
	 * 用户登录时的combogrid
	 * @param q
	 * @param ph
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loginCombogrid")
	public DataGrid loginCombogrid(String q, Page page) {
		return userService.dataGrid(q,page);
	}
	/**
	 * 锁住窗口
	 * @param session
	 */
	@ResponseBody
	@RequestMapping("/lock")
	public boolean lock(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");
		if (sessionInfo != null) {
			session.setAttribute("sessionInfo", null);
			return true;
		}
		return false;
	}

}
