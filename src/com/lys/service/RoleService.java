package com.lys.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.dao.RoleDAO;
import com.lys.entity.Role;
import com.lys.model.DataGrid;
import com.lys.model.MRole;
import com.lys.model.Page;
import com.lys.util.Tool;

@Service
public class RoleService implements BaseService<Role,MRole> {
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public Role get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Role o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Role o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MRole copyObject(Role o) {
		String[] ignores = {"createTime"};
		MRole m = new MRole();
		BeanUtils.copyProperties(o, m,ignores);
		m.setCreateTime(Tool.timestampToString(o.getCreateTime()));
		return m;
	}
	@Override
	public List<MRole> copyList(List<Role> list) {
		List<MRole> mList = new ArrayList<MRole>();
		for (Role role : list) {
			mList.add(copyObject(role));
		}
		return mList;
	}
	/**
	 * 获取角色列表
	 * @param pageBean
	 * @param sort
	 * @param order
	 * @return 
	 */
	public DataGrid dataGrid(Page page) {
		DataGrid dg = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sort", page.getSort());
		params.put("order", page.getOrder());
		String hql = "from Role order by :sort :order";
		List<Role> list = roleDAO.find(hql, params, page.getPage(), page.getRows());
		dg.setRows(copyList(list));
		dg.setTotal(roleDAO.count("select count(*) from Role", params));
		return dg;
	}

	
}
