package com.lys.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.entity.Role;
import com.lys.model.DataGrid;
import com.lys.model.Json;
import com.lys.model.MRole;
import com.lys.model.Page;
import com.lys.service.RoleService;
import com.lys.util.PageBean;
import com.lys.util.Tool;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 获取角色列表
	 * @param page：EasyUI自动构造好传给后台
	 * @return DataGrid对象
	 */
	@ResponseBody
	@RequestMapping("/datagrid")
	public DataGrid dataGrid(Page page) {
		return roleService.dataGrid(page);
	}
	/**
	 * 新增或修改角色
	 * 
	 * @param mRole
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Json addOrUpdate(MRole mRole) {
		Json json = new Json();
		Role role = new Role();
		String[] ignores = {"createTime"};
		//如果roleId为空，则新增角色,否则修改角色信息
		if(mRole.getRoleId() == null){
			BeanUtils.copyProperties(mRole, role, ignores);
			role.setCreateTime(Tool.getCurrentTime());
			roleService.save(role);
			json.setMsg("添加成功！");
		}else {
			role = roleService.get(mRole.getRoleId());
			BeanUtils.copyProperties(mRole, role, ignores);
			role.setCreateTime(Timestamp.valueOf(mRole.getCreateTime()));
			roleService.save(role);
			json.setMsg("修改成功！");
		}
		return json;
	}
	/**
	 * 删除角色
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
			roleService.delete(Integer.valueOf(id));
		}
		return true;
	}
}
