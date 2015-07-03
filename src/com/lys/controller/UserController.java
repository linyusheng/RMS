package com.lys.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.entity.User;
import com.lys.model.DataGrid;
import com.lys.model.Json;
import com.lys.model.Page;
import com.lys.model.SessionInfo;
import com.lys.model.MUser;
import com.lys.service.UserService;
import com.lys.util.PageBean;
import com.lys.util.Tool;

/**
 * 用户访问控制类
 * 
 * @author 林玉生
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取用户列表
	 * @param page：EasyUI自动构造好传给后台
	 * @return DataGrid对象
	 */
	@ResponseBody
	@RequestMapping("/datagrid")
	public DataGrid dataGrid(Page page) {
		return userService.dataGrid(page);
	}
	/**
	 * 新增或修改用户
	 * 
	 * @param userDataGrid
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Json addOrUpdate(MUser mUser) {
		Json json = new Json();
		User user = new User();
		String[] ignores = {"createTime","loginTime","lastLoginTime"};
		//如果userId为空，则新增用户,否则修改用户信息
		if(mUser.getUserId() == null){
			BeanUtils.copyProperties(mUser, user, ignores);
			user.setCreateTime(Tool.getCurrentTime());
			userService.save(user);
			json.setMsg("添加成功！");
		}else {
			user = userService.get(mUser.getUserId());
			BeanUtils.copyProperties(mUser, user, ignores);
			user.setCreateTime(Timestamp.valueOf(mUser.getCreateTime()));
			userService.save(user);
			json.setMsg("修改成功！");
		}
		return json;
	}
	/**
	 * 删除用户
	 * 
	 * @param ids
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public boolean delete(String ids) {
		String[] str = ids.split(",");
		for (String id : str) {
			userService.delete(Integer.valueOf(id));
		}
		return true;
	}
	/**
	 * 是否存在此用户名
	 */
	@ResponseBody
	@RequestMapping("/isUserNameExist")
	public Json isUserNameExist(String userName) {
		Json j = new Json();
		if (userService.get(userName) != null) {
			j.setMsg("用户名已存在！");
			j.setSuccess(true);
		}else {
			j.setMsg("该用户名可用！");
			j.setSuccess(false);
		}
		return j;
	}
	/**
	 * 修改密码
	 * @param oldPwd
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editPassword")
	public Json editPassword(String oldPwd,String pwd,HttpSession session) {
		Json j = new Json();
		//获取该用户的id
		SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");
		if (userService.savePassword(sessionInfo.getUserId(),oldPwd,pwd)) {
			j.setMsg("修改成功！");
			j.setSuccess(true);
		}else {
			j.setMsg("旧密码输入错误！");
			j.setSuccess(false);
		}
		return j;
	}
	/**
	 * 获取用户个人信息
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request, Integer id) {
		User user = userService.get(id);
		request.setAttribute("user", user);
		return "/user/userInfo";
	}
	
}
