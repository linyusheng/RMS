package com.lys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.dao.MenuDAO;
import com.lys.entity.Menu;
import com.lys.model.Tree;

@Service
public class MenuService implements BaseService<Menu, Tree>{
	
	@Autowired
	private MenuDAO menuDAO;

	@Override
	public Menu get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Menu o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Menu o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tree copyObject(Menu o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tree> copyList(List<Menu> list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 加载菜单
	 */
	public List<Menu> loadMenus(Integer id) {
		String hql;
		if (id == null) {
			hql="from Menu as m where m.pid is null";
		} else {
			hql="from Menu as m where m.pid = '" + id + "'";
		}
		return menuDAO.find(hql);
	}
	

}
