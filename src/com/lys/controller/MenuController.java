package com.lys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.entity.Menu;
import com.lys.model.Tree;
import com.lys.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 根据前台传来的id，查找出相应的子节点，形成树菜单
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loadMenus")
	public List<Tree> loadMenus(Integer id) {
		List<Tree> treeList = new ArrayList<Tree>();
		List<Menu> menus = menuService.loadMenus(id);
		if (menus != null && menus.size() > 0) {
			for (Menu menu : menus) {
				Tree tree = new Tree();
				BeanUtils.copyProperties(menu, tree);
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("url", menu.getUrl());
				attr.put("pid",menu.getPid());
				tree.setAttributes(attr);
				treeList.add(tree);
			}
		}
		return treeList;
	}
	
	

}
