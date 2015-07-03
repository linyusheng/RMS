package com.lys.controller;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.entity.Rights;
import com.lys.model.DataGrid;
import com.lys.model.Json;
import com.lys.model.MRights;
import com.lys.model.Page;
import com.lys.service.RightsService;
import com.lys.util.Tool;


@Controller
@RequestMapping("/rights")
public class RightsController {
	
	@Autowired
	private RightsService rightsService;
	
	/**
	 * 获取权限列表
	 * @param page：EasyUI自动构造好传给后台
	 * @return DataGrid对象
	 */
	@ResponseBody
	@RequestMapping("/datagrid")
	public DataGrid dataGrid(Page page) {
		return rightsService.dataGrid(page);
	}
	/**
	 * 新增或修改权限
	 * 
	 * @param mRights
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Json addOrUpdate(MRights mRights) {
		Json json = new Json();
		Rights rights = new Rights();
		String[] ignores = {"createTime"};
		//如果rightsId为空，则新增权限,否则修改权限信息
		if(mRights.getRightsId() == null){
			BeanUtils.copyProperties(mRights, rights, ignores);
			rights.setCreateTime(Tool.getCurrentTime());
			rightsService.save(rights);
			json.setMsg("添加成功！");
		}else {
			rights = rightsService.get(mRights.getRightsId());
			BeanUtils.copyProperties(mRights, rights, ignores);
			rights.setCreateTime(Timestamp.valueOf(mRights.getCreateTime()));
			rightsService.save(rights);
			json.setMsg("修改成功！");
		}
		return json;
	}
	/**
	 * 删除权限
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
			rightsService.delete(Integer.valueOf(id));
		}
		return true;
	}

}
